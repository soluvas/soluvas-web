package org.soluvas.web.site;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Person;
import org.soluvas.commons.PersonInfo;
import org.soluvas.data.EntityLookup;

import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository2;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Returns the logged in {@link PersonInfo} using Shiro {@link Subject}
 * then lookup the {@link Person} via {@link EntityLookup} bean named {@code personLookup}.
 *
 * Currently only used by Quikdo 2.x. Bippo uses its own id.co.bippo.web.LoggedInPersonInfoModel.
 *
 * @todo Use Spring Security instead of Shiro.
 * @author mahendri
 */
public class LoggedInPersonInfoModel extends LoadableDetachableModel<PersonInfo> {
	private final String tenantId;
	@Inject
	private PersonRepository2 personRepo;

	/**
	 *
	 * @param tenantId Tenant ID to load the current user info.
     */
	public LoggedInPersonInfoModel(String tenantId) {
		super();
		this.tenantId = tenantId;
		Injector.get().inject(this);
	}
	
	@Override
	protected PersonInfo load() {
		final Subject subject = SecurityUtils.getSubject();
		String personId;
		try {
			personId = (String) subject.getPrincipal();
		} catch (Exception e) {
			throw new org.soluvas.security.SecurityException(e, "Cannot get principal from subject %s: %s", subject, e);
		}
		final Optional<Person> socialPerson = personId != null ? personRepo.findOne(tenantId, StatusMask.RAW, personId) : Optional.empty();
		if (!socialPerson.isPresent()) {
			return CommonsFactory.eINSTANCE.createPersonInfo();
		} else {
			return socialPerson.get().toInfo();
		}
	}
}