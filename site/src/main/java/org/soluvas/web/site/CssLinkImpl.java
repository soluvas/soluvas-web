package org.soluvas.web.site;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CssLinkImpl implements CssLink {
	
	private String href;
	private int weight;
	
	public CssLinkImpl() {
		super();
	}

	public CssLinkImpl(String href, int weight) {
		super();
		this.href = href;
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#getHref()
	 */
	@Override
	public String getHref() {
		return href;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#setHref(java.lang.String)
	 */
	@Override
	public void setHref(String href) {
		this.href = href;
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
	@Override
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#toString()
	 */
	public String toString() {
		return String.format("JavaScriptLink [href=%s, weight=%s]", href, weight);
	}

}
