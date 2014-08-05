package org.soluvas.web.site;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.repeater.data.IDataProvider;
import org.apache.wicket.model.LoadableDetachableModel;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.google.common.base.Preconditions;

/**
 * Model for JPA entity, useful for {@link IDataProvider} implementations.
 * Usage:
 * 
 * <pre>
 * IDataProvider&lt;Hadith> hadithsDp = new IDataProvider&lt;Hadith>() {
 * 	&commat;Override
 * 	public void detach() {
 * 	}
 * 
 * 	&commat;Override
 * 	public Iterator&lt;? extends Hadith> iterator(long first, long count) {
 * 		return hadithMgr.findAllHadiths(upSlug, new PageOffsetRequest(first, count, Direction.ASC, "hadithNum")).iterator();
 * 	}
 * 
 * 	&commat;Override
 * 	public long size() {
 * 		return hadithCountModel.getObject();
 * 	}
 * 
 * 	&commat;Override
 * 	public IModel&lt;Hadith> model(Hadith object) {
 * 		return new JpaModel&lt;>(Hadith.class, object.getId(), object);
 * 	}
 * };
 * 
 * final DataView&lt;Hadith> hadithDv = new DataView&lt;Hadith>("hadiths", hadithsDp, 20) {
 * 	&commat;Override
 * 	protected void populateItem(Item&lt;Hadith> item) {
 * 		item.add(new Label("hadithNum", new PropertyModel&lt;>(item.getModel(), "hadithNum")));
 * 		item.add(new Label("text", item.getModelObject().getTexts().iterator().next().getHtml())
 * 			.setEscapeModelStrings(false));
 * 	}
 * };
 * add(hadithDv);
 * add(new BootstrapAjaxPagingNavigator("pagingNavigator", hadithDv));
 * </pre>
 * 
 * @see http://wicket.apache.org/guide/guide/modelsforms.html 11.6 Detachable models
 * @author ceefour
 */
public class JpaModel<T> extends LoadableDetachableModel<T> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	PlatformTransactionManager txMgr;
	@Inject
	EntityManagerFactory emf;
	
	private final Class<T> entityClass;
	private final Serializable id;

	/**
	 * @param entityClass Required because {@code object} may be a Hibernate proxy.
	 * @param id
	 * @param object
	 */
	public JpaModel(Class<T> entityClass, Serializable id, T object) {
		super(object);
		Injector.get().inject(this);
		this.entityClass = entityClass;
		this.id = id;
	}

	@Override
	protected T load() {
		final EntityManager em = emf.createEntityManager();
		try {
			TransactionTemplate transactionTemplate = new TransactionTemplate(txMgr);
			transactionTemplate.setReadOnly(true);
			return transactionTemplate.execute(new TransactionCallback<T>() {
				@Override
				public T doInTransaction(TransactionStatus status) {
					T entity = Preconditions.checkNotNull(em.find(entityClass, id),
							"Entity %s with ID '%s' not found", entityClass.getName(), id);
					return entity;
				}
			});
		} finally {
			em.close();
		}
	}

}
