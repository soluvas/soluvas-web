package org.soluvas.web.site;

import java.io.Serializable;

import com.google.common.base.Optional;

/**
 * @author ceefour
 */
@SuppressWarnings("serial")
public class JavaScriptModule implements Serializable, Comparable<JavaScriptModule> {

	private String name;
	private String path;
	private String minifiedPath;
	
	public JavaScriptModule() {
		super();
	}
	
	public JavaScriptModule(String name, String path) {
		super();
		this.name = name;
		this.path = path;
	}
	
	public JavaScriptModule(String name, String path, String minifiedPath) {
		super();
		this.name = name;
		this.path = path;
		this.minifiedPath = minifiedPath;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	
	public String getMinifiedPath() {
		return minifiedPath;
	}
	
	public void setMinifiedPath(String minifiedPath) {
		this.minifiedPath = minifiedPath;
	}
	
	@Override
	public String toString() {
		return String.format(
				"JavaScriptModule [name=%s, path=%s, minifiedPath=%s]", name,
				path, minifiedPath);
	}

	@Override
	public int compareTo(JavaScriptModule o) {
		return Optional.fromNullable(getName()).or("").compareToIgnoreCase(o.getName());
	}
	
}
