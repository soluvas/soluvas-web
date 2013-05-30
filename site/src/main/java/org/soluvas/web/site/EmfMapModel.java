package org.soluvas.web.site;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

/**
 * For {@link Map}s of {@link EObject}s.
 * 
 * @author ceefour
 * @param <K> key (must not be an EObject)
 * @param <T>
 *            type of object value inside {@link Map}
 */
public class EmfMapModel<K extends Serializable, V extends EObject> extends LoadableDetachableModel<Map<K, V>> {
	private static final long serialVersionUID = 1L;
	private Map<K, IModel<V>> savedObjects;
	
	public EmfMapModel() {
		super();
	}

	public EmfMapModel(Map<K, V> map) {
		super(map);
	}

	@Override
	protected Map<K, V> load() {
		if (savedObjects != null) {
			return new HashMap<>(Maps.transformValues(savedObjects, new Function<IModel<V>, V>() {
				@Override @Nullable
				public V apply(@Nullable IModel<V> input) {
					return input.getObject();
				}
			}));
		} else {
			return null;
		}
	}
	
	@Override
	protected void onDetach() {
		final Map<K, V> origMap = getObject();
		if (origMap != null) {
			savedObjects = ImmutableMap.copyOf( Maps.transformValues(origMap, new Function<V, IModel<V>>() {
				@Override @Nullable
				public IModel<V> apply(@Nullable V input) {
					final EmfModel<V> emfModel = new EmfModel<>(input);
					emfModel.detach();
					return emfModel;
				}
			}));
		}
		super.onDetach();
	}

}