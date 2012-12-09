package org.soluvas.web.site.client;

import java.io.Serializable;

import javax.annotation.Nonnull;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
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
	private final IModel<T> model;
	
	/**
	 * @param name
	 * @param className
	 * @param data
	 */
	@Deprecated
	public BackboneModel(String name, String className, @Nonnull final T data) {
		super();
		this.name = name;
		this.className = className;
		this.model = data instanceof Serializable
				? new Model((Serializable) data)
				: new LoadableDetachableModel<T>() {
			@Override
			protected T load() {
				return data;
			}
		};
	}

	/**
	 * @param name
	 * @param className
	 * @param data
	 */
	public BackboneModel(String name, String className, IModel<T> data) {
		super();
		this.name = name;
		this.className = className;
		this.model = data;
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
	 * @return the model
	 */
	public IModel<T> getModel() {
		return model;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "BackboneModel [" + (name != null ? "name=" + name + ", " : "")
				+ (className != null ? "className=" + className + ", " : "")
				+ (model != null ? "model=" + model : "") + "]";
	}
	
	@Override
	public String getJsSource() {
		final BundleContext bundleContext = FrameworkUtil.getBundle(BackboneModel.class).getBundleContext();
		final ServiceReference<JacksonMapperFactory> jacksonMapperFactoryRef = bundleContext.getServiceReference(JacksonMapperFactory.class);
		final Supplier<ObjectMapper> jacksonMapperFactory = bundleContext.getService(jacksonMapperFactoryRef);
		final ObjectMapper objectMapper = jacksonMapperFactory.get();
		final T data = model.getObject();
		try {
			return name + " = new "+ className + "(" + objectMapper.writeValueAsString(data) + ");";
		} catch (Exception e) {
			throw new RuntimeException("Cannot serialize model to JSON: " + name + ": " + className + " from " + model, e);
		} finally {
			bundleContext.ungetService(jacksonMapperFactoryRef);
		}
	}
	
}
