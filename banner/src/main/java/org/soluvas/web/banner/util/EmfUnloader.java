package org.soluvas.web.banner.util;

import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.banner.BannerPackage;

public class EmfUnloader {

	private transient Logger log = LoggerFactory.getLogger(EmfUnloader.class);
	
	public void destroy() {
		log.info("Unloading EMF Package {}", BannerPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(BannerPackage.eNS_URI);
	}

}
