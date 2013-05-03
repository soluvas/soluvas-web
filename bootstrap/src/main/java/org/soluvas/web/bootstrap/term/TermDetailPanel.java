package org.soluvas.web.bootstrap.term;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.extensions.ajax.markup.html.IndicatingAjaxButton;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.Term;
import org.soluvas.data.TermRepository;
import org.soluvas.data.impl.TermImpl;
import org.soluvas.web.bootstrap.widget.ColorPickerTextField;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;

/**
 * View/edit a {@link Term}, only editable if nsPrefix != base.
 * <p>Use e.g. @WicketMountPoint(mountPoint="term/base/Color/${uName}")
 * <pre>{@literal
 * @WicketMountPoint(mountPoint="term/base/Color/${uName}/")
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
@SuppressWarnings("serial")
public class TermDetailPanel extends GenericPanel<Term> {
	
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
		setModel(new Model<Term>(term));
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
		super(id, new Model<>(
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
		nameFld.setRequired(true);
		nameFld.setEnabled(editable);
		nameFld.add(new OnChangeAjaxBehavior() {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				target.add(uNameLabel);
			}
		});
		form.add(nameFld);
		form.add(new TextField<>("displayName", new PropertyModel<>(getModel(), "displayName")).setRequired(true).setEnabled(editable));
		form.add(new TextField<>("imageId", new PropertyModel<>(getModel(), "imageId")).setEnabled(editable));
		final IModel<Boolean> colorUsed = new Model<>(getModelObject().getColor() != null);
		final ColorPickerTextField colorFld = new ColorPickerTextField("color", new PropertyModel<String>(getModel(), "color")) {
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setEnabled(colorUsed.getObject());
			}
		};
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
		
		final IndicatingAjaxButton saveBtn = new IndicatingAjaxButton("saveBtn", form) {
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Term term = TermDetailPanel.this.getModelObject();
				if (!Optional.fromNullable(colorUsed.getObject()).or(false)) {
					term.setColor(null);
				}
				switch (editMode) {
				case ADD:
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
		
		final IndicatingAjaxButton deleteBtn = new IndicatingAjaxButton("deleteBtn", form) {
			@Override
			protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
				super.updateAjaxAttributes(attributes);
				attributes.getAjaxCallListeners().add(new AjaxCallListener() {
					@Override
					public CharSequence getPrecondition(Component component) {
						return "return confirm(\"Do you want to delete term '" + originalUName + "'?\")";
					}
				});
			}
			
			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {
				super.onSubmit(target, form);
				final Term term = TermDetailPanel.this.getModelObject();
				if (!Optional.fromNullable(colorUsed.getObject()).or(false)) {
					term.setColor(null);
				}
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
