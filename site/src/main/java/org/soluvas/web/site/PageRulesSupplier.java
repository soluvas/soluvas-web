package org.soluvas.web.site;

import java.util.List;

import org.soluvas.web.site.pagemeta.PageRule;

import com.google.common.base.Supplier;

/**
 * @author ceefour
 *
 */
public interface PageRulesSupplier extends Supplier<List<PageRule>> {

}
