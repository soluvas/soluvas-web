package org.soluvas.web.site;

import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.soluvas.jaxrs.JaxrsUtils;
import org.soluvas.web.site.webaddress.WebAddress;

import com.google.common.base.Optional;
import com.google.common.base.Supplier;

/**
 * A dynamic {@link JavaScriptModule}. The path is relative to API path, e.g. from <tt>/cxf/api/</tt>
 * for development, or from <tt>/api/</tt> for staging/production.
 * 
 * It will look for a {@link Supplier} of {@link WebAddress} in the OSGi services,
 * in order to get the <tt>apiPath</tt>.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class DynamicJavaScriptModule implements JavaScriptModule {

	private String name;
	private String relativePath;
	
	/**
	 * Creates a dynamic {@link JavaScriptModule}. The path is relative to API path, e.g. from <tt>/cxf/api/</tt>
	 * for development, or from <tt>/api/</tt> for staging/production. Do not put leading slash in the path. 
	 * @param name
	 * @param relativePath
	 */
	public DynamicJavaScriptModule(String name, String relativePath) {
		super();
		this.name = name;
		this.relativePath = relativePath;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptModule#getName()
	 */
	@Override
	public String getName() {
		return name;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptModule#getPath()
	 */
	@Override
	public String getPath() {
		BundleContext bundleContext = FrameworkUtil.getBundle(DynamicJavaScriptModule.class).getBundleContext();
		// TODO: get tenant info
		return relativePath;
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptModule#getMinifiedPath()
	 */
	@Override
	public String getMinifiedPath() {
		return getPath();
	}
	
	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptModule#compareTo(org.soluvas.web.site.JavaScriptModuleImpl)
	 */
	@Override
	public int compareTo(JavaScriptModule o) {
		return Optional.fromNullable(getName()).or("").compareToIgnoreCase(o.getName());
	}

	@Override
	public Base getBase() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
