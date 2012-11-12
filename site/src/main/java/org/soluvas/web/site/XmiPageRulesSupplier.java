package org.soluvas.web.site;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.XmiObjectLoader;
import org.soluvas.web.site.pagemeta.PageMetaPackage;
import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.pagemeta.PageRuleCollection;

import com.google.common.collect.ImmutableList;

/**
 * Loads {@link PageRule}s from a {@link PageRuleCollection} XMI file.
 * Uses {@link XmiObjectLoader} under the hood.
 * @author ceefour
 * @deprecated Please just supply a {@link PageRuleCollection}.
 */
@Deprecated
public class XmiPageRulesSupplier implements PageRulesSupplier {

	private transient Logger log = LoggerFactory
			.getLogger(XmiPageRulesSupplier.class);
	private final Class<?> loaderClass;
	private final String path;
	private List<PageRule> obj;
	
	public XmiPageRulesSupplier(PageMetaPackage ePackage, Class<?> loaderClass, String path) {
		super();
		this.loaderClass = loaderClass;
		this.path = path;
		load(ePackage);
	}
	
	public void destroy() {
		obj = null;
	}

	@Override
	public List<PageRule> get() {
		if (obj == null) {
			log.warn("Returning null, probably XMI Loader has been destroyed");
		}
		return obj;
	}

	protected void load(PageMetaPackage ePackage) {
		XmiObjectLoader<PageRuleCollection> pageRuleCollectionLoader = new XmiObjectLoader<PageRuleCollection>(
				ePackage, loaderClass, path);
		try {
			PageRuleCollection pageRuleCollection = pageRuleCollectionLoader.get();
			obj = ImmutableList.copyOf( pageRuleCollection.getRules() );
		} finally {
			pageRuleCollectionLoader.destroy();
		}
	}

}
