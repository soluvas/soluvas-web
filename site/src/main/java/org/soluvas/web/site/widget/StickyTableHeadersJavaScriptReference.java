package org.soluvas.web.site.widget;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.request.resource.JavaScriptResourceReference;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * <a href="https://github.com/jmosbech/StickyTableHeaders">StickyTableHeaders jQuery plugin</a>
 * that makes large tables more usable by having the table header stick to the top of the screen when scrolling.
 * 
 * <p>Usage: Initializing the plugin is pretty straight forward:
 * 
 * <pre>{@literal
 * $('table').stickyTableHeaders();
 * }</pre>
 * 
 * @see <a href="http://stackoverflow.com/a/7718235/122441">StackOverflow thread</a>
 * @author ceefour
 */
public class StickyTableHeadersJavaScriptReference extends
		JavaScriptResourceReference {
	
	public static final StickyTableHeadersJavaScriptReference INSTANCE = new StickyTableHeadersJavaScriptReference();

	StickyTableHeadersJavaScriptReference() {
		super(StickyTableHeadersJavaScriptReference.class, "jquery.stickytableheaders.js");
	}
	
	@Override
	public List<HeaderItem> getDependencies() {
		// don't use this, will cause double jQuery.js: return ImmutableList.of(JavaScriptHeaderItem.forReference( JQueryResourceReference.get() ));
		return ImmutableList.of(JavaScriptHeaderItem.forReference( Application.get().getJavaScriptLibrarySettings().getJQueryReference() ));
	}

}
