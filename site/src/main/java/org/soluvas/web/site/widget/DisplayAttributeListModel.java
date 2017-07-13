package org.soluvas.web.site.widget;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.annotation.Nullable;
import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.util.MapModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.DisplayAttribute;
import org.soluvas.data.EntityLookupException;
import org.soluvas.data.PropertyDefinition;
import org.soluvas.data.PropertyDefinitionRepository;
import org.soluvas.data.entity.Value;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

/**
 * Used to convert between EMap<String, EList<Value<?>>> to
 * a {@link DisplayAttribute} list usable by {@link DisplayAttributeListPanel}.
 * <p>Usage:
 * <pre>{@literal
 * final IModel<List<DisplayAttribute>> displayAttrsModel = new DisplayAttributeListModel(
 * 		new PropertyModel<EMap<String, EList<Value<?>>>>(item.getModel(), "variant.principals")); 
 * item.add(new DisplayAttributeListPanel("principals", displayAttrsModel));
 * }</pre>
 * 
 * @author rudi
 */
public class DisplayAttributeListModel extends AbstractReadOnlyModel<List<DisplayAttribute>> {
	
	private static final long serialVersionUID = 1L;
	
	private static final Logger log = LoggerFactory.getLogger(DisplayAttributeListModel.class);
	
	@Inject
	private PropertyDefinitionRepository propDefRepo;
	
	private final IModel<Map<String, List<Value<?>>>> sourceModel;
	private final IModel<Map<String, List<String>>> sourceStrModel = new MapModel<>();
	
	public DisplayAttributeListModel(IModel<Map<String, List<Value<?>>>> sourceModel) {
		super();
		this.sourceModel = sourceModel;
		this.sourceStrModel.setObject(ImmutableMap.<String, List<String>>of());
		
		Injector.get().inject(this);
	}
	
	public DisplayAttributeListModel(Map<String, List<String>> sourceStrMap) {
		super();
		
		this.sourceModel = new LoadableDetachableModel<Map<String,List<Value<?>>>>() {
			@Override
			protected Map<String, List<Value<?>>> load() {
				return null;
			}
		};
		this.sourceStrModel.setObject(sourceStrMap);
		
		Injector.get().inject(this);
	}

	@Override
	public List<DisplayAttribute> getObject() {
		Map<String, List<String>> source = null;
		if (sourceModel.getObject() != null) {
			source = new HashMap<>();
			for (final Entry<String, List<Value<?>>> entry : sourceModel.getObject().entrySet()) {
				source.put(entry.getKey(), entry.getValue().stream().map(new Function<Value<?>, String>() {
					@Override
					public String apply(Value<?> t) {
						return t.getString();
					}
				}).collect(Collectors.toList()));
			}
		}
		if (sourceStrModel.getObject() != null && !sourceStrModel.getObject().isEmpty()) {
			source = sourceStrModel.getObject();
		}
		
		if (source != null) {
			final List<DisplayAttribute> displayAttrs = new ArrayList<>();
			for (final Entry<String, List<String>> entry : source.entrySet()) {
				final String keyOfPropDefByOptionPropKey = entry.getKey().replace("base_", "");
				try {
					@Nullable PropertyDefinition propertyDefinition = propDefRepo.findOneBase(keyOfPropDefByOptionPropKey);
					if (propertyDefinition != null) {
						displayAttrs.add(new DisplayAttribute(propertyDefinition, entry.getValue()));
					}
				} catch (EntityLookupException e) {
					log.error(String.format("Can not find propertyDefinition by id '%s'", keyOfPropDefByOptionPropKey), e);
				}
			}
			return displayAttrs;
		} else {
			return ImmutableList.of();
		}
	}

}
