package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import javax.annotation.Nullable;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.json.JSONException;
import org.json.JSONWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.CustomerRole;
import org.soluvas.data.StatusMask;
import org.soluvas.data.customerrole.CustomerRoleRepository;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

public class CustomerRoleChoiceProvider extends ChoiceProvider<CustomerRole> {
	
	private static final long serialVersionUID = 1L;
	private static final Logger log = LoggerFactory
			.getLogger(CustomerRoleChoiceProvider.class);
	
	@SpringBean
	public CustomerRoleRepository customerRoleRepo;

	public CustomerRoleChoiceProvider() {
		super();
		Injector.get().inject(this);
	}

	@Override
	public void query(String term, int page, Response<CustomerRole> response) {
		final String trimmedTerm = term.trim();
		final Page<CustomerRole> pageCustomerRole = customerRoleRepo.findAll(StatusMask.ACTIVE_ONLY, trimmedTerm, 
				new PageRequest(page, 20, Sort.Direction.ASC, "name"));
		log.trace("Search '{}' page '{}' returned '{}'", trimmedTerm, page, pageCustomerRole.getContent());
		response.addAll(pageCustomerRole.getContent());
		response.setHasMore(!pageCustomerRole.isLastPage());
	}

	@Override
	public void toJson(CustomerRole choice, JSONWriter writer)
			throws JSONException {
		writer.key("id").value(choice.getId())
		.key("text").value(choice.getName());
	}

	@Override
	public Collection<CustomerRole> toChoices(Collection<String> ids) {
		return FluentIterable.from(ids).transform(new Function<String, CustomerRole>() {

			@Override
			@Nullable
			public CustomerRole apply(@Nullable String input) {
				return customerRoleRepo.findOne(input);
			}
		}).toList();
	}
	
	@Override
	public void detach() {
		super.detach();
	}
	
}