package org.soluvas.web.bootstrap.widget;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONStringer;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.Term2;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.data.entity.Value;
import org.soluvas.mongo.MongoTermRepository;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;

public class Term2ChoiceProvider extends ChoiceProvider<Term2> {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(Term2ChoiceProvider.class);
	
	@SpringBean
	private MongoTermRepository termRepo;
	@SpringBean
	private WebAddress webAddress;
	
	private final IModel<String> enumerationIdModel;
	private final IModel<List<Value<?>>> whiteListValuesModel;
	
	public Term2ChoiceProvider(final String enumerationId) {
		super();
		Injector.get().inject(this);
		this.enumerationIdModel = new Model<>(enumerationId);
		this.whiteListValuesModel = new ListModel<>(ImmutableList.of());
	}
	
	public Term2ChoiceProvider(final IModel<String> enumerationIdModel) {
		super();
		Injector.get().inject(this);
		this.enumerationIdModel = enumerationIdModel;
		this.whiteListValuesModel = new ListModel<>(ImmutableList.of());
	}
	
	public Term2ChoiceProvider(final IModel<String> enumerationIdModel,
			final IModel<List<Value<?>>> whiteListValusModel) {
		super();
		Injector.get().inject(this);
		this.enumerationIdModel = enumerationIdModel;
		this.whiteListValuesModel = whiteListValusModel;
	}

	@Override
	public String getDisplayValue(Term2 choice) {
		return choice.getName();
	}

	@Override
	public String getIdValue(Term2 choice) {
		return choice.getId();
	}

	@Override
	public void query(final String term, int page, Response<Term2> response) {
		final PageRequest pageable = new PageRequest(page, 10L, Direction.ASC, "name");
		
		final Page<Term2> result;
		if (!Strings.isNullOrEmpty(enumerationIdModel.getObject())) {
			result = termRepo.findAll(enumerationIdModel.getObject(), Optional.ofNullable(term).orElse("").trim(), pageable);
		} else {
			final List<String> whiteValues = whiteListValuesModel.getObject().stream().map(new Function<Value<?>, String>() {
				@Override
				public String apply(Value<?> t) {
					return String.valueOf(t.getValue());
				}
			}).collect(Collectors.toList());
			result = termRepo.findAll(whiteValues, pageable);
		}
		final List<Term2> content = result.getContent();
		log.debug("Got {} size(s)", content.size());
		response.addAll(content);
		response.setHasMore(result.hasNextPage());
	}

	@Override
	public Collection<Term2> toChoices(Collection<String> ids) {
		return termRepo.findAll(ids);
	}

	@Override
	public void toJson(Term2 choice, JSONStringer writer)
			throws JSONException {
		writer.key("id").value(choice.getId())
			.key("text").value(choice.getName());
		if (choice.getColor() != null) {
			writer.key("color").value(choice.getColor());
		}
		if (choice.getImageId() != null) {
			final String bundleName = choice.getId().startsWith("base") ? "org.soluvas.data" : "tenant_common";
			final String uri = webAddress.getImagesUri() + bundleName + "/" + "base_" + choice.getEnumerationId() +"/" + choice.getImageId() + ".png";
			writer.key("imageUri").value(uri);
		}
	}
	
}