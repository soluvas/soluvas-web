package org.soluvas.web.site.widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.soluvas.data.DisplayAttribute;
import org.soluvas.data.Value;

import com.google.common.collect.ImmutableList;

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
 * @author haidar
 */
@SuppressWarnings("serial")
public class DisplayAttributeListModel extends AbstractReadOnlyModel<List<DisplayAttribute>> {
	
	private final IModel<EMap<String, EList<Value<?>>>> sourceModel;
	
	public DisplayAttributeListModel(
			IModel<EMap<String, EList<Value<?>>>> sourceModel) {
		super();
		this.sourceModel = sourceModel;
	}

	@Override
	public List<DisplayAttribute> getObject() {
		final EMap<String, EList<Value<?>>> source = sourceModel.getObject();
		if (source != null) {
			final List<DisplayAttribute> displayAttrs = new ArrayList<>();
			for (Entry<String, EList<Value<?>>> entry : source.entrySet()) {
				// TODO: do not hardcode principal displayName, get from mixin
				final String principalDisplayName;
				switch (entry.getKey()) {
				case "base_color":
					principalDisplayName = "Color";
					break;
				case "base_size":
					principalDisplayName = "Size";
					break;
				default:
					principalDisplayName = entry.getKey();
				}
				if (!entry.getValue().isEmpty()) {
					displayAttrs.add(new DisplayAttribute(principalDisplayName, entry.getValue().get(0)));
				} else {
					displayAttrs.add(new DisplayAttribute(principalDisplayName, null));
				}
			}
			return displayAttrs;
		} else {
			return ImmutableList.of();
		}
	}

}
