package org.soluvas.web.site.client;

/**
 * Instantiates a Backbone View.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class BackboneViewWithoutModel extends JsSource {

	private final String name;
	private final String className;
	private final String elementId;
	
	/**
	 * @param name
	 * @param className
	 * @param modelName
	 * @param elementId
	 */
	public BackboneViewWithoutModel(String name, String className, 
			String elementId) {
		super();
		this.name = name;
		this.className = className;
		this.elementId = elementId;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the className
	 */
	public String getClassName() {
		return className;
	}

	/**
	 * @return the elementId
	 */
	public String getElementId() {
		return elementId;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BackboneViewWithoutModel [" + (name != null ? "name=" + name + ", " : "")
				+ (className != null ? "className=" + className + ", " : "")
				+ (elementId != null ? "elementId=" + elementId : "") + "]";
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.client.JsSource#getJsSource()
	 */
	@Override
	public String getJsSource() {
		return name + " = new "+ className + "({id: '"+ elementId +"', el: '#" + elementId + "'});";
	}

}
