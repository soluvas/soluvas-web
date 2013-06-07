package org.soluvas.web.site;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Iterator;

import javax.annotation.Nullable;

import org.apache.commons.codec.binary.Hex;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.PropertyModel;
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

import com.google.common.collect.ImmutableMap;

/**
 * TEMPORARY, ENHANCED version of EmfModel that works with Category ("parent") but unfortunately
 * messed up VariedProduct.
 * Serializes the {@link EObject} using {@link BinaryResourceImpl}.
 * @author haidar
 */
public class CategoryEmfModel<T extends EObject> extends LoadableDetachableModel<T> {

	private static final Logger log = LoggerFactory.getLogger(CategoryEmfModel.class);
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
	
	public CategoryEmfModel() {
		super();
	}

	public CategoryEmfModel(@Nullable T obj) {
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
	
	private void addMissedCrossRefs(EObject parent, Resource res) {
		final EList<EObject> crossRefs = parent.eCrossReferences();
		final Iterator<EObject> crossRefIterator = crossRefs.iterator();
		while (crossRefIterator.hasNext()) {
			final EObject child = crossRefIterator.next();
			if (child.eResource() == null) {
				log.trace("Adding missed crossref {}", child.eClass().getName());
				res.getContents().add(child);
//				addCrossRefs(child, res);
			}
		}
	}
	
	private void checkCrossRefs(EObject parent, Resource res) {
		final EList<EReference> refs = parent.eClass().getEAllReferences();
		for (EReference ref : refs) {
			final Object refObj = parent.eGet(ref, true);
			if (ref.isContainment()) {
				if (refObj instanceof EList) {
					final EList<EObject> grandchildObjs = (EList<EObject>) refObj;
					log.trace("Check {}#{} containment list of size {}", parent.eClass().getName(), ref.getName(), grandchildObjs.size());
					for (EObject grandchild : grandchildObjs) {
						checkCrossRefs(grandchild, res);
					}
				} else if (refObj != null) {
					final EObject refEObj = (EObject) refObj;
					checkCrossRefs(refEObj, res);
				}
			} else {
				if (refObj instanceof EList) {
					final EList<EObject> grandchildObjs = (EList<EObject>) refObj;
					log.trace("Adding {}#{} cross-reference list of size {}", parent.eClass().getName(), ref.getName(), grandchildObjs.size());
//				res.getContents().addAll(EcoreUtil.copyAll(grandchildObjs));
					for (EObject grandchild : grandchildObjs) {
						if (grandchild.eResource() == null) {
							res.getContents().add(grandchild);
						}
						checkCrossRefs(grandchild, res);
					}
				} else if (refObj != null) {
					final EObject refEObj = (EObject) refObj;
					// somewhat hardcoded
					if ("parent".equals(ref.getName())) {
						log.trace("Unsetting {}.{}={} (parent)", parent.eClass().getName(), ref.getName(), refEObj.eClass().getName());
						parent.eUnset(ref);
					} else if (refEObj.eResource() == null) {
						EList<EObject> x = refEObj.eCrossReferences();
						log.trace("Adding {}#{} {} with {} crossrefs", parent.eClass().getName(), ref.getName(), refEObj.eClass().getName(),
								x.size());
//					objectsToAdd.add((EObject) refObj);
						res.getContents().add(refEObj);
						checkCrossRefs(refEObj, res);
					}
				}
			}
		}
//		addMissedCrossRefs(parent, res);
	}
	
	@Override
	protected void onDetach() {
		final T obj = getObject();
		if (obj != null) {
			try {
//				log.trace("Serializing {} {}", 
//						new PropertyModel<String>(obj, "eClass.name").getObject(),
//						new PropertyModel<String>(obj, "id").getObject() );
				log.trace("Serializing {} {}", 
						new PropertyModel<String>(obj, "eClass.name").getObject() );
			} catch (Exception e) {
				log.trace("Serializing " + 
						new PropertyModel<String>(obj, "eClass.name").getObject(), e );
			}
			final Resource res = new XMIResourceImpl();
			final T copied = EcoreUtil.copy(obj);
			res.getContents().add(copied);
			checkCrossRefs(copied, res);
//			for (EObject addedObj : ImmutableList.copyOf(res.getContents())) {
//				addMissedCrossRefs(addedObj, res);
//			}
//			final List<EObject> allContents = ImmutableList.copyOf(EcoreUtil.<EObject>getAllContents(res, false));//copied.eAllContents();
//			final List<EObject> objectsToAdd = new ArrayList<>();
//			for (EObject child : allContents) {
//				final EList<EReference> refs = child.eClass().getEAllReferences();
//				for (EReference ref : refs) {
//					if (ref.isContainment()) {
//						continue;
//					}
//					
//					final Object refObj = child.eGet(ref, true);
//					if (refObj instanceof EList) {
//						final EList<EObject> grandchildObjs = (EList<EObject>) refObj;
//						log.trace("Adding {} {} in list", ref.getName(), grandchildObjs.size());
////						res.getContents().addAll(EcoreUtil.copyAll(grandchildObjs));
//						for (EObject grandchild : grandchildObjs) {
//							if (grandchild.eResource() == null) {
//								res.getContents().add(grandchild);
//							}
//							addCrossRefs(grandchild, res);
//						}
//					} else if (refObj != null) {
//						final EObject refEObj = (EObject) refObj;
//						if (EcoreUtil.isAncestor(refEObj, child)) {
//							log.trace("Skipping {}, ancestor of {}", refEObj.eClass().getName(), child.eClass().getName());
//							child.eUnset(ref);
//						} else if (refEObj.eResource() == null) {
//							EList<EObject> x = refEObj.eCrossReferences();
//							log.trace("Adding {}#{} {} with {} crossrefs", child.eClass().getName(), ref.getName(), refEObj.eClass().getName(),
//									x.size());
////							objectsToAdd.add((EObject) refObj);
//							res.getContents().add(refEObj);
//							addCrossRefs(refEObj, res);
//						}
//					}
//				}
//			}
//			res.getContents().addAll(objectsToAdd);
			try (final ByteArrayOutputStream out = new ByteArrayOutputStream()) {
				res.save(out, ImmutableMap.of(
						XMIResource.OPTION_ENCODING, "UTF-8",
						XMIResource.OPTION_BINARY, RESOURCE_CONTAINER == ResourceContainer.BINARY,
						XMIResource.OPTION_DEFER_IDREF_RESOLUTION, true
						));
				buf = out.toByteArray();
				if (RESOURCE_CONTAINER == ResourceContainer.XMI) {
					log.trace("Serialized {} to: {}", obj.eClass().getName(),
							new String(buf));
				} else {
					log.trace("Serialized {} as {} bytes", obj.eClass().getName(), buf.length);
				}
			} catch (Exception e) {
				throw new SiteException("Cannot serialize EObject " + obj.eClass().getName(), e);
			}
		}
	}

}
