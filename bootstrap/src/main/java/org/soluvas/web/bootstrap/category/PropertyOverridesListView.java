package org.soluvas.web.bootstrap.category;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Nullable;
import javax.inject.Inject;
import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.ListModel;
import org.soluvas.commons.AppManifest;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.data.PropertyDefinitionRepository;
import org.soluvas.data.PropertyKind;
import org.soluvas.web.site.OnChangeThrottledBehavior;

import com.google.common.base.Objects;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

/**
 * <ul>
		<li wicket:id="propertyOverrides">
			Name: <span wicket:id="name"></span>
			<br/>
			Enabled: <input wicket:id="enabled" type="checkbox" value="Enabled">
			<br/>
			Default Kind: <select wicket:id="ddcDefaultKind"></select>
			<br/>
			<div wicket:id="measurementUnit">
				Unit: <select wicket:id="selMeasurementUnit"></select>
    			<br/>
			</div>
			=====================
		</li>
	</ul>
 * 
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class PropertyOverridesListView extends ListView<PropertyDefinition> {
	
	final ImmutableList<Unit<?>> SUPPORTED_UNITS = ImmutableList.of(SI.CENTIMETRE, SI.METRE, SI.GRAM, NonSI.LITRE, NonSI.LITRE.divide(1000));
	
	@Inject
	private PropertyDefinitionRepository propDefRepo;
	@Inject
	private AppManifest appManifest;

	private final IModel<List<String>> defaultEnumsModel;

	private final IModel<Locale> selectedLocaleModel;

	private final IModel<Locale> categoryLocaleModel;
	
	public PropertyOverridesListView(final String id, final IModel<List<PropertyDefinition>> model,
			final IModel<Locale> selectedLocaleModel,
			final IModel<Locale> categoryLocaleModel) {
		super(id, model);
		this.defaultEnumsModel = new ListModel<>(ImmutableList.copyOf(propDefRepo.getDefaultEnums()));
		this.selectedLocaleModel = selectedLocaleModel;
		this.categoryLocaleModel = categoryLocaleModel;
	}
	
	@Override
	protected void populateItem(ListItem<PropertyDefinition> item) {
		final IModel<String> nameModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
					return item.getModelObject().getName();
				} else {
					if (item.getModelObject().getTranslations() != null && !item.getModelObject().getTranslations().isEmpty()) {
						if (item.getModelObject().getTranslations().containsKey(selectedLocale.toLanguageTag()) &&
								item.getModelObject().getTranslations().get(selectedLocale.toLanguageTag()).containsKey(PropertyDefinition.NAME_ATTR)) {
							return item.getModelObject().getTranslations().get(selectedLocale.toLanguageTag()).get(PropertyDefinition.NAME_ATTR);
						} else {
							return null;
						}
					} else {
						return null;
					}
				}
			}
		};
		
		final TextField<String> nameTxt = new TextField<String>("name", nameModel){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				if (Objects.equal(selectedLocaleModel.getObject(), appManifest.getDefaultLocale())) {
					add(new AttributeModifier("class", "form-control"));
				} else {
					add(new AttributeModifier("class", "form-control focus"));
				}
			}
		};
		nameTxt.setRequired(true);
		nameTxt.setLabel(new Model<>("Name property override"));
		nameTxt.add(new OnChangeThrottledBehavior("onchange") {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final PropertyDefinition propertyDef = item.getModelObject();
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
					propertyDef.setName(nameModel.getObject());
				} else {
					updateAttributeTranslations(item.getModel(),
							selectedLocale, PropertyDefinition.NAME_ATTR, nameModel.getObject());
				}
			}
		});
		item.add(nameTxt);
		
		final IModel<String> descriptionModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
					return item.getModelObject().getDescription();
				} else {
					if (item.getModelObject().getTranslations() != null && !item.getModelObject().getTranslations().isEmpty()) {
						if (item.getModelObject().getTranslations().containsKey(selectedLocale.toLanguageTag()) &&
								item.getModelObject().getTranslations().get(selectedLocale.toLanguageTag()).containsKey(PropertyDefinition.DESCRIPTION_ATTR)) {
							return item.getModelObject().getTranslations().get(selectedLocale.toLanguageTag()).get(PropertyDefinition.DESCRIPTION_ATTR);
						} else {
							return null;
						}
					} else {
						return null;
					}
				}
			}
		};
		
		final TextArea<String> descriptionTxt = new TextArea<String>("description", descriptionModel){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				if (Objects.equal(selectedLocaleModel.getObject(), appManifest.getDefaultLocale())) {
					add(new AttributeModifier("class", "form-control"));
				} else {
					add(new AttributeModifier("class", "form-control focus"));
				}
			}
		};
		descriptionTxt.setLabel(new Model<>("Description property override"));
		descriptionTxt.add(new OnChangeThrottledBehavior("onchange") {
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				final PropertyDefinition propertyDef = item.getModelObject();
				final Locale selectedLocale = selectedLocaleModel.getObject();
				final Locale categoryLocale = categoryLocaleModel.getObject();
				if (Objects.equal(selectedLocale, categoryLocale)) {
					propertyDef.setDescription(descriptionModel.getObject());
				} else {
					updateAttributeTranslations(item.getModel(),
							selectedLocale, PropertyDefinition.DESCRIPTION_ATTR, descriptionModel.getObject());
				}
			}
		});
		item.add(descriptionTxt);
		
		final CheckBox enabled = new CheckBox("enabled", new PropertyModel<Boolean>(item.getModel(), "enabled"));
		enabled.add(new OnChangeAjaxBehavior() {
			
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				updatePropertyOverride(item.getModelObject());
			}
		});
		item.add(enabled);
		
		final DropDownChoice<PropertyKind> ddcDefaultKind = new DropDownChoice<>("ddcDefaultKind", new PropertyModel<>(item.getModel(), "defaultKind"),
				new ListModel<>(ImmutableList.of(PropertyKind.ENUMERATION, PropertyKind.MEASUREMENT, PropertyKind.STRING)),
				new IChoiceRenderer<PropertyKind>() {

					@Override
					public Object getDisplayValue(PropertyKind object) {
						return object.name();
					}

					@Override
					public String getIdValue(PropertyKind object, int index) {
						return object.name();
					}
				});
		ddcDefaultKind.add(new OnChangeAjaxBehavior() {
			
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				updatePropertyOverride(item.getModelObject());
			}
		});
		item.add(ddcDefaultKind);
		
		final WebMarkupContainer measurementUnit = new WebMarkupContainer("measurementUnit"){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(item.getModelObject().getDefaultKind() == PropertyKind.MEASUREMENT);
			}
		};
		final DropDownChoice<Unit<?>> selMeasurementUnit = new DropDownChoice<>("selMeasurementUnit", new PropertyModel<Unit<?>>(item.getModel(), "defaultUnit"),
				new ListModel<>(SUPPORTED_UNITS), new IChoiceRenderer<Unit<?>>() {

					@Override
					public Object getDisplayValue(Unit<?> object) {
						return object.toString();
					}

					@Override
					public String getIdValue(Unit<?> object, int index) {
						return object.toString();
					}
				});
		measurementUnit.add(selMeasurementUnit);
		item.add(measurementUnit);
		
		final WebMarkupContainer defaultEnum = new WebMarkupContainer("defaultEnum"){
			@Override
			protected void onConfigure() {
				super.onConfigure();
				setVisible(item.getModelObject().getDefaultKind() == PropertyKind.ENUMERATION);
			}
		};
		final DropDownChoice<String> selDefaultEnum = new DropDownChoice<>("selDefaultEnum", new PropertyModel<String>(item.getModel(), "defaultEnum"),
				defaultEnumsModel, new IChoiceRenderer<String>() {

					@Override
					public Object getDisplayValue(String object) {
						return object;
					}

					@Override
					public String getIdValue(String object, int index) {
						return object;
					}
				});
		defaultEnum.add(selDefaultEnum);
		item.add(defaultEnum);
		
		item.getModelObject().getTranslations();
	}
	
	private void updateAttributeTranslations(final IModel<PropertyDefinition> model,
			final Locale selectedLocale, final String attribute,
			@Nullable final String upValue) {
		if (model.getObject().getTranslations().containsKey(selectedLocale.toLanguageTag())) {
			final Map<String, String> translation = model.getObject().getTranslations().get(selectedLocale.toLanguageTag());
			if (!Strings.isNullOrEmpty(upValue)) {
				translation.put(attribute, upValue);
			} else {
				translation.remove(attribute);
			}
		} else {
			final Map<String, String> newTranslation = new HashMap<>();
			newTranslation.put(attribute, upValue);
			model.getObject().getTranslations().put(selectedLocale.toLanguageTag(), newTranslation);
		}
	}
	
	protected void updatePropertyOverride(PropertyDefinition upPropertyOv) {
	}

}
