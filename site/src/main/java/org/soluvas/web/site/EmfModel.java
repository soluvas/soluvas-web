package org.soluvas.web.site;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.codec.binary.Hex;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;

/**
 * Serializes the {@link EObject} using {@link BinaryResourceImpl}.
 * @author haidar
 */
public class EmfModel<T extends EObject> extends LoadableDetachableModel<T> {

	private static final Logger log = LoggerFactory.getLogger(EmfModel.class);
	private static final long serialVersionUID = 1L;
	private byte[] buf;
	
	public EmfModel() {
		super();
	}

	public EmfModel(T obj) {
		super(obj);
	}

	@Override
	protected T load() {
		if (buf != null) {
			 final XMIResourceImpl res = new XMIResourceImpl();
//			final BinaryResourceImpl res = new BinaryResourceImpl();
			try {
				res.load(new ByteArrayInputStream(buf), ImmutableMap.of(XMIResource.OPTION_DEFER_IDREF_RESOLUTION, true));
			} catch (IOException e) {
				final String hexString = Hex.encodeHexString(buf);
				throw new RuntimeException("Cannot deserialize EObject from " + buf.length + " bytes: " + hexString, e);
			}
			// FIXME: EcoreUtil.copy shouldn't be needed, fix this at Morphia, please:
			// https://github.com/soluvas/morphia/issues/8
			final T obj = (T) EcoreUtil.copy(res.getContents().get(0));
			log.info("De-Serialized {} careInstructions={}", new PropertyModel<String>(obj, "attributes.map.base_careInstructions.0").getObject());
			return obj;
		} else {
			log.info("De-Serialized null");
			return null;
		}
	}
	
	private void addCrossRefs(EObject parent, Resource res) {
		EList<EObject> crossRefs = parent.eCrossReferences();
		Iterator<EObject> crossRefIterator = crossRefs.iterator();
		while (crossRefIterator.hasNext()) {
			final EObject child = crossRefIterator.next();
//			if (child.eResource() != res) {
				log.debug("Adding {}", child.eClass().getName());
				res.getContents().add(child);
//				addCrossRefs(child, res);
//			}
		}
	}
	
	@Override
	protected void onDetach() {
		final T obj = getObject();
		log.info("Serializing {} careInstructions={}", 
				new PropertyModel<String>(obj, "eClass.name").getObject(),
				new PropertyModel<String>(obj, "attributes.map.base_careInstructions.0").getObject());
		if (obj != null) {
			final XMIResourceImpl res = new XMIResourceImpl();
//			final BinaryResourceImpl res = new BinaryResourceImpl();
			final T copied = EcoreUtil.copy(obj);
			res.getContents().add(copied);
			addCrossRefs(copied, res);
			final TreeIterator<EObject> allContents = copied.eAllContents();
			while (allContents.hasNext()) {
				EObject child = allContents.next();
				EList<EReference> refs = child.eClass().getEAllReferences();
				for (EReference ref : refs) {
					if (ref.isContainment()) {
						continue;
					}
					
					Object refObj = child.eGet(ref, true);
					if (refObj instanceof EList) {
						log.debug("Adding {} {} in list", ref.getName(), ((EList) refObj).size());
						res.getContents().addAll((Collection<? extends EObject>) refObj);
					} else if (refObj != null) {
						log.debug("Adding {} {}", ref.getName(), ((EObject) refObj).eClass().getName());
						res.getContents().add((EObject) refObj);
					}
				}
			}
			try (final ByteArrayOutputStream out = new ByteArrayOutputStream()) {
				res.save(out, ImmutableMap.of(XMIResource.OPTION_DEFER_IDREF_RESOLUTION, true));
				buf = out.toByteArray();
				log.debug("Serialized {} to: {}", obj.eClass().getName(),
						new String(buf));
			} catch (IOException e) {
				throw new RuntimeException("Cannot serialize EObject", e);
			}
			// log.debug("Serialized {} to {} bytes", obj.eClass().getName(),
			// buf.length);
		}
	}

}
