package org.soluvas.web.site.alexa;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Value;

/**
 * Configuration for Alexa certify.
 * @author rudi
 */
public class AlexaCertifyImpl implements AlexaCertify {
	
	private static final long serialVersionUID = 1L;
	
	private final boolean enabled;
	/**
	 * e.g. QB0hh1a0k700Eo
	 */
	private final String account;
	/**
	 * e.g. berbatik.com
	 */
	private final String domain;
	/**
	 * e.g. d31qbv1cthcecs.cloudfront.net
	 */
	private final String jsCdn;
	/**
	 * e.g. d5nxst8fruw4z.cloudfront.net
	 */
	private final String imageCdn;
	
	@Inject
	public AlexaCertifyImpl(
			@Value("#{soluvasProps.alexaCertifyEnabled}") boolean enabled,
			@Value("#{soluvasProps.alexaCertifyAccount}") String account,
			@Value("#{soluvasProps.alexaCertifyDomain}") String domain,
			@Value("#{soluvasProps.alexaCertifyJsCdn}") String jsCdn,
			@Value("#{soluvasProps.alexaCertifyImageCdn}") String imageCdn) {
		super();
		this.enabled = enabled;
		this.account = account;
		this.domain = domain;
		this.jsCdn = jsCdn;
		this.imageCdn = imageCdn;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.web.site.alexa.AlexaCertify#isEnabled()
	 */
	@Override
	public boolean isEnabled() {
		return enabled;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.alexa.AlexaCertify#getAccount()
	 */
	@Override
	public String getAccount() {
		return account;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.alexa.AlexaCertify#getDomain()
	 */
	@Override
	public String getDomain() {
		return domain;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.alexa.AlexaCertify#getJsCdn()
	 */
	@Override
	public String getJsCdn() {
		return jsCdn;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.alexa.AlexaCertify#getImageCdn()
	 */
	@Override
	public String getImageCdn() {
		return imageCdn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	/* (non-Javadoc)
	 * @see org.soluvas.web.site.alexa.AlexaCertify#toString()
	 */
	@Override
	public String toString() {
		return "AlexaCertify [enabled=" + enabled + ", account=" + account
				+ ", domain=" + domain + ", jsCdn=" + jsCdn + ", imageCdn="
				+ imageCdn + "]";
	}
	
}
