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
 * @author mahendri
 */
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
	
	@Override
	protected PersonInfo load() {
		Preconditions.checkNotNull(personLookup, "Person Lookup must not be null.");
		final String personId = (String) SecurityUtils.getSubject().getPrincipal();
		final Person socialPerson = personId != null ? personLookup.findOne(personId) : null;
		if (socialPerson == null) {
			return CommonsFactory.eINSTANCE.createPersonInfo();
		}
		final PersonInfo personInfo = socialPerson.toInfo();
		return personInfo;
	}
}