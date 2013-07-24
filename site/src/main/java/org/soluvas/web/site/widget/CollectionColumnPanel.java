package org.soluvas.web.site.widget;

import java.util.Collection;
import java.util.List;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;

/**
 * Used by {@link CollectionColumn}.
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
				return ImmutableList.copyOf(Iterables.limit(model.getObject(), limit));
			}
		};
		add(new ListView<T>("values", valuesModel) {
			@Override
			protected void populateItem(ListItem<T> item) {
				item.add(new Label("value", item.getModel()));
			}
		});
		add(new Label("more", new LoadableDetachableModel<Integer>() {
			@Override
			protected Integer load() {
				final Collection<T> coll = model.getObject();
				return coll != null ? coll.size() - limit : null;
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
	
}
