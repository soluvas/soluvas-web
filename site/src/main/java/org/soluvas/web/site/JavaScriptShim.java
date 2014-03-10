package org.soluvas.web.site;

import java.io.Serializable;
import java.util.Set;

/**
 * @author ceefour
 * @deprecated Use Wicket's renderHead() mechanism.
 */
@Deprecated
public interface JavaScriptShim extends Serializable, Comparable<JavaScriptShim> {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract Set<String> getDependencies();

	public abstract void setDependencies(Set<String> dependencies);

	public abstract String getExports();

	public abstract void setExports(String exports);

	@Override
	public abstract String toString();

	@Override
	public abstract int compareTo(JavaScriptShim o);

}