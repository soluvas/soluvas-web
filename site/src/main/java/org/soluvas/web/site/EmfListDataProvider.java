package org.soluvas.web.site;

import java.util.Iterator;
import java.util.List;

import org.apache.wicket.markup.repeater.data.DataView;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.markup.repeater.data.ListDataProvider;
import org.apache.wicket.model.IDetachable;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;

/**
 * Allows the use of {@link EObject} {@link IModel} {@link List}s with {@link DataView}.
 * If you want to make it {@link IDetachable} without needing to
 * implement another {@link LoadableDetachableModel}, use {@link LoadableListDataProvider}.
 * 
 * <p>Adapted from {@link ListDataProvider}.
 * 
 * @author ceefour
 * @param <T>
 * 
 */
public class EmfListDataProvider<T extends EObject> implements IDataProvider<T>
{
	private static final long serialVersionUID = 1L;

	/** reference to the list used as dataprovider for the dataview */
	private final IModel<List<T>> listModel;
	
	/**
	 * @param listModel Either a {@link PropertyModel} or a {@link LoadableDetachableModel}.
	 */
	public EmfListDataProvider(IModel<List<T>> listModel) {
		super();
		this.listModel = listModel;
	}

	/**
	 * Shortcut that wraps the parameters inside a {@link PropertyModel}.
	 * <p>Usage:
	 * 
	 * <pre>{@literal
	 * final IDataProvider<GoodsShipmentLine> goodsShpLineDp = new EmfListDataProvider<>(
	 *     model, InventoryPackage.Literals.INVENTORY__LINES);
	 * }</pre>
	 * 
	 * @param listModel Usually {@link LoadableDetachableModel}.
	 */
	public EmfListDataProvider(IModel<? extends EObject> listModel, EReference property) {
		super();
		this.listModel = new PropertyModel<>(listModel, property.getName());
	}

	@Override
	public Iterator<? extends T> iterator(final long first, final long count)
	{
		final List<T> list = Optional.fromNullable(listModel.getObject()).or(ImmutableList.<T>of());

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
		final List<T> list = Optional.fromNullable(listModel.getObject()).or(ImmutableList.<T>of());
		return list.size();
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
