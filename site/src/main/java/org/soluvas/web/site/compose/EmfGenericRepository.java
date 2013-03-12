package org.soluvas.web.site.compose;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.soluvas.data.repository.CrudRepositoryBase;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;

/**
 * Manages available {@link EObject}s in memory.
 * @author ceefour
 */
public class EmfGenericRepository<T extends EObject> extends CrudRepositoryBase<T, Integer> {
	
	// I've been there: NPE, NotifyingListImpl is NOT thread-safe
	private final List<T> coll = Lists.newCopyOnWriteArrayList();//;java.util.concurrent. new NotifyingListImpl<T>();

	@Override
	public boolean exists(Integer id) {
		return false;
	}

	@Override
	public List<T> findAll() {
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
	public synchronized <S extends T> S modify(Integer id, S entity) {
		coll.remove(id);
		coll.add(id, entity);
		return entity;
	}

	@Override
	public <S extends T> S add(S entity) {
		coll.add(entity);
		return entity;
	}

}
