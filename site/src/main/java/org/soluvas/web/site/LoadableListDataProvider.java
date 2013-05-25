package org.soluvas.web.site;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IModel;
import org.eclipse.emf.ecore.EObject;

import com.google.common.base.Preconditions;

/**
 * Allows the use of {@link EObject} lists with {@link DataView}.
 * If the source is an {@link IModel} of {@link List}, use {@link EmfListDataProvider} instead.
 * 
 * <p>Adapted from {@link ListDataProvider}.
 * 
 * @author ceefour
 * @param <T>
 */
public abstract class LoadableListDataProvider<T extends EObject> implements IDataProvider<T>
{
	private static final long serialVersionUID = 1L;

	/** reference to the list used as dataprovider for the dataview */
	private transient List<T> list;

	/**
	 * Subclass to lazy load the list
	 * 
	 * @return The list
	 */
	protected abstract List<T> load();

	@Override
	public Iterator<? extends T> iterator(final long first, final long count)
	{
		if (this.list == null) {
			this.list = Preconditions.checkNotNull(load(),
					"getData() must not return null List");
		}
		List<T> list = this.list;

		long toIndex = first + count;
		if (toIndex > list.size())
		{
			toIndex = list.size();
		}
		return list.subList((int)first, (int)toIndex).listIterator();
	}

	/**
	 * @see IDataProvider#size()
	 */
	@Override
	public long size()
	{
		if (this.list == null) {
			this.list = Preconditions.checkNotNull(load(),
					"getData() must not return null List");
		}
		return this.list.size();
	}

	/**
	 * @see IDataProvider#model(Object)
	 */
	@Override
	public IModel<T> model(T object)
	{
		return new EmfModel<T>(object);
	}

	/**
	 * @see org.apache.wicket.model.IDetachable#detach()
	 */
	@Override
	public void detach()
	{
	}

}
