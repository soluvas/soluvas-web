package org.soluvas.web.site.widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.util.MapModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.soluvas.data.DisplayAttribute;
import org.soluvas.data.Term;
import org.soluvas.data.TermRepository;
import org.soluvas.data.Value;

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
 * @author haidar
 */
public class DisplayAttributeListModel extends AbstractReadOnlyModel<List<DisplayAttribute>> {
	
	private static final long serialVersionUID = 1L;
	private final IModel<EMap<String, EList<Value<?>>>> sourceModel;
	private final IModel<Map<String, String>> sourceStrModel = new MapModel<>();
	
	@SpringBean(name="colorTermRepo")
	private TermRepository colorTermRepo;
	@SpringBean(name="sizeTermRepo")
	private TermRepository sizeTermRepo;
	
	public DisplayAttributeListModel(IModel<EMap<String, EList<Value<?>>>> sourceModel) {
		super();
		this.sourceModel = sourceModel;
		this.sourceStrModel.setObject(ImmutableMap.<String, String>of());
		
		Injector.get().inject(this);
	}
	
	public DisplayAttributeListModel(Map<String, String> sourceStrMap) {
		super();
		
		this.sourceModel = new LoadableDetachableModel<EMap<String,EList<Value<?>>>>() {
			@Override
			protected EMap<String, EList<Value<?>>> load() {
				return null;
			}
		};
		this.sourceStrModel.setObject(sourceStrMap);
		
		Injector.get().inject(this);
	}

	@SuppressWarnings("null")
	@Override
	public List<DisplayAttribute> getObject() {
		EMap<String, EList<Value<?>>> source = null;
		if (sourceModel.getObject() != null) {
			source = sourceModel.getObject();
		}
		if (sourceStrModel.getObject() != null && !sourceStrModel.getObject().isEmpty()) {
			source = new BasicEMap<String, EList<Value<?>>>();
			for (final Entry<String, String> entry : sourceStrModel.getObject().entrySet()) {
				switch (entry.getKey()) {
				case "base_color":
					final Term colorTerm = colorTermRepo.findOne(entry.getValue());
					final EList<Value<?>> colorValues = new BasicEList<Value<?>>();
					colorValues.add(colorTerm.toValue());
					source.put("base_color", colorValues);
					break;
				case "base_size":
					final Term sizeTerm = sizeTermRepo.findOne(entry.getValue());
					final EList<Value<?>> sizeValues = new BasicEList<Value<?>>();
					sizeValues.add(sizeTerm.toValue());
					source.put("base_size", sizeValues);
					break;
				default:
					throw new RuntimeException(String.format("Unrecognize principal type %s (%s)", entry.getKey(), entry.getValue()));
				}
			}
		}
		
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
