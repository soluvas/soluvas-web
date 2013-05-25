package org.soluvas.web.site;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.eclipse.emf.ecore.EObject;

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
public class EmfListModel<T extends EObject> extends LoadableDetachableModel<List<T>> {
	private static final long serialVersionUID = 1L;
	private List<IModel<T>> savedObjects;
	
	public EmfListModel() {
		super();
	}

	public EmfListModel(List<T> list) {
		super(list);
	}

	/**
	 * Wrapps the passed {@link Collection} in an {@link ArrayList}.
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
			savedObjects = ImmutableList.copyOf( Lists.transform(origList, new Function<T, IModel<T>>() {
				@Override @Nullable
				public IModel<T> apply(@Nullable T input) {
					final EmfModel<T> emfModel = new EmfModel<>(input);
					emfModel.detach();
					return emfModel;
				}
			}));
		}
		super.onDetach();
	}

}