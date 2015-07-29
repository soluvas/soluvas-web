package org.soluvas.web.bootstrap.category;

import java.util.List;

import javax.measure.unit.NonSI;
import javax.measure.unit.SI;
import javax.measure.unit.Unit;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.data.PropertyDefinitionRepository;
import org.soluvas.data.PropertyKind;

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
public class propertyOverridesListView extends ListView<PropertyDefinition> {
	
	final ImmutableList<Unit<?>> SUPPORTED_UNITS = ImmutableList.of(SI.CENTIMETRE, SI.METER, SI.GRAM, NonSI.LITRE, SI.MILLI(NonSI.LITRE));
	
	@SpringBean
	private PropertyDefinitionRepository propDefRepo;

	private final IModel<List<String>> defaultEnumsModel;
	
	public propertyOverridesListView(final String id, final IModel<List<PropertyDefinition>> model) {
		super(id, model);
		this.defaultEnumsModel = new ListModel<>(ImmutableList.copyOf(propDefRepo.getDefaultEnums()));
	}
	
	@Override
	protected void populateItem(ListItem<PropertyDefinition> item) {
		item.add(new Label("name", new PropertyModel<String>(item.getModel(), "name")));
		
		final CheckBox enabled = new CheckBox("enabled", new PropertyModel<Boolean>(item.getModel(), "enabled"));
		enabled.add(new OnChangeAjaxBehavior() {
			
			@Override
			protected void onUpdate(AjaxRequestTarget target) {
				updatePropertyOverride(item.getModelObject());
			}
		});
		item.add(enabled);
		
		final DropDownChoice<PropertyKind> ddcDefaultKind = new DropDownChoice<>("ddcDefaultKind", new PropertyModel<>(item.getModel(), "defaultKind"),
				new ListModel<>(ImmutableList.copyOf(PropertyKind.values())),
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
		
//		item.getModelObject().getDefaulte
	}
	
	protected void updatePropertyOverride(PropertyDefinition upPropertyOv) {
	}

}
