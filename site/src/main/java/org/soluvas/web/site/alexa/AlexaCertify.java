package org.soluvas.web.site.alexa;

import java.io.Serializable;

/**
 * Configuration for Alexa certify.
 * @author rudi
 */
@SuppressWarnings("serial")
public class AlexaCertify implements Serializable {
	
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
	
	public AlexaCertify(boolean enabled, String account, String domain, String jsCdn,
			String imageCdn) {
		super();
		this.enabled = enabled;
		this.account = account;
		this.domain = domain;
		this.jsCdn = jsCdn;
		this.imageCdn = imageCdn;
	}
	
	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @return the domain
	 */
	public String getDomain() {
		return domain;
	}

	/**
	 * @return the jsCdn
	 */
	public String getJsCdn() {
		return jsCdn;
	}

	/**
	 * @return the imageCdn
	 */
	public String getImageCdn() {
		return imageCdn;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AlexaCertify [enabled=" + enabled + ", account=" + account
				+ ", domain=" + domain + ", jsCdn=" + jsCdn + ", imageCdn="
				+ imageCdn + "]";
	}
	
}
