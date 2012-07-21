package org.soluvas.web.nav.ui;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.Link;
import org.soluvas.web.nav.ProcessMenuItem;

/**
 * @author ceefour
 *
 */
public interface ProcessLinkFactory {
	
	Link<? extends Page> create(String id, ProcessMenuItem processMi);

}
