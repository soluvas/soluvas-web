package org.soluvas.web.site;

import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.soluvas.commons.Person;

/**
 * Plain page for displaying the {@link Person#getClientAccessToken()},
 * but the access token is typically parsed from the URI
 * i.e. {@code http://YOUR_REGISTERED_REDIRECT_URI/#access_token=ACCESS_TOKEN}.
 * @author ceefour
 */
@WicketMountPoint(mountPoint="token_recipient")
public class TokenRecipientPage extends WebPage {

	private static final long serialVersionUID = 1L;

	/**
	 * @param parameters
	 */
	public TokenRecipientPage(PageParameters parameters) {
		super(parameters);
	}

}
