package org.soluvas.web.site.client;

/**
 * Renders a particular Backbone View instance.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class RenderBackboneView extends JsSource {
	
	private final String viewId;
	
	/**
	 * @param viewId Backbone view ID (JavaScript object name).
	 */
	public RenderBackboneView(String viewId) {
		super();
		this.viewId = viewId;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.client.JsSource#getJsSource()
	 */
	@Override
	public String getJsSource() {
		return viewId + ".render();";
	}

}
