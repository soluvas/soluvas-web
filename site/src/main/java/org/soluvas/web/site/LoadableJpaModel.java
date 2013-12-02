package org.soluvas.web.site;

import java.io.Serializable;

import org.apache.wicket.model.LoadableDetachableModel;
import org.soluvas.data.EntityLookupException;
import org.soluvas.data.StatusMask;
import org.soluvas.jpa.JpaEntity;
import org.soluvas.jpa.JpaRepository;

/**
 * @author ceefour
 *
 */
public class LoadableJpaModel<T extends JpaEntity<ID>, ID extends Serializable> extends LoadableDetachableModel<T> {
	
	private static final long serialVersionUID = 1L;
	
//	@SpringBean
//	private ApplicationContext appCtx;

	//	private final Class<? extends JpaRepository<T, ID>> repoClass;
	private ID id;

	private final JpaRepository<T, ID> repo;
	
//	public LoadableJpaModel(Class<? extends JpaRepository<T, ID>> repoClass) {
//		super();
//		this.repoClass = repoClass;
//		Injector.get().inject(this);
//	}
//
//	/**
//	 * @param object
//	 */
//	public LoadableJpaModel(Class<? extends JpaRepository<T, ID>> repoClass, T object) {
//		super(object);
//		this.repoClass = repoClass;
//		Injector.get().inject(this);
//	}

	public LoadableJpaModel(JpaRepository<T, ID> repo) {
		super();
		this.repo = repo;
//		Injector.get().inject(this);
	}

	/**
	 * @param object
	 */
	public LoadableJpaModel(JpaRepository<T, ID> repo, T object) {
		super(object);
		this.repo = repo;
//		Injector.get().inject(this);
	}

	/* (non-Javadoc)
	 * @see org.apache.wicket.model.LoadableDetachableModel#load()
	 */
	@Override
	protected T load() {
		if (this.id != null) {
//			final JpaRepository<T, ID> repo = appCtx.getBean(repoClass);
			try {
				return repo.lookupOneById(StatusMask.RAW, this.id);
			} catch (EntityLookupException e) {
				throw new RuntimeException(e.toString(), e);
			}
		} else {
			return null;
		}
	}
	
	@Override
	protected void onDetach() {
		if (isAttached() && getObject() != null) {
			this.id = getObject().getId();
		} else {
			this.id = null;
		}
		super.onDetach();
	}

}
