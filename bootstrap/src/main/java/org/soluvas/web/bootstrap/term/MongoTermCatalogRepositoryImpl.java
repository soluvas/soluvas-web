package org.soluvas.web.bootstrap.term;

import java.util.Map;

import org.soluvas.data.Term2;
import org.soluvas.data.TermKind;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.mongo.Index;
import org.soluvas.mongo.MongoRepositoryBase;

import com.google.common.collect.ImmutableMap;
import com.mongodb.BasicDBObject;
import com.mongodb.ReadPreference;

/**
 * @author rudi
 *
 */
public class MongoTermCatalogRepositoryImpl extends MongoRepositoryBase<Term2> implements MongoTermCatalogRepository {
	
	public static final Map<TermKind, String> TERM_STRING_VALUE = ImmutableMap.of(TermKind.APPAREL_SIZE, "ApparelSize", TermKind.COLOR, "Color", TermKind.SHOE_SIZE, "ShoeSize");
	public static final Map<String, TermKind> TERM_KIND_VALUE = ImmutableMap.of("ApparelSize", TermKind.APPAREL_SIZE, "Color", TermKind.COLOR, "ShoeSize", TermKind.SHOE_SIZE);
	
	public MongoTermCatalogRepositoryImpl(String mongoUri, boolean migrationEnabled, boolean autoExplainSlow) {
		super(Term2.class, Term2.class, Term2.CURRENT_SCHEMA_VERSION, mongoUri, ReadPattern.DUAL,
				"termCatalog", migrationEnabled, autoExplainSlow,
				Index.asc("name"),
				Index.asc("nsPrefix"),
				Index.asc("kindNsPrefix"),
				Index.asc("kindName")
				);
	}
	
	@Override
	public Page<Term2> findAll(TermKind termKind, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		query.put("kindName", TERM_STRING_VALUE.get(termKind));
		
		return findAllByQuery(query, pageable);
	}

	@Override
	public long count(TermKind termKind) {
		final BasicDBObject query = new BasicDBObject();
		query.put("kindName", TERM_STRING_VALUE.get(termKind));
		
		return countByQuery(ReadPreference.secondaryPreferred(), query, "count", termKind);
	}
	
}
