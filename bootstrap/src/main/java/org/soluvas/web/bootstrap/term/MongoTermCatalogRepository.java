package org.soluvas.web.bootstrap.term;


import org.soluvas.data.Term2;
import org.soluvas.data.TermKind;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.data.repository.PagingAndSortingRepository;

/**
 * @author rudi
 *
 */
public interface MongoTermCatalogRepository extends PagingAndSortingRepository<Term2, String> {
	
	Page<Term2> findAll(TermKind termKind, Pageable pageable);
	
	long count(TermKind termKind);

}
