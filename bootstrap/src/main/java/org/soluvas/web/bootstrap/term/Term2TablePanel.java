package org.soluvas.web.bootstrap.term;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.wicket.Page;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.extensions.ajax.markup.html.repeater.data.table.AjaxFallbackDefaultDataTable;
import org.apache.wicket.extensions.markup.html.repeater.data.sort.SortOrder;
import org.apache.wicket.extensions.markup.html.repeater.data.table.IColumn;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.extensions.markup.html.repeater.util.SortableDataProvider;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.Kind;
import org.soluvas.data.Term;
import org.soluvas.data.Term2;
import org.soluvas.data.TermKind;
import org.soluvas.data.TermKindRepository;
import org.soluvas.mongo.MongoTermRepository;
import org.soluvas.web.site.widget.LinkColumn;
import org.soluvas.web.site.widget.TagType;

import com.google.common.collect.ImmutableList;

/**
 * List {@link Term}s for a {@link Kind}.
 * 
 * <pre>{@literal
 * @ManageMountPath("term/base/Color/")
 * public class ColorListPage extends AuthorizedMallPage {
 * 	
 * 	@SpringBean(name="colorTermRepo")
 * 	private TermRepository colorTermRepo;
 * 	
 * 	public ColorListPage(final PageParameters params) {
 * 		super(params);
 * 		add(new TermTablePanel("tablePanel", colorTermRepo, "base", "Color", "Colors",
 * 				ColorDetailPage.class));
 * 	}
 * 
 * }
 * }</pre>
 * 
 * @author anton
 */
@SuppressWarnings("serial")
public class Term2TablePanel extends Panel {
	
	@SpringBean
	private MongoTermRepository termRepo;
	@Inject
	private TermKindRepository termKindRepo;
	
	private static final Logger log = LoggerFactory.getLogger(Term2TablePanel.class);
	
	public Term2TablePanel(final String id, final IModel<TermKind> termKindModel,
			final Class<? extends Page> addPage, final Class<? extends Page> detailPage) {
		super(id);
		add(new Term2TableForm("form", termKindModel, addPage, detailPage));
	}
	
	private class Term2TableForm extends Form<Void> {
		
		public Term2TableForm(final String id, final IModel<TermKind> termKindModel,
				final Class<? extends Page> addPage, final Class<? extends Page> detailPage) {
			super(id);

			add(new AjaxLink<String>("addLink") {
				@Override
				public void onClick(AjaxRequestTarget target) {
					getRequestCycle().setResponsePage(addPage, new PageParameters().add("termKindId", termKindModel.getObject().getId()));
				}
			});
			
			final SortableDataProvider<Term2, String> termDp = new Term2SDP(termKindModel);
			termDp.setSort("name", SortOrder.ASCENDING);
			final List<IColumn<Term2, String>> columns = new ArrayList<>();
			columns.add(new LinkColumn<Term2, String>(new Model<>("ID"), "id", "id", detailPage,
					"formalId", "formalId").tag(TagType.CODE));
			columns.add(new PropertyColumn<Term2, String>(new Model<>("Display Name"), "name", "name"));
//			columns.add(new PropertyColumn<Term2, String>(new Model<>("Namespace"), "nsPrefix", "nsPrefix"));
			final AjaxFallbackDefaultDataTable<Term2, String> table = new AjaxFallbackDefaultDataTable<>("table", columns, termDp, 20);
			table.setOutputMarkupId(true);
			add(table);
			
			final DropDownChoice<TermKind> ddcTermKind = new DropDownChoice<>("ddcTermKind", termKindModel,
					new ListModel<>(ImmutableList.copyOf(termKindRepo.findAll())), new ChoiceRenderer<TermKind>() {
				@Override
				public String getDisplayValue(TermKind object) {
					return object.getName();
				}
				
				@Override
				public String getIdValue(TermKind object, int index) {
					return object.getId();
				}
			});
			ddcTermKind.add(new OnChangeAjaxBehavior() {
				@Override
				protected void onUpdate(AjaxRequestTarget target) {
					target.add(table);
				}
			});
			add(ddcTermKind);
		}
		
	}
	
}
