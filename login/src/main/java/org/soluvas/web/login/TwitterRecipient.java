package org.soluvas.web.login;

import javax.annotation.Nullable;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AccountStatus;
import org.soluvas.commons.CommonsFactory;
import org.soluvas.commons.Gender;
import org.soluvas.commons.NameUtils;
import org.soluvas.commons.NameUtils.PersonName;
import org.soluvas.commons.Person;
import org.soluvas.commons.SlugUtils;
import org.soluvas.commons.WebAddress;
import org.soluvas.commons.tenant.TenantRef;
import org.soluvas.data.StatusMask;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.image.store.ImageRepository;
import org.soluvas.json.JsonUtils;
import org.soluvas.security.AutologinToken;
import org.soluvas.security.NotLoggedWithTwitterException;
import org.soluvas.twitter.TwitterManager;
import org.soluvas.twitter.TwitterUtils;
import org.soluvas.web.site.Interaction;
import org.soluvas.web.site.SoluvasWebSession;
import org.wicketstuff.annotation.mount.MountPath;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;


/**
 * @author haidar
 *
 */
@SuppressWarnings("serial")
@MountPath("twitter_recipient/")
public class TwitterRecipient extends AbstractTwitterRecipientPage {
	
	@SpringBean(name="twitterMgr")
	private TwitterManager twitterManager;
	@SpringBean
	private WebAddress webAddress;
	@SpringBean
	private PersonRepository personRepo;
	@SpringBean(name="personImageRepo")
	private ImageRepository personImageRepo;
	@SpringBean
	private TenantRef tenant;
	
	public TwitterRecipient(final PageParameters params) {
		super(params);
	}
}
