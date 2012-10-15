package org.soluvas.web.site;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import com.google.common.collect.ImmutableList;

/**
 * Loads {@link PageRule}s from a {@link PageRuleCatalog} XMI file.
 * @author ceefour
 */
public class XmiPageRulesSupplier implements PageRulesSupplier {

	private Class loaderClass;
	private String path;
	
	public XmiPageRulesSupplier(Class loaderClass, String path) {
		super();
		this.loaderClass = loaderClass;
		this.path = path;
	}

	@Override
	public List<PageRule> get() {
		ResourceSetImpl rset = new ResourceSetImpl();
		rset.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
		rset.getPackageRegistry().put(SitePackage.eNS_URI, SitePackage.eINSTANCE);
		String uri = loaderClass.getResource(path).toString();
		Resource resource = rset.getResource(URI.createURI(uri), true);
		PageRuleCatalog catalog = (PageRuleCatalog) resource.getContents().get(0);
		return ImmutableList.copyOf( catalog.getRules() );
	}

}
