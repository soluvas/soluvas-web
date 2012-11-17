package org.soluvas.web.site.client;

/**
 * Adds arbitrary JavaScript Code to the page. 
 * @author ceefour
 *
 */
@SuppressWarnings("serial")
public class CustomJsSource extends JsSource {
	
	private final String code;
	
	/**
	 * @param code
	 */
	public CustomJsSource(String code) {
		super();
		this.code = code;
	}
	
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CustomJsSource [" + (code != null ? "code=" + code : "") + "]";
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.client.JsSource#getJsSource()
	 */
	@Override
	public String getJsSource() {
		return code;
	}

}
