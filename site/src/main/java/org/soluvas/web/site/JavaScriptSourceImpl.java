package org.soluvas.web.site;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class JavaScriptSourceImpl implements JavaScriptSource {
	
	private String body;
	private int weight;
	
	public JavaScriptSourceImpl() {
		super();
	}

	public JavaScriptSourceImpl(String body, int weight) {
		super();
		this.body = body;
		this.weight = weight;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#getBody()
	 */
	@Override
	public String getBody() {
		return body;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#setBody(java.lang.String)
	 */
	@Override
	public void setBody(String body) {
		this.body = body;
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
		return String.format("JavaScriptLink [body=%s, weight=%s]", body, weight);
	}

}
