package org.soluvas.web.site.client;

import java.io.Serializable;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;
import org.osgi.framework.ServiceReference;
import org.soluvas.json.JacksonMapperFactory;
import org.soluvas.web.site.Page;
import org.soluvas.web.site.SiteException;

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
	private final IModel<T> model;
	
	/**
	 * @param name
	 * @param className
	 * @param data
	 */
	@SuppressWarnings("unchecked")
	public PlainModel(String name, T data) {
		super();
		this.name = name;
		this.model = (IModel<T>) Model.of((Serializable) data);
	}

	/**
	 * @param name
	 * @param className
	 * @param model
	 */
	public PlainModel(String name, IModel<T> model) {
		super();
		this.name = name;
		this.model = model;
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
		return model.getObject();
	}

	@Override
	public String getJsSource() {
		final BundleContext bundleContext = FrameworkUtil.getBundle(PlainModel.class).getBundleContext();
		final ServiceReference<JacksonMapperFactory> jacksonMapperFactoryRef = bundleContext.getServiceReference(JacksonMapperFactory.class);
		final Supplier<ObjectMapper> jacksonMapperFactory = bundleContext.getService(jacksonMapperFactoryRef);
		final T data = model.getObject();
		try {
			final ObjectMapper objectMapper = jacksonMapperFactory.get();
			return name + " = " + objectMapper.writeValueAsString(data) + ";";
		} catch (Exception e) {
			throw new SiteException("Cannot serialize model to JSON: " + name + " from " + data, e);
		} finally {
			bundleContext.ungetService(jacksonMapperFactoryRef);
		}
	}
	
}
