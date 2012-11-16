package org.soluvas.web.site;

import java.io.Serializable;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.behavior.Behavior;

/**
 * Adds Backbone model instance with preloaded data.
 * Ideally, this can be added to any {@link Component}, not just to {@link Page}s.
 * Should be doable using {@link MarkupContainer#visitChildren(org.apache.wicket.util.visit.IVisitor)}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class BackboneModel<T extends Serializable> extends Behavior {
	
	private final String name;
	private final String className;
	private final T data;
	
	/**
	 * @param name
	 * @param className
	 * @param data
	 */
	public BackboneModel(String name, String className, T data) {
		super();
		this.name = name;
		this.className = className;
		this.data = data;
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
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BackboneModel [" + (name != null ? "name=" + name + ", " : "")
				+ (className != null ? "className=" + className + ", " : "")
				+ (data != null ? "data=" + data : "") + "]";
	}
	
}
