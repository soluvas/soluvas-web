package org.soluvas.web.nav;

import org.eclipse.emf.ecore.EPackage;

/**
 * Unloads NavPackage from EPackage registry.
 * @author ceefour
 */
public class NavPackageUnloader {

	public void destroy() {
		EPackage.Registry.INSTANCE.remove(NavPackage.eNS_URI);
	}

}
