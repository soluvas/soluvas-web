package org.soluvas.web.site;


/**
 * @author ceefour
 */
@SuppressWarnings("serial")
@Deprecated
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
	public int getWeight() {
		return weight;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#setWeight(int)
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public int compareTo(JavaScriptSource o) {
		return o != null && o instanceof JavaScriptSourceImpl ? weight - ((JavaScriptSourceImpl) o).getWeight() : 0;
	}

	@Override
	public String toString() {
		return String.format("JavaScriptSourceImpl [body=%s, weight=%d]",
				body, weight);
	}

	@Override
	public String getScript() {
		return body;
	}

}
