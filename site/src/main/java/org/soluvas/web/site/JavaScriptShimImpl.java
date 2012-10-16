package org.soluvas.web.site;

import java.io.Serializable;
import java.util.Set;

import com.google.common.base.Optional;

/**
 * AMD Shim config, for those libraries who aren't AMD-ready.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class JavaScriptShimImpl implements JavaScriptShim {

	private String name;
	private Set<String> dependencies;
	private String exports;
	
	public JavaScriptShimImpl() {
		super();
	}

	public JavaScriptShimImpl(String name, Set<String> dependencies) {
		super();
		this.name = name;
		this.dependencies = dependencies;
	}

	public JavaScriptShimImpl(String name, Set<String> dependencies, String exports) {
		super();
		this.name = name;
		this.dependencies = dependencies;
		this.exports = exports;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptShim#getName()
	 */
	@Override
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptShim#setName(java.lang.String)
	 */
	@Override
	public void setName(String name) {
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptShim#getDependencies()
	 */
	@Override
	public Set<String> getDependencies() {
		return dependencies;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptShim#setDependencies(java.util.Set)
	 */
	@Override
	public void setDependencies(Set<String> dependencies) {
		this.dependencies = dependencies;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptShim#getExports()
	 */
	@Override
	public String getExports() {
		return exports;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptShim#setExports(java.lang.String)
	 */
	@Override
	public void setExports(String exports) {
		this.exports = exports;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptShim#toString()
	 */
	@Override
	public String toString() {
		return String.format(
				"JavaScriptShimImpl [name=%s, dependencies=%s, exports=%s]", name,
				dependencies, exports);
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptShim#compareTo(org.soluvas.web.site.JavaScriptShimImpl)
	 */
	@Override
	public int compareTo(JavaScriptShim o) {
		return Optional.fromNullable(getName()).or("").compareToIgnoreCase(o.getName());
	}
	
}
