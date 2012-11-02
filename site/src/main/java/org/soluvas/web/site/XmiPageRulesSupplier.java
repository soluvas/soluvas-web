package org.soluvas.web.site;

import java.util.List;

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

	private final Class<?> loaderClass;
	private final String path;
	
	public XmiPageRulesSupplier(Class<?> loaderClass, String path) {
		super();
		this.loaderClass = loaderClass;
		this.path = path;
	}

	@Override
	public List<PageRule> get() {
		XmiObjectLoader<PageRuleCollection> pageRuleCollectionLoader = new XmiObjectLoader<PageRuleCollection>(
				PageMetaPackage.eINSTANCE, loaderClass, path);
		PageRuleCollection pageRuleCollection = pageRuleCollectionLoader.get();
		return ImmutableList.copyOf( pageRuleCollection.getRules() );
	}

}
