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
 * Adds plain model instance with preloaded data.
 * Ideally, this can be added to any {@link Component}, not just to {@link Page}s.
 * Should be doable using {@link MarkupContainer#visitChildren(org.apache.wicket.util.visit.IVisitor)}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class PlainModel<T> extends JsSource {
	
	private final String name;
	private final T data;
	
	/**
	 * @param name
	 * @param className
	 * @param data
	 */
	public PlainModel(String name, T data) {
		super();
		this.name = name;
		this.data = data;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
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
		return "PlainModel [" + (name != null ? "name=" + name + ", " : "")
				+ (data != null ? "data=" + data : "") + "]";
	}

	@Override
	public String getJsSource() {
		final BundleContext bundleContext = FrameworkUtil.getBundle(PlainModel.class).getBundleContext();
		final ServiceReference<JacksonMapperFactory> jacksonMapperFactoryRef = bundleContext.getServiceReference(JacksonMapperFactory.class);
		final Supplier<ObjectMapper> jacksonMapperFactory = bundleContext.getService(jacksonMapperFactoryRef);
		try {
			final ObjectMapper objectMapper = jacksonMapperFactory.get();
			return name + " = " + objectMapper.writeValueAsString(data) + ";";
		} catch (Exception e) {
			throw new RuntimeException("Cannot serialize model to JSON: " + name + " from " + data, e);
		} finally {
			bundleContext.ungetService(jacksonMapperFactoryRef);
		}
	}
	
}
