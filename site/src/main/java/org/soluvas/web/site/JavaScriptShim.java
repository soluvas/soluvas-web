package org.soluvas.web.site;

import java.io.Serializable;
import java.util.Set;

/**
 * AMD Shim config, for those libraries who aren't AMD-ready.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class JavaScriptShim implements Serializable {

	private String name;
	private Set<String> dependencies;
	private String exports;
	
	public JavaScriptShim() {
		super();
	}

	public JavaScriptShim(String name, Set<String> dependencies) {
		super();
		this.name = name;
		this.dependencies = dependencies;
	}

	public JavaScriptShim(String name, Set<String> dependencies, String exports) {
		super();
		this.name = name;
		this.dependencies = dependencies;
		this.exports = exports;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<String> getDependencies() {
		return dependencies;
	}

	public void setDependencies(Set<String> dependencies) {
		this.dependencies = dependencies;
	}

	public String getExports() {
		return exports;
	}

	public void setExports(String exports) {
		this.exports = exports;
	}

	@Override
	public String toString() {
		return String.format(
				"JavaScriptShim [name=%s, dependencies=%s, exports=%s]", name,
				dependencies, exports);
	}
	
}
