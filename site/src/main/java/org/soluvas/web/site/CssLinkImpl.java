package org.soluvas.web.site;

import org.soluvas.commons.WebAddress;

/**
 * Add a CSS Stylesheet reference.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CssLinkImpl implements CssLink {
	
	private final String path;
	private final int weight;
	private final String tenantId;
	
	/**
	 * 
	 * @param path
	 *            The path to the CSS file, relative to
	 *            {@link WebAddress#getSkinUri()} (without leading slash).
	 */
	public CssLinkImpl(String path) {
		this(path, 0, null);
	}

	/**
	 * 
	 * @param path
	 *            The path to the CSS file, relative to
	 *            {@link WebAddress#getSkinUri()} (without leading slash).
	 * @param weight
	 */
	public CssLinkImpl(String path, int weight) {
		this(path, weight, null);
	}
	
	/**
	 * @param path
	 * @param weight
	 * @param tenantId
	 */
	public CssLinkImpl(String path, int weight, String tenantId) {
		super();
		this.path = path;
		this.weight = weight;
		this.tenantId = tenantId;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#getPath()
	 */
	@Override
	public String getPath() {
		return path;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#getWeight()
	 */
	@Override
	public int getWeight() {
		return weight;
	}

	@Override
	public String getTenantId() {
		return tenantId;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#toString()
	 */
	@Override
	public String toString() {
		return String.format("JavaScriptLink [path=%s, weight=%s]", path, weight);
	}

}
