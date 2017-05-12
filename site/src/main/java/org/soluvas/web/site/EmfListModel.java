package org.soluvas.web.site;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * For lists of {@link EObject}s.
 * 
 * @author ceefour
 * @param <T>
 *            type of object inside list
 */
@Deprecated
public class EmfListModel<T extends EObject> extends LoadableDetachableModel<List<T>> {
	/**
	 * A list larger than this (bytes) will be logged WARN and should not be stored in {@link EmfListModel}.
	 */
	public static final long LARGE_THRESHOLD = 300 * 1024;
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(EmfListModel.class);
	private List<EmfModel<T>> savedObjects;
	
	public EmfListModel() {
		super();
	}

	public EmfListModel(List<T> list) {
		super(list);
	}

	/**
	 * Wraps the passed {@link Collection} in an {@link ArrayList}.
	 * @param collection
	 */
	public EmfListModel(Collection<T> collection) {
		super(new ArrayList<>(collection));
	}

	@Override
	protected List<T> load() {
		if (savedObjects != null) {
			return new ArrayList<>(Lists.transform(savedObjects, new Function<IModel<T>, T>() {
				@Override @Nullable
				public T apply(@Nullable IModel<T> input) {
					return input.getObject();
				}
			}));
		} else {
			return null;
		}
	}
	
	@Override
	protected void onDetach() {
		final List<T> origList = getObject();
		if (origList != null) {
			savedObjects = ImmutableList.copyOf( Lists.transform(origList, new Function<T, EmfModel<T>>() {
				@Override @Nullable
				public EmfModel<T> apply(@Nullable T input) {
					final EmfModel<T> emfModel = new EmfModel<>(input);
					emfModel.detach();
					return emfModel;
				}
			}));
			long totalBufSize = 0;
			for (EmfModel<T> obj : savedObjects) {
				totalBufSize += obj.getBufSize();
			}
			if (totalBufSize > LARGE_THRESHOLD) {
				log.warn("List of {} objects is too large ({} bytes): {}",
						savedObjects.size(), totalBufSize,
						Lists.transform(origList, EmfModel.EOBJECT_TO_STRING));
			}
		}
		super.onDetach();
	}

}