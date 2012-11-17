package org.soluvas.web.site.client;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.soluvas.json.JacksonMapperFactory;
import org.soluvas.web.site.Page;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Supplier;

/**
 * Adds Backbone model instance with preloaded data.
 * Ideally, this can be added to any {@link Component}, not just to {@link Page}s.
 * Should be doable using {@link MarkupContainer#visitChildren(org.apache.wicket.util.visit.IVisitor)}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class BackboneModel<T> extends JsSource {
	
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
	
	@Override
	public String getJsSource() {
		final BundleContext bundleContext = FrameworkUtil.getBundle(BackboneModel.class).getBundleContext();
		final ServiceReference<JacksonMapperFactory> jacksonMapperFactoryRef = bundleContext.getServiceReference(JacksonMapperFactory.class);
		final Supplier<ObjectMapper> jacksonMapperFactory = bundleContext.getService(jacksonMapperFactoryRef);
		try {
			final ObjectMapper objectMapper = jacksonMapperFactory.get();
			return name + " = new "+ className + "(" + objectMapper.writeValueAsString(data) + ");";
		} catch (Exception e) {
			throw new RuntimeException("Cannot serialize model to JSON: " + name + ": " + className + " from " + data, e);
		} finally {
			bundleContext.ungetService(jacksonMapperFactoryRef);
		}
	}
	
}
