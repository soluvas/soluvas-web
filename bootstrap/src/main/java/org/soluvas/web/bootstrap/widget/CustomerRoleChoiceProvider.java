package org.soluvas.web.bootstrap.widget;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.FluentIterable;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONStringer;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.impl.CustomerRole2;
import org.soluvas.data.StatusMask;
import org.soluvas.data.customerrole.CustomerRoleRepository;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

import javax.annotation.Nullable;
import java.util.Collection;

public class CustomerRoleChoiceProvider extends ChoiceProvider<CustomerRole2> {
	
	private static final Logger log = LoggerFactory
			.getLogger(CustomerRoleChoiceProvider.class);
	
	@SpringBean
	public CustomerRoleRepository customerRoleRepo;

	public CustomerRoleChoiceProvider() {
		super();
		Injector.get().inject(this);
	}

	@Override
	public String getDisplayValue(CustomerRole2 choice) {
		return choice.getId();
	}

	@Override
	public String getIdValue(CustomerRole2 choice) {
		return choice.getId();
	}

	@Override
	public void query(String term, int page, Response<CustomerRole2> response) {
		final String trimmedTerm = Optional.fromNullable(term).or("").trim();
		final Page<CustomerRole2> pageCustomerRole = customerRoleRepo.findAll(StatusMask.ACTIVE_ONLY, trimmedTerm, 
				new PageRequest(page, 20, Sort.Direction.ASC, "name"));
		log.trace("Search '{}' page '{}' returned '{}'", trimmedTerm, page, pageCustomerRole.getContent());
		response.addAll(pageCustomerRole.getContent());
		response.setHasMore(!pageCustomerRole.isLastPage());
	}

	@Override
	public void toJson(CustomerRole2 choice, JSONStringer writer)
			throws JSONException {
		writer.key("id").value(choice.getId())
				.key("text").value(choice.getName());
	}

	@Override
	public Collection<CustomerRole2> toChoices(Collection<String> ids) {
		return FluentIterable.from(ids).transform(new Function<String, CustomerRole2>() {
			@Override @Nullable
			public CustomerRole2 apply(@Nullable String input) {
				return customerRoleRepo.findOne(input);
			}
		}).toList();
	}
	
	@Override
	public void detach() {
		super.detach();
	}
	
}