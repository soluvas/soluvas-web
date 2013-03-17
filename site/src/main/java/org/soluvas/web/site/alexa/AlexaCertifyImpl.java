package org.soluvas.web.site.alexa;


/**
 * Configuration for Alexa certify.
 * @author rudi
 */
@SuppressWarnings("serial")
public class AlexaCertifyImpl implements AlexaCertify {
	
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
	
	public AlexaCertifyImpl(boolean enabled, String account, String domain, String jsCdn,
			String imageCdn) {
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
