package org.soluvas.web.site.widget;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.util.MapModel;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.BasicEMap;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.EMap;
import org.soluvas.data.DataFactory;
import org.soluvas.data.DisplayAttribute;
import org.soluvas.data.Term2;
import org.soluvas.data.TermKindRepository;
import org.soluvas.data.TermValue;
import org.soluvas.data.Value;
import org.soluvas.mongo.MongoTermRepository;

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
public class DisplayAttributeListModel2 extends AbstractReadOnlyModel<List<DisplayAttribute>> {
	
	private static final long serialVersionUID = 1L;
	private final IModel<EMap<String, EList<Value<?>>>> sourceModel;
	private final IModel<Map<String, String>> sourceStrModel = new MapModel<>();
	
	@Inject
	private MongoTermRepository termRepo;
	@Inject
	private TermKindRepository termKindRepo;
	private String curLanguageTag;
	
	public DisplayAttributeListModel2(IModel<EMap<String, EList<Value<?>>>> sourceModel, String curLanguageTag) {
		super();
		this.sourceModel = sourceModel;
		this.sourceStrModel.setObject(ImmutableMap.<String, String>of());
		this.curLanguageTag = curLanguageTag;
		
		Injector.get().inject(this);
	}
	
	public DisplayAttributeListModel2(Map<String, String> sourceStrMap, String curLanguageTag) {
		super();
		
		this.sourceModel = new LoadableDetachableModel<EMap<String,EList<Value<?>>>>() {
			@Override
			protected EMap<String, EList<Value<?>>> load() {
				return null;
			}
		};
		this.sourceStrModel.setObject(sourceStrMap);
		this.curLanguageTag = curLanguageTag;
		
		Injector.get().inject(this);
	}

	@Override
	public List<DisplayAttribute> getObject() {
		EMap<String, EList<Value<?>>> source = null;
		if (sourceModel.getObject() != null) {
			source = sourceModel.getObject();
		}
		if (sourceStrModel.getObject() != null && !sourceStrModel.getObject().isEmpty()) {
			source = new BasicEMap<String, EList<Value<?>>>();
			for (final Entry<String, String> entry : sourceStrModel.getObject().entrySet()) {
				final Term2 term2 = termRepo.findOne(entry.getValue());
				if (term2 != null) {
					final TermValue termValue = DataFactory.eINSTANCE.createTermValue();
					termValue.copyFromMongo(term2);
					final EList<Value<?>> values = new BasicEList<>();
					values.add(termValue);
					source.put(term2.getEnumerationId(), values);
				}
			}
		}
		
		if (source != null) {
			final List<DisplayAttribute> displayAttrs = new ArrayList<>();
			for (Entry<String, EList<Value<?>>> entry : source.entrySet()) {
				// TODO: do not hardcode principal displayName, get from mixin
				final String principalDisplayName = termKindRepo.findOne(entry.getKey()).getEffectiveName(curLanguageTag);
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
