package org.soluvas.web.site;

import org.soluvas.commons.WebAddress;

/**
 * Add a CSS Stylesheet reference.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CssLinkImpl implements CssLink {
	
	private String path;
	private int weight;
	
	/**
	 * 
	 * @param path
	 *            The path to the CSS file, relative to
	 *            {@link WebAddress#getSkinUri()} (without leading slash).
	 */
	public CssLinkImpl(String path) {
		super();
		this.path = path;
	}

	/**
	 * 
	 * @param path
	 *            The path to the CSS file, relative to
	 *            {@link WebAddress#getSkinUri()} (without leading slash).
	 * @param weight
	 */
	public CssLinkImpl(String path, int weight) {
		super();
		this.path = path;
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#getPath()
	 */
	@Override
	public String getPath() {
		return path;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#setPath(java.lang.String)
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#getWeight()
	 */
	@Override
	public int getWeight() {
		return weight;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#setWeight(int)
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#toString()
	 */
	@Override
	public String toString() {
		return String.format("JavaScriptLink [path=%s, weight=%s]", path, weight);
	}

}
