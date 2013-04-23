package org.soluvas.web.bootstrap.widget;

import java.util.Collection;
import java.util.List;

import javax.annotation.Nullable;

import org.apache.commons.lang.StringUtils;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.json.JSONException;
import org.json.JSONWriter;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.Term;
import org.soluvas.data.TermManager;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Iterables;
import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;

public class TermChoiceProvider extends ChoiceProvider<Term> {
	
	@SpringBean
	private TermManager termMgr;
	@SpringBean
	private WebAddress webAddress;
	private final List<Term> terms;
	
	public TermChoiceProvider(String kindNsPrefix, String kindName) {
		super();
		Injector.get().inject(this);
		terms = termMgr.findTerms(kindNsPrefix, kindName);
	}
	
	@Override
	public void query(final String term, int page, Response<Term> response) {
		final Collection<Term> filteredTerm = Collections2.filter(terms, new Predicate<Term>() {
			@Override
			public boolean apply(@Nullable Term input) {
				return StringUtils.containsIgnoreCase(input.getDisplayName(), term);
			}
		});
		response.addAll(filteredTerm);
	}

	@Override
	public Collection<Term> toChoices(Collection<String> uNames) {
		final Collection<Term> termColl = Collections2.transform(uNames, new Function<String, Term>() {
			@Override @Nullable
			public Term apply(@Nullable final String id) {
				return Iterables.find(terms, new Predicate<Term>() {
					@Override
					public boolean apply(@Nullable Term input) {
						return input.getQName().equals(id);
					}
				}, null);
			}
		});
		return termColl;
	}

	@Override
	public void toJson(Term choice, JSONWriter writer)
			throws JSONException {
		writer.key("id").value(choice.getQName())
			.key("text").value(choice.getDisplayName());
		if (choice.getColor() != null) {
			writer.key("color").value(choice.getColor());
		}
		if (choice.getImageId() != null) {
			final String bundleName = "base".equals(choice.getNsPrefix()) ? "org.soluvas.data" : "tenant_common";
			final String uri = webAddress.getImagesUri() + bundleName + "/" + choice.getKindNsPrefix() + "_" + choice.getKindName() +"/" + choice.getImageId() + ".png";
			writer.key("imageUri").value(uri);
		}
	}
	
}