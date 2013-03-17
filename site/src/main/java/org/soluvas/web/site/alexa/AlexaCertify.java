package org.soluvas.web.site.alexa;

import java.io.Serializable;

public interface AlexaCertify extends Serializable {

	/**
	 * @return the enabled
	 */
	public abstract boolean isEnabled();

	/**
	 * @return the account
	 */
	public abstract String getAccount();

	/**
	 * @return the domain
	 */
	public abstract String getDomain();

	/**
	 * @return the jsCdn
	 */
	public abstract String getJsCdn();

	/**
	 * @return the imageCdn
	 */
	public abstract String getImageCdn();

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public abstract String toString();

}