package org.soluvas.web.site;


/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class JavaScriptLinkImpl implements JavaScriptLink {
	
	private String src;
	private int weight;
	
	public JavaScriptLinkImpl() {
		super();
	}

	public JavaScriptLinkImpl(String src) {
		super();
		this.src = src;
	}

	public JavaScriptLinkImpl(String src, int weight) {
		super();
		this.src = src;
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#getSrc()
	 */
	@Override
	public String getSrc() {
		return src;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#setSrc(java.lang.String)
	 */
	@Override
	public void setSrc(String src) {
		this.src = src;
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
		return String.format("JavaScriptLink [src=%s, weight=%s]", src, weight);
	}

}
