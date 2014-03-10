package org.soluvas.web.site;

import java.io.Serializable;

/**
 * @author ceefour
 * @deprecated Use Wicket's renderHead() mechanism.
 */
@Deprecated
public interface JavaScriptModule extends Serializable, Comparable<JavaScriptModule> {
	
	/**
	 * Base JavaScript URI.
	 * @author ceefour
	 */
	public static enum Base {
		/**
		 * Use the base URI for static JavaScript files, e.g. <tt>/static/js/</tt> or <tt>http://js.berbatik.com/</tt>.
		 * This has the same effect as no base, because the base URI is provided in RequireJS configuration.
		 */
		STATIC,
		/**
		 * Use the base URI for dynamic JavaScript files, implemented using JAX-RS Resources,
		 * e.g. <tt>/cxf/api/</tt> or <tt>http://www.berbatik.com/api/</tt>
		 */
		DYNAMIC
	};

	public abstract String getName();

	public abstract String getPath();

	public abstract String getMinifiedPath();
	
	/**
	 * Base URI.
	 * @return
	 */
	public abstract Base getBase();

	@Override
	public abstract String toString();

	@Override
	public abstract int compareTo(JavaScriptModule o);

}
