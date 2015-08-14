package org.soluvas.web.bootstrap.term;

import org.soluvas.data.Existence;
import org.soluvas.data.Term2;
import org.soluvas.data.TermKind;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.Pageable;
import org.soluvas.mongo.Index;
import org.soluvas.mongo.MongoRepositoryBase;

import com.google.common.collect.ImmutableBiMap;
import com.mongodb.BasicDBObject;
import com.mongodb.ReadPreference;

/**
 * @author rudi
 *
 */
public class MongoTermRepositoryImpl extends MongoRepositoryBase<Term2> implements MongoTermRepository {
	
	public static final ImmutableBiMap<TermKind, String> TERM_STRING_VALUE = ImmutableBiMap.of(
			TermKind.APPAREL_SIZE, "ApparelSize", TermKind.COLOR, "Color", TermKind.SHOE_SIZE, "ShoeSize");
	
	public MongoTermRepositoryImpl(String mongoUri, boolean migrationEnabled, boolean autoExplainSlow) {
		super(Term2.class, Term2.class, Term2.CURRENT_SCHEMA_VERSION, mongoUri, ReadPattern.DUAL,
				"term", migrationEnabled, autoExplainSlow,
				Index.asc("name"),
				Index.asc("formalId"),
				Index.asc("enumerationId")
				);
	}
	
	@Override
	public Page<Term2> findAll(TermKind termKind, Pageable pageable) {
		final BasicDBObject query = new BasicDBObject();
		query.put("enumerationId", termKind.getEnumerationId());
		
		return findAllByQuery(query, pageable);
	}

	@Override
	public long count(TermKind termKind) {
		final BasicDBObject query = new BasicDBObject();
		query.put("enumerationId", termKind.getEnumerationId());
		
		return countByQuery(ReadPreference.secondaryPreferred(), query, "count", termKind);
	}

	@Override
	public Existence<String> existsByEnumerationId(String enumerationId,
			String termId) {
		return exists(enumerationId + "/" + termId) ? Existence.of(termId, termId) : Existence.absent();
	}
	
}
