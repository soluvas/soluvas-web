package org.soluvas.web.site;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
	/**
	 * A list larger than this (bytes) will be logged WARN and should not be stored in {@link EmfListModel}.
	 */
	public static final long LARGE_THRESHOLD = 300 * 1024;
	private static final Logger log = LoggerFactory
			.getLogger(EmfMapModel.class);
	private static final long serialVersionUID = 1L;
	private Map<K, EmfModel<V>> savedObjects;
	
	public EmfMapModel() {
		super();
	}

	public EmfMapModel(Map<K, V> map) {
		super(map);
	}

	@Override
	protected Map<K, V> load() {
		if (savedObjects != null) {
			log.trace("Loading EmfMapModel from savedObjects: {}", savedObjects.keySet());
			return new HashMap<>(Maps.transformValues(savedObjects, new Function<IModel<V>, V>() {
				@Override @Nullable
				public V apply(@Nullable IModel<V> input) {
					return input.getObject();
				}
			}));
		} else {
			log.trace("EmfMapModel has no savedObjects, returning null");
			return null;
		}
	}
	
	@Override
	protected void onDetach() {
		final Map<K, V> origMap = getObject();
		if (origMap != null) {
			savedObjects = ImmutableMap.copyOf( Maps.transformValues(origMap, new Function<V, EmfModel<V>>() {
				@Override @Nullable
				public EmfModel<V> apply(@Nullable V input) {
					final EmfModel<V> emfModel = new EmfModel<>(input);
					emfModel.detach();
					return emfModel;
				}
			}));
			log.trace("Saving EmfMapModel to savedObjects: {}", savedObjects.keySet());
			long totalBufSize = 0;
			for (EmfModel<V> obj : savedObjects.values()) {
				totalBufSize += obj.getBufSize();
			}
			if (totalBufSize > LARGE_THRESHOLD) {
				log.warn("Map of {} objects is too large ({} bytes): {}",
						savedObjects.size(), totalBufSize,
						Maps.transformValues(origMap, EmfModel.EOBJECT_TO_STRING));
			}
		} else {
			log.trace("Not saving EmfMapModel because of null original map");
		}
		super.onDetach();
	}

}