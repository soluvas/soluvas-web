package org.soluvas.web.site.compose;

import java.util.Collection;

import org.eclipse.emf.common.notify.impl.NotifyingListImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.soluvas.data.repository.CrudRepositoryBase;

import com.google.common.collect.ImmutableList;

/**
 * Manages available {@link EObject}s in memory.
 * @author ceefour
 */
public class EmfGenericRepository<T extends EObject> extends CrudRepositoryBase<T, Integer> {
	
	private final EList<T> coll = new NotifyingListImpl<T>();

	@Override
	public boolean exists(Integer id) {
		return false;
	}

	@Override
	public Collection<T> findAll() {
		return ImmutableList.copyOf(coll);
	}

	@Override
	public boolean delete(Integer id) {
		return coll.remove(id);
	}
	
	@Override
	public boolean delete(T entity) {
		return coll.remove(entity);
	}

	@Override
	public long count() {
		return coll.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <S extends T> S findOne(Integer id) {
		return (S) coll.get(id);
	}

	@Override
	protected Integer getId(T entity) {
		int index = coll.indexOf(entity);
		return index >= 0 ? index : null;
	}

	@Override
	protected <S extends T> S modify(Integer id, S entity) {
		coll.remove(id);
		coll.add(id, entity);
		return entity;
	}

	@Override
	protected <S extends T> S add(S entity) {
		coll.add(entity);
		return entity;
	}

}
