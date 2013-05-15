package org.soluvas.web.site;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.PreDestroy;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.DelegatingSupplier;
import org.soluvas.web.site.pagemeta.PageRule;
import org.soluvas.web.site.pagemeta.PageRuleCollection;
import org.soluvas.web.site.pagemeta.PagemetaFactory;
import org.soluvas.web.site.pagemeta.PagemetaPackage;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

/**
 * @author ceefour
 * @deprecated Use {@link FederatingPageMetaCatalogSupplier}.
 */
@Deprecated
public class FederatingPageRuleCollectionSupplier implements Supplier<PageRuleCollection>,
	DelegatingSupplier<PageRuleCollection> {

	public static class PageRuleOrdering extends Ordering<PageRule> {
		
		@Override
		public int compare(@Nullable PageRule left, @Nullable PageRule right) {
			return Optional.fromNullable(left.getPositioner()).or(0) - Optional.fromNullable(right.getPositioner()).or(0);
		}
		
	}
	
	private static Logger log = LoggerFactory
			.getLogger(FederatingPageRuleCollectionSupplier.class);
	private final List<Supplier<PageRuleCollection>> suppliers = new CopyOnWriteArrayList<Supplier<PageRuleCollection>>();
	private final PageRuleCollection federatedPageRules;
	
	public FederatingPageRuleCollectionSupplier(final PagemetaPackage pageMetaPackage, Collection<Supplier<PageRuleCollection>> initialSuppliers) {
		super();
		log.info("Initializing federating page rules supplier with {} suppliers", suppliers.size());
		this.suppliers.addAll( initialSuppliers );
		federatedPageRules = PagemetaFactory.eINSTANCE.createPageMetaCatalog();
	}

	@Override
	public synchronized PageRuleCollection get() {
		Preconditions.checkNotNull(federatedPageRules, "federatedPageRules is null, probably already destroyed");
		log.debug("Federating page rules from {} suppliers", suppliers.size());
		final List<List<PageRule>> pageRulesNested = Lists.transform(suppliers, new Function<Supplier<PageRuleCollection>, List<PageRule>>() {
			@Override @Nullable
			public List<PageRule> apply(@Nullable Supplier<PageRuleCollection> input) {
				return input.get().getRules();
			}
		});
		final List<PageRule> concatedRules = ImmutableList.copyOf(Iterables.concat(pageRulesNested));
		log.debug("{} page rule suppliers returned {} rules", suppliers.size(), concatedRules.size());
		final List<PageRule> sortedRules = new PageRuleOrdering().immutableSortedCopy(concatedRules);
		federatedPageRules.getRules().clear();
		// must copy, otherwise it can be gone from the original supplier
		federatedPageRules.getRules().addAll(EcoreUtil.copyAll(sortedRules));
		return federatedPageRules;
	}
	
	@Override
	public void addSupplier(Supplier<PageRuleCollection> supplier) {
		log.info("Adding page rule supplier {}", supplier);
		suppliers.add(supplier);
	}

	@Override
	public void removeSupplier(Supplier<PageRuleCollection> supplier) {
		log.info("Removing page rule supplier {}", supplier);
		suppliers.remove(supplier);
	}

	@Override
	@PreDestroy
	public void destroy() {
		log.info("Destroying FederatingPageRuleCollectionSupplier with {} suppliers", suppliers.size());
		for (final Supplier<PageRuleCollection> supplier : ImmutableList.copyOf(suppliers)) {
			removeSupplier(supplier);
		}
		federatedPageRules.getRules().clear();
	}

}
