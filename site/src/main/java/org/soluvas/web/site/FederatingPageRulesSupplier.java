package org.soluvas.web.site;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.annotation.Nullable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Function;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author ceefour
 */
public class FederatingPageRulesSupplier implements PageRulesSupplier {

	private transient Logger log = LoggerFactory
			.getLogger(FederatingPageRulesSupplier.class);
	List<PageRulesSupplier> suppliers = new CopyOnWriteArrayList<PageRulesSupplier>();
	
	public FederatingPageRulesSupplier() {
		super();
	}
	
	@SuppressWarnings("unchecked")
	public FederatingPageRulesSupplier(Collection<PageRulesSupplier> initialSuppliers) {
		super();
		log.info("Initializing federating page rules supplier with {} suppliers", suppliers.size());
		this.suppliers.addAll( initialSuppliers );
	}

	@Override
	public List<PageRule> get() {
		log.debug("Federating page rules from {} suppliers", suppliers.size());
		List<List<PageRule>> pageRulesNested = Lists.transform(suppliers, new Function<Supplier<List<PageRule>>, List<PageRule>>() {
			@Override @Nullable
			public List<PageRule> apply(@Nullable Supplier<List<PageRule>> input) {
				return input.get();
			}
		});
		List<PageRule> concatedRules = ImmutableList.copyOf(Iterables.concat(pageRulesNested));
		log.debug("{} page rule suppliers returned {} rules", suppliers.size(), concatedRules.size());
		return concatedRules;
	}
	
	public void add(PageRulesSupplier supplier) {
		log.info("Adding page rule supplier {}", supplier);
		suppliers.add(supplier);
	}
	
	public void remove(PageRulesSupplier supplier) {
		log.info("Removing page rule supplier {}", supplier);
		suppliers.remove(supplier);
	}

}
