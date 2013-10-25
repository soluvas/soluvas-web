package org.soluvas.web.site;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Person;
import org.soluvas.commons.PersonInfo;
import org.soluvas.data.EntityLookup;

import com.google.common.base.Preconditions;

/**
 * Returns the logged in {@link PersonInfo} using Shiro {@link Subject}
 * then lookup the {@link Person} via {@link EntityLookup} bean named {@code personLookup}.
 * @deprecated To Bippo: Do not delete yet, still used by Quikdo. Until there's a better replacement.
 * @author mahendri
 */
@Deprecated
public class LoggedInPersonInfoModel extends LoadableDetachableModel<PersonInfo> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SpringBean(name="personLookup")
	private EntityLookup<Person, String> personLookup;
	
	public LoggedInPersonInfoModel() {
		super();
		Injector.get().inject(this);
	}
	
	@SuppressWarnings("null")
	@Override
	protected PersonInfo load() {
		Preconditions.checkNotNull(personLookup, "Person Lookup must not be null.");
		final Subject subject = SecurityUtils.getSubject();
		String personId;
		try {
			personId = (String) subject.getPrincipal();
		} catch (Exception e) {
			throw new org.soluvas.security.SecurityException(e, "Cannot get principal from subject %s: %s", subject, e);
		}
		final Person socialPerson = personId != null ? personLookup.findOne(personId) : null;
		if (socialPerson == null) {
			return CommonsFactory.eINSTANCE.createPersonInfo();
		}
		final PersonInfo personInfo = socialPerson.toInfo();
		return personInfo;
	}
}