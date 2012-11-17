package org.soluvas.web.site.client;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.behavior.Behavior;
import org.soluvas.web.site.Page;

/**
 * Provides dependency to a JavaScript library.
 * Ideally, this can be added to any {@link Component}, not just to {@link Page}s.
 * Should be doable using {@link MarkupContainer#visitChildren(org.apache.wicket.util.visit.IVisitor)}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class AmdDependency extends Behavior {
	
	private final String path;
	private final String name;
	
	/**
	 * @param path
	 * @param name
	 */
	public AmdDependency(String path, String name) {
		super();
		this.path = path;
		this.name = name;
	}
	
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "AmdDependency [" + (path != null ? "path=" + path + ", " : "")
				+ (name != null ? "name=" + name : "") + "]";
	}
	
}
