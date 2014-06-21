package org.soluvas.web.bootstrap.widget;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.json.JSONException;
import org.json.JSONWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.QNameFunction;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.Term;
import org.soluvas.data.TermManager;
import org.soluvas.data.Value;
import org.soluvas.data.ValueFunction;
import org.soluvas.web.site.TermListModel;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;

public class TermChoiceProvider extends ChoiceProvider<Term> {

	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(TermChoiceProvider.class);
	
	@SpringBean
	private TermManager termMgr;
	@SpringBean
	private WebAddress webAddress;
	private final IModel<List<Term>> termsModel;
	private String kindNsPrefix;
	private String kindName;
	/**
	 * May be {@code null}, but we'll detach this.
	 */
	@Nullable
	private IModel<List<Value<?>>> whitelistModel;
	
	public TermChoiceProvider(final String kindNsPrefix, final String kindName) {
		super();
		Injector.get().inject(this);
		this.kindNsPrefix = kindNsPrefix;
		this.kindName = kindName;
		termsModel = new TermListModel(kindName);
	}
	
	/**
	 * Filter only terms which match the values provided by whitelist. The whitelist can be dynamic.
	 * @param kindNsPrefix
	 * @param kindName
	 * @param whitelistModel
	 */
	public TermChoiceProvider(final String kindNsPrefix, final String kindName, final IModel<List<Value<?>>> whitelistModel) {
		super();
		Injector.get().inject(this);
		this.whitelistModel = whitelistModel;
		termsModel = new AbstractReadOnlyModel<List<Term>>() {
			@Override
			public List<Term> getObject() {
				final Set<String> whitelistedUNames = ImmutableSet.copyOf(Iterables.transform(whitelistModel.getObject(), new ValueFunction()));
				return ImmutableList.copyOf(Iterables.filter(termMgr.findTerms(kindNsPrefix, kindName), new Predicate<Term>() {
					@Override
					public boolean apply(@Nullable Term input) {
						return whitelistedUNames.contains(input.getQName());
					}
				}));
			}
		};
	}
	
	@Override
	public void query(final String term, int page, Response<Term> response) {
		final Collection<Term> filteredTerm = Collections2.filter(termsModel.getObject(), new Predicate<Term>() {
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
				final List<Term> terms = termsModel.getObject();
				try {
					return Iterables.find(terms, new Predicate<Term>() {
						@Override
						public boolean apply(@Nullable Term input) {
							return input.getQName().equals(id);
						}
					}, null);
				} catch (Exception e) {
					log.warn("Invalid term UName '{}' for kind {}_{}, {} valid terms are: {}",
							id, kindNsPrefix, kindName, terms.size(), Lists.transform(terms, new QNameFunction()));
					return null;
				}
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
	
	@Override
	public void detach() {
		termsModel.detach();
		if (whitelistModel != null) {
			whitelistModel.detach();
		}
		super.detach();
	}
	
}