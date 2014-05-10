package org.soluvas.web.bootstrap.term;

import javax.annotation.Nullable;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.ajax.json.JSONObject;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.Term;
import org.soluvas.data.TermRepository;
import org.soluvas.data.impl.TermImpl;
import org.soluvas.web.bootstrap.widget.ColorPickerTextField;
import org.soluvas.web.site.EmfModel;
import org.soluvas.web.site.OnChangeThrottledBehavior;
import org.soluvas.web.site.widget.AutoDisableAjaxButton;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;

/**
 * View/edit a {@link Term}, only editable if nsPrefix != base.
 * <p>Use e.g. @ManageMountPath("term/base/Color/${uName}")
 * <pre>{@literal
 * @ManageMountPath("term/base/Color/${uName}/")
 * public class ColorDetailPage extends AuthorizedMallPage {
 * 	
 * 	@SpringBean(name="colorTermRepo")
 * 	private TermRepository colorTermRepo;
 * 	
 * 	public ColorDetailPage(final PageParameters params) {
 * 		super(params);
 * 		final String uName = params.get("uName").toString();
 * 		add(new TermDetailPanel("detail", colorTermRepo, uName, "base", "Color", "Colors", ColorListPage.class));
 * 	}
 * 	
 * }
 * }</pre>
 * 
 * @author ceefour
 */
public class TermDetailPanel extends GenericPanel<Term> {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory
			.getLogger(TermDetailPanel.class);
	
	private enum EditMode {
		ADD,
		MODIFY
	}
	private final String kindDisplayName;
	private final Class<? extends Page> backPage;
	@SpringBean
	private TenantRef tenant;
	private final TermRepository termRepo;
	private final EditMode editMode;
	private final String originalUName;

	/**
	 * For creating a new {@link Term}. The nsPrefix is always the tenantId.
	 * @param id
	 * @param termRepo MUST be Serializable or a Wicket-friendly injection.
	 * @param uName
	 * @param kindNsPrefix
	 * @param kindName
	 * @param kindDisplayName
	 * @param backPage
	 */
	public TermDetailPanel(String id, TermRepository termRepo, final String kindNsPrefix, final String kindName, String kindDisplayName,
			final Class<? extends Page> backPage) {
		super(id);
		this.editMode = EditMode.ADD;
		this.originalUName = null;
		this.termRepo = termRepo;
		this.kindDisplayName = kindDisplayName;
		this.backPage = backPage;
		final TermImpl term = new TermImpl();
		term.setKindNsPrefix(kindNsPrefix);
		term.setKindName(kindName);
		term.setNsPrefix(tenant.getTenantId());
		setModel(new EmfModel<Term>(term));
	}

	/**
	 * For viewing or editing an existing {@link Term}.
	 * @param id
	 * @param termRepo MUST be Serializable or a Wicket-friendly injection.
	 * @param uName
	 * @param kindNsPrefix
	 * @param kindName
	 * @param kindDisplayName
	 * @param backPage
	 */
	public TermDetailPanel(String id, TermRepository termRepo, String uName, final String kindNsPrefix, final String kindName, String kindDisplayName,
			final Class<? extends Page> backPage) {
		super(id, new EmfModel<>(
				Preconditions.checkNotNull(termRepo.findOne(uName),
						"Cannot find term %s using %s", uName, termRepo)
			));
		this.editMode = EditMode.MODIFY;
		this.termRepo = termRepo;
		this.originalUName = uName;
		this.kindDisplayName = kindDisplayName;
		this.backPage = backPage;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		final boolean editable = !"base".equals(getModelObject().getNsPrefix());
		add(new Label("kind", kindDisplayName));
		add(new BookmarkablePageLink<>("backLink", backPage));
		
		final Label uNameLabel = new Label("termUName", new PropertyModel<>(getModel(), "qName"));
		uNameLabel.setOutputMarkupId(true);
		add(uNameLabel);
		
		final Form<Void> form = new Form<Void>("form");
		add(form);
		
		form.add(new Label("nsPrefix", new PropertyModel<>(getModel(), "nsPrefix")));
		final TextField<String> nameFld = new TextField<>("name", new PropertyModel<String>(getModel(), "name"));
		nameFld.setEnabled(false);
		nameFld.setOutputMarkupId(true);
		form.add(nameFld);
		final Component displayNameFld = new TextField<>("displayName", new PropertyModel<>(getModel(), "displayName")).setRequired(true).setEnabled(editable);
		displayNameFld.add(new OnChangeThrottledBehavior() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final String id = SlugUtils.generateValidId(getModelObject().getDisplayName(),
						new Predicate<String>() {
							@Override
							public boolean apply(@Nullable String input) {
								return !termRepo.exists(getModelObject().getNsPrefix() + "_" + input);
							}
						});
				getModelObject().setName(id);
				target.add(nameFld, uNameLabel);
			}
		});
		form.add(displayNameFld);
		form.add(new TextField<String>("imageId", new PropertyModel<String>(getModel(), "imageId")){
			private static final long serialVersionUID = 1L;

			@Override
			protected void onConfigure() {
				super.onConfigure();
				setEnabled(editable);
				final Subject subject = SecurityUtils.getSubject();
				final boolean isSysadmin = subject.isPermitted("sysadmin");
				setVisible( isSysadmin );
			}
		});
		final IModel<Boolean> colorUsed = new Model<>(getModelObject().getColor() != null);
		final PropertyModel<String> colorModel = new PropertyModel<>(getModel(), "color");
		final Label colorBox = new Label("colorBox");
		colorBox.setOutputMarkupId(true);
		colorBox.add(new AttributeModifier("style", new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				return "background-color: " + Optional.fromNullable(colorModel.getObject()).or("white") + ";";
			}
		}));
		form.add(colorBox);
		final ColorPickerTextField colorFld = new ColorPickerTextField("color", colorModel) {
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setEnabled(editable && colorUsed.getObject());
			}
		};
		// 'change' event doesn't work, neither does OnChangeAjaxBehavior, dunno why
		colorFld.add(new AjaxFormComponentUpdatingBehavior("blur") {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				target.add(colorBox);
			}
		});
		colorFld.setOutputMarkupId(true);
		colorFld.setEnabled(editable);
		form.add(colorFld);
		final CheckBox colorUsedFld = new CheckBox("colorUsed", colorUsed);
		colorUsedFld.add(new OnChangeAjaxBehavior() {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				target.add(colorFld);
			}
		});
		colorUsedFld.setEnabled(editable);
		form.add(colorUsedFld);
		
		final IndicatingAjaxButton saveBtn = new AutoDisableAjaxButton("saveBtn", form) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Term term = TermDetailPanel.this.getModelObject();
				if (!Optional.fromNullable(colorUsed.getObject()).or(false)) {
					term.setColor(null);
				}
				switch (editMode) {
				case ADD:
					final String id = SlugUtils.generateValidId(term.getDisplayName(),
							new Predicate<String>() {
								@Override
								public boolean apply(@Nullable String input) {
									return !termRepo.exists(term.getNsPrefix() + "_" + input);
								}
							});
					term.setName(id);
					termRepo.add(term);
					info("Added term " + term.getQName());
					break;
				case MODIFY:
					termRepo.modify(originalUName, term);
					info("Modified term " + term.getQName());
					break;
				}
				setResponsePage(backPage);
			}
		};
		saveBtn.setEnabled(editable);
		add(saveBtn);
		
		final IndicatingAjaxButton deleteBtn = new AutoDisableAjaxButton("deleteBtn", form) {
			private static final long serialVersionUID = 1L;

			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
				super.updateAjaxAttributes(attributes);
				attributes.getAjaxCallListeners().add(new AjaxCallListener() {
					@Override
					public CharSequence getPrecondition(Component component) {
						return "return confirm('Do you want to delete term ' + " + JSONObject.quote(originalUName) + " + '?')";
					}
				});
			}
			
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Term term = TermDetailPanel.this.getModelObject();
//				if (!Optional.fromNullable(colorUsed.getObject()).or(false)) {
					term.setColor(null);
//				}
				termRepo.delete(originalUName);
				warn("Deleted term " + originalUName);
				setResponsePage(backPage);
			}
		};
		deleteBtn.setEnabled(editable);
		deleteBtn.setVisible(editMode == EditMode.MODIFY);
		add(deleteBtn);
		
	}
	
}
