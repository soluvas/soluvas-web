package org.soluvas.web.site.widget;

import java.util.Collection;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * Used by {@link CollectionColumn}. To create custom {@link Component}
 * for each item, override {@link #createItemComponent(String, ListItem)}.
 * @author ceefour
 */
public class CollectionColumnPanel<T> extends GenericPanel<Collection<T>> {

	private static final long serialVersionUID = 1L;

	public CollectionColumnPanel(String id, final IModel<Collection<T>> model) {
		super(id, model);
		final int limit = 5;
		final IModel<List<T>> valuesModel = new LoadableDetachableModel<List<T>>() {
			@Override
			protected List<T> load() {
				final Collection<T> coll = Optional.fromNullable(model.getObject()).or(ImmutableList.<T>of());
				if (coll.size() <= limit) {
					return ImmutableList.copyOf(coll);
				} else {
					return ImmutableList.copyOf(Iterables.limit(coll, limit - 1));
				}
			}
		};
		add(new ListView<T>("values", valuesModel) {
			@Override
			protected void populateItem(ListItem<T> item) {
				item.add(createItemComponent("value", item));
			}
		});
		add(new Label("more", new LoadableDetachableModel<Integer>() {
			@Override
			protected Integer load() {
				final Collection<T> coll = model.getObject();
				return coll != null ? coll.size() - limit + 1 : null;
			}
		}) {
			@Override
			protected void onConfigure() {
				super.onConfigure();
				final Collection<T> coll = model.getObject();
				setVisible(coll != null && coll.size() > limit);
			}
		});
	}
	
	/**
	 * Create the {@link Component} for the specified item.
	 * The Component ID must be {@code componentId}.
	 * The default implementation creates a simple {@link Label}.
	 * @return
	 */
	protected Component createItemComponent(String componentId, ListItem<T> item) {
		return new Label(componentId, item.getModel());
	}
	
}
