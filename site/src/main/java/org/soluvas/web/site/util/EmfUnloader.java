package org.soluvas.web.site.util;

import org.eclipse.emf.ecore.EPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.web.site.SitePackage;
import org.soluvas.web.site.pagemeta.PageMetaPackage;

public class EmfUnloader {

	private transient Logger log = LoggerFactory.getLogger(EmfUnloader.class);
	
	public void destroy() {
		log.info("Unloading EMF Package {}", PageMetaPackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(PageMetaPackage.eNS_URI);
		log.info("Unloading EMF Package {}", SitePackage.eNS_URI);
		EPackage.Registry.INSTANCE.remove(SitePackage.eNS_URI);
	}

}
