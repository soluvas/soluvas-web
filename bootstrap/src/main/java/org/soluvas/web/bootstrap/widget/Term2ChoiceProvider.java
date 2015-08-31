package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.json.JSONException;
import org.json.JSONWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.Term2;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.mongo.MongoTermRepository;

import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;

public class Term2ChoiceProvider extends ChoiceProvider<Term2> {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(Term2ChoiceProvider.class);
	
	@SpringBean
	private MongoTermRepository termRepo;
	@SpringBean
	private WebAddress webAddress;
	
	private final String enumerationId;
	
	public Term2ChoiceProvider(final String enumerationId) {
		super();
		Injector.get().inject(this);
		this.enumerationId = enumerationId;
	}
	
	@Override
	public void query(final String term, int page, Response<Term2> response) {
		final PageRequest pageable = new PageRequest(page, 10L, Direction.ASC, "localSku");
		final Page<Term2> result = termRepo.findAll(enumerationId, term.trim(), pageable);
		response.addAll(result.getContent());
		response.setHasMore(result.hasNextPage());
	}

	@Override
	public Collection<Term2> toChoices(Collection<String> ids) {
		return termRepo.findAll(ids);
	}

	@Override
	public void toJson(Term2 choice, JSONWriter writer)
			throws JSONException {
		writer.key("id").value(choice.getId())
			.key("text").value(choice.getName());
		if (choice.getColor() != null) {
			writer.key("color").value(choice.getColor());
		}
		if (choice.getImageId() != null) {
			final String bundleName = choice.getId().startsWith("base") ? "org.soluvas.data" : "tenant_common";
			final String uri = webAddress.getImagesUri() + bundleName + "/" + choice.getId().substring(0, choice.getId().indexOf("_") + 1) + "_" + choice.getEnumerationId() +"/" + choice.getImageId() + ".png";
			writer.key("imageUri").value(uri);
		}
	}
	
}