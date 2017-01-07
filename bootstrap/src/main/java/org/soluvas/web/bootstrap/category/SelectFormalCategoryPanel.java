package org.soluvas.web.bootstrap.category;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.category.FormalCategory;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class SelectFormalCategoryPanel extends GenericPanel<FormalCategory> {
	
	private static final Logger log = LoggerFactory
			.getLogger(SelectFormalCategoryPanel.class);
	
	public SelectFormalCategoryPanel(final String id, final IModel<FormalCategory> formalCatModel,
			final CategoryDetailPanel2 detailPanel) {
		super(id, formalCatModel);
		add(new SelectFormalCategoryForm("form", formalCatModel, detailPanel));
	}
	
	private class SelectFormalCategoryForm extends Form<FormalCategory> {
		
		public SelectFormalCategoryForm(final String id, final IModel<FormalCategory> formalCatModel,
				CategoryDetailPanel2 detailPanel) {
			super(id, formalCatModel);
			final FormalCategorySelect2 acFormalCategory = new FormalCategorySelect2("acFormalCategory", formalCatModel);
			acFormalCategory.setLabel(new Model<>("Formal Category"));
//			acFormalCategory.getSettings().setMinimumInputLength(3);	
			acFormalCategory.setRequired(true);
			acFormalCategory.add(new AjaxFormComponentUpdatingBehavior("change") {
				
				@Override
				protected void onUpdate(AjaxRequestTarget target) {
					detailPanel.getModelObject().setGoogleFormalId(formalCatModel.getObject().getGoogleId());
					if (formalCatModel.getObject().getPropertyOverrides() != null && !formalCatModel.getObject().getPropertyOverrides().isEmpty()) {
						detailPanel.getModelObject().getPropertyOverrides().addAll(formalCatModel.getObject().getPropertyOverrides());
					}
					detailPanel.addCurPropertyOverrides(detailPanel.getModelObject().getPropertyOverrides());
					log.debug("Selected Formal Category is {} ({}) with {} propertyOverrides",
							formalCatModel.getObject().getName(), detailPanel.getModelObject().getGoogleFormalId(), detailPanel.getModelObject().getPropertyOverrides().size());
					afterSubmitFormalCategory(target);
				}
			});
			add(acFormalCategory);
		}
		
	}
	
	protected void afterSubmitFormalCategory(AjaxRequestTarget target) {
	}
	

}
