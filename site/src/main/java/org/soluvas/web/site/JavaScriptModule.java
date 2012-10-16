package org.soluvas.web.site;

import java.io.Serializable;

public interface JavaScriptModule extends Serializable, Comparable<JavaScriptModule> {

	public abstract String getName();

	public abstract void setName(String name);

	public abstract String getPath();

	public abstract void setPath(String path);

	public abstract String getMinifiedPath();

	public abstract void setMinifiedPath(String minifiedPath);

	public abstract String toString();

	public abstract int compareTo(JavaScriptModule o);

}