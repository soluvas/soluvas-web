package org.soluvas.web.nav;

import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Unloads NavPackage from EPackage registry.
 * @author ceefour
 */
public class NavPackageLoader {

	private transient Logger log = LoggerFactory.getLogger(NavPackageLoader.class);
	
	public NavPackageLoader() {
		log.trace("Loading EPackage {}", NavPackage.eINSTANCE);
	}
	
	public void destroy() {
		EPackage.Registry.INSTANCE.remove(NavPackage.eNS_URI);
	}

}
