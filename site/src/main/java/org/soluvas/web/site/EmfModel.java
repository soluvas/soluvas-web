package org.soluvas.web.site;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import org.apache.commons.codec.binary.Hex;
import org.apache.wicket.model.LoadableDetachableModel;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.BinaryResourceImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMIResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Identifiable;
import org.soluvas.commons.Nameable;

import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

/**
 * Serializes the {@link EObject} using {@link BinaryResourceImpl}.
 * @todo Deal with "org.eclipse.emf.ecore.xmi.PackageNotFoundException: Package with uri 'http://www.bippo.co.id/schema/cart/1.0' not found. (, 3, 68)"
 *		by also serializing the identity of the EPackage, and making sure it's loaded before parsing the serialized buf. 
 * @author haidar
 */
public class EmfModel<T extends EObject> extends LoadableDetachableModel<T> {

	private static final Logger log = LoggerFactory.getLogger(EmfModel.class);
	private static final long serialVersionUID = 1L;
	public static enum ResourceContainer {
		XMI,
		/**
		 * I tried using BinaryResourceImpl and XMIResource.OPTION_BINARY but never worked:
		 * 
		 * <pre>
		 * Last cause: attributes.base_color for product tuneeca_t_0513039_1072 must not be null (found attributes: [base_color, base_careInstructions, base_size, base_material, base_fabric, base_waistSize, base_motif, base_dressLength, base_shippingPolicy, base_age, base_bustSize, base_origin, base_technique])
		 * WicketMessage: Method onRequest of interface org.apache.wicket.behavior.IBehaviorListener targeted at org.apache.wicket.ajax.markup.html.form.AjaxButton$1@51de6355 on component [IndicatingAjaxButton [Component id = saveBtn]] threw an exception
		 * </pre>
		 * 
		 * Although might be a bug on my Wicket part.
		 */
		BINARY
	};
	/**
	 * Switchable to make it easily debuggable when problems arise.
	 */
	public static final ResourceContainer RESOURCE_CONTAINER = ResourceContainer.XMI;
	private byte[] buf;
	
	private static class EObjectToString implements Function<EObject, String> {
		@Override @Nullable
		public String apply(@Nullable EObject input) {
			if (input instanceof Identifiable) {
				return input.eClass().getName() + "@" + Integer.toHexString(input.hashCode()) + " " + ((Identifiable) input).getId();
			} else if (input instanceof Nameable) {
					return input.eClass().getName() + "@" + Integer.toHexString(input.hashCode()) + " " + ((Nameable) input).getName();
			} else {
				return input.eClass().getName() + "@" + Integer.toHexString(input.hashCode());
			}
		}
	}
	
	private static final EObjectToString EOBJECT_TO_STRING = new EObjectToString();
	
	public EmfModel() {
		super();
	}

	public EmfModel(@Nullable T obj) {
		super(obj);
	}

	@Override
	protected T load() {
		if (buf != null) {
			final Resource res = new XMIResourceImpl();
			try {
				res.load(new ByteArrayInputStream(buf), ImmutableMap.of(
						XMIResource.OPTION_BINARY, RESOURCE_CONTAINER == ResourceContainer.BINARY,
						XMIResource.OPTION_DEFER_IDREF_RESOLUTION, true
					));
			} catch (IOException e) {
				if (RESOURCE_CONTAINER == ResourceContainer.XMI) {
					throw new SiteException("Cannot deserialize EObject from " + buf.length + " bytes: " + new String(buf), e);
				} else {
					final String hexString = Hex.encodeHexString(buf);
					throw new SiteException("Cannot deserialize EObject from " + buf.length + " bytes: " + hexString, e);
				}					
			}
			// FIXME: EcoreUtil.copy shouldn't be needed, fix this at Morphia, please:
			// https://github.com/soluvas/morphia/issues/8
			final T obj = (T) res.getContents().get(0);
//			final Iterator<EObject> resContents = res.getContents().iterator();
//			while (resContents.hasNext()) {
//				final EObject cur = resContents.next();
//				log.debug("Removing {}", cur.eClass().getName());
//				resContents.remove();
//			}
			log.trace("De-Serialized {}", obj.eClass().getName());
			return obj;
		} else {
			log.trace("De-Serialized null");
			return null;
		}
	}
	
	private void addLegacyCrossRefs(EObject parent, Resource res) {
		final EList<EObject> crossRefs = parent.eCrossReferences();
		final Iterator<EObject> crossRefIterator = crossRefs.iterator();
		while (crossRefIterator.hasNext()) {
			final EObject child = crossRefIterator.next();
			if (child.eResource() == null) {
//				log.trace("LEGACY Adding crossref {}", EOBJECT_TO_STRING.apply(child));
//				res.getContents().add(child);
				
				log.trace("LEGACY NOT Adding crossref {}", EOBJECT_TO_STRING.apply(child));
				
//				addCrossRefs(child, res);
			}
		}
	}

	private void checkCrossRefs(EObject child, Resource res, Set<EObject> checkedEObjects) {
		if (!checkedEObjects.add(child)) {
			// if already checked, do nothing, to avoid StackOverflowError
			return;
		}
		
		final EList<EReference> refs = child.eClass().getEAllReferences();
//		log.trace("{} has {} refs: {}", EOBJECT_TO_STRING.apply(child), refs.size(), refs);
		for (EReference ref : refs) {
			final Object refObj = child.eGet(ref, true);
			if (refObj instanceof EList) {
				final EList<EObject> grandchildObjs = (EList<EObject>) refObj;
				if (!grandchildObjs.isEmpty()) {
					log.trace("Adding {} (probably contained) objects from list {}#{}: {}", grandchildObjs.size(), EOBJECT_TO_STRING.apply(child), ref.getName(),
							Lists.transform(grandchildObjs, EOBJECT_TO_STRING));
	//				res.getContents().addAll(grandchildObjs); // dupes will be ignored
					for (EObject grandchild : grandchildObjs) {
						if (grandchild.eResource() != res) {
							res.getContents().add(grandchild);
						}
	//					addCrossRefs(grandchild, res);
						checkCrossRefs(grandchild, res, checkedEObjects);
					}
				}
			} else if (refObj != null) {
				final EObject refEObj = (EObject) refObj;
//				if (!res.getContents().contains(refEObj)) {
				if (!ref.isContainment() && refEObj.eResource() != res) {
					EList<EObject> x = refEObj.eCrossReferences();
					log.trace("Adding {} from {}#{} {} (with {} crossrefs)", EOBJECT_TO_STRING.apply(refEObj),
							EOBJECT_TO_STRING.apply(child), ref.getName(), refEObj.eClass().getName(),
							x.size());
//					objectsToAdd.add((EObject) refObj);
					res.getContents().add((EObject) refObj);
//					addCrossRefs(refEObj, res);
				} else {
//					log.trace("{} from {}#{} already in resource {}", 
//							EOBJECT_TO_STRING.apply(refEObj), EOBJECT_TO_STRING.apply(child), ref.getName(), refEObj.eResource());
				}
				checkCrossRefs(refEObj, res, checkedEObjects);
			}
		}
	}
	
	@Override
	protected void onDetach() {
		final T obj = getObject();
		if (obj != null) {
			log.trace("Serializing {}", EOBJECT_TO_STRING.apply(obj) );
			try {
				final Resource res = new XMIResourceImpl();
				final T copied = EcoreUtil.copy(obj);
				res.getContents().add(copied);
				
				addLegacyCrossRefs(copied, res);
				
				final List<EObject> allContents = ImmutableList.copyOf(EcoreUtil.<EObject>getAllContents(res, false));//copied.eAllContents();
	//			final List<EObject> objectsToAdd = new ArrayList<>();
				final Set<EObject> checkedEObjects = new HashSet<>();
				for (EObject child : allContents) {
					checkCrossRefs(child, res, checkedEObjects);
				}
	//			res.getContents().addAll(objectsToAdd);
				try (final ByteArrayOutputStream out = new ByteArrayOutputStream()) {
					log.trace("Serializing {} as {} objects: {}", obj.eClass().getName(), res.getContents().size(),
							Lists.transform(res.getContents(), EOBJECT_TO_STRING));
					res.save(out, ImmutableMap.of(
							XMIResource.OPTION_ENCODING, "UTF-8",
							XMIResource.OPTION_BINARY, RESOURCE_CONTAINER == ResourceContainer.BINARY,
							XMIResource.OPTION_DEFER_IDREF_RESOLUTION, true
							));
					buf = out.toByteArray();
					if (RESOURCE_CONTAINER == ResourceContainer.XMI) {
						log.trace("Serialized {} to: {}", EOBJECT_TO_STRING.apply(obj),
								new String(buf));
					} else {
						log.trace("Serialized {} as {} bytes", EOBJECT_TO_STRING.apply(obj), buf.length);
					}
				}
			} catch (Exception e) {
				throw new SiteException("Cannot serialize EObject " + EOBJECT_TO_STRING.apply(obj), e);
			}
		}
	}

}
