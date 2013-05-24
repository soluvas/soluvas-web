package org.soluvas.web.site;

import java.io.IOException;

import org.apache.commons.codec.binary.Hex;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.json.JsonUtils;

/**
 * Serializes the {@link EObject} using {@link BinaryResourceImpl}.
 * @author haidar
 */
public class EmfModel2<T extends EObject> extends LoadableDetachableModel<T> {

	private static final Logger log = LoggerFactory.getLogger(EmfModel2.class);
	private static final long serialVersionUID = 1L;
	private byte[] buf;
	private Class<T> clazz;
	
	public EmfModel2() {
		super();
	}

	public EmfModel2(T obj) {
		super(obj);
	}

	@Override
	protected T load() {
		if (buf != null) {
			final T obj;
			try {
				obj = JsonUtils.mapper.readValue(buf, clazz);
			} catch (IOException e) {
				final String hexString = Hex.encodeHexString(buf);
				throw new RuntimeException("Cannot deserialize EObject from " + buf.length + " bytes: " + hexString, e);
			}
			log.info("De-Serialized {} careInstructions={}", new PropertyModel<String>(obj, "attributes.map.base_careInstructions.0").getObject());
			return obj;
		} else {
			log.info("De-Serialized null");
			return null;
		}
	}
	
	@Override
	protected void onDetach() {
		final T obj = getObject();
		if (obj != null) {
			log.info("Serializing {} careInstructions={}", 
					new PropertyModel<String>(obj, "eClass.name").getObject(),
					new PropertyModel<String>(obj, "attributes.map.base_careInstructions.0").getObject());
			buf = JsonUtils.asJson(obj).getBytes();
			clazz = (Class<T>) obj.getClass();
			log.debug("Serialized {} to: {}", obj.eClass().getName(),
					new String(buf));
//			try (final ByteArrayOutputStream out = new ByteArrayOutputStream()) {
//				res.save(out, ImmutableMap.of(XMIResource.OPTION_DEFER_IDREF_RESOLUTION, true));
//				buf = out.toByteArray();
//				log.debug("Serialized {} to: {}", obj.eClass().getName(),
//						new String(buf));
//			} catch (IOException e) {
//				throw new RuntimeException("Cannot serialize EObject", e);
//			}
			// log.debug("Serialized {} to {} bytes", obj.eClass().getName(),
			// buf.length);
		}
	}

}
