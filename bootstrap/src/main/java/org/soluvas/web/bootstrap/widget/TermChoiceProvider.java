package org.soluvas.web.bootstrap.widget;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONStringer;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.QNameFunction;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.Term;
import org.soluvas.data.TermRepository;
import org.soluvas.data.Value;
import org.soluvas.data.ValueFunction;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.web.site.TermListModel;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class TermChoiceProvider extends ChoiceProvider<Term> {

	private static final Logger log = LoggerFactory
			.getLogger(TermChoiceProvider.class);
	
//	@SpringBean
//	private TermManager termMgr;
	@SpringBean(name="colorTermRepo")
	private TermRepository colorTermRepo;
	@SpringBean(name="sizeTermRepo")
	private TermRepository sizeTermRepo;
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
		termsModel = new TermListModel(kindNsPrefix, kindName);
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
				List<Term> terms = new ArrayList<Term>();
				switch (kindName) {
				case "Color" :
					terms = colorTermRepo.findAll(new PageRequest(0, 5000)).getContent();
					break;
				case "Size" :
					terms = sizeTermRepo.findAll(new PageRequest(0, 5000)).getContent();
				default :
					throw new RuntimeException(String.format("%s not supported", kindName));
				}
//				return ImmutableList.copyOf(Iterables.filter(termMgr.findTerms(kindNsPrefix, kindName), new Predicate<Term>() {
//					@Override
//					public boolean apply(@Nullable Term input) {
//						return whitelistedUNames.contains(input.getQName());
//					}
//				}));
				return ImmutableList.copyOf(Iterables.filter(terms, new Predicate<Term>() {
					@Override
					public boolean apply(@Nullable Term input) {
						return whitelistedUNames.contains(input.getQName());
					}
				}));
			}
		};
	}

	@Override
	public String getDisplayValue(Term choice) {
		return choice.getDisplayName();
	}

	@Override
	public String getIdValue(Term choice) {
		return choice.getQName();
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
	public void toJson(Term choice, JSONStringer writer)
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