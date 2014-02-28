package org.soluvas.web.bootstrap.backend;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.filter.HeaderResponseContainer;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.CssResourceReference;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.WebAddress;

import com.google.common.collect.ImmutableList;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.HtmlTag;

/**
 * Only default styling.
 * @author rio
 */
public class BackendPage extends WebPage {
	
	@SpringBean
	protected WebAddress webAddress;

	private static final JavaScriptResourceReference jqueryUiJs = new JavaScriptResourceReference(BackendPage.class, "assets/jquery-ui/jquery-ui-1.10.1.custom.min.js") {
		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
		};
	};

	private static final JavaScriptResourceReference accordionMenuJs = new JavaScriptResourceReference(BackendPage.class, "js/accordion-menu/jquery.dcjqaccordion.2.7.js") {
		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
		};
	};
	
	private static final JavaScriptResourceReference scrollToJs = new JavaScriptResourceReference(BackendPage.class, "js/scrollTo/jquery.scrollTo.min.js") {
		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
		};
	};
	
	private static final JavaScriptResourceReference niceScrollJs = new JavaScriptResourceReference(BackendPage.class, "js/nicescroll/jquery.nicescroll.js") {
		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
		};
	};
	
	private static final JavaScriptResourceReference slimScroll = new JavaScriptResourceReference(BackendPage.class, "assets/jQuery-slimScroll-1.3.0/jquery.slimscroll.js") {
		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
		};
	};
	
	private static final JavaScriptResourceReference skyconsJs = new JavaScriptResourceReference(BackendPage.class, "assets/skycons/skycons.js") {
		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
		};
	};
	
	private static final JavaScriptResourceReference jqueryEasingJs = new JavaScriptResourceReference(BackendPage.class, "js/jquery.easing.min.js") {
		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
		};
	};
	
	private static final JavaScriptResourceReference underscoreJs = new JavaScriptResourceReference(BackendPage.class, "js/underscore-min.js") {
		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
		};
	};
	
	private static final JavaScriptResourceReference gaugeJs = new JavaScriptResourceReference(BackendPage.class, "assets/gauge/gauge.js") {
		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
		};
	};

	private static final JavaScriptResourceReference customSelectJs = new JavaScriptResourceReference(BackendPage.class, "js/custom-select/jquery.customSelect.min.js") {
		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
		};
	};
	
	private static final JavaScriptResourceReference scriptsJs = new JavaScriptResourceReference(BackendPage.class, "js/scripts.js") {
		@Override
		public java.lang.Iterable<? extends org.apache.wicket.markup.head.HeaderItem> getDependencies() {
			return ImmutableList.of( JavaScriptHeaderItem.forReference(Application.get().getJavaScriptLibrarySettings().getJQueryReference()) );
		};
	};
	
	
	private static final long serialVersionUID = 1L;
	
	protected final RepeatingView sidebarBlocks;
	protected TransparentWebMarkupContainer sidebarColumn;

	public BackendPage(PageParameters params) {
		super(params);
		add(new HtmlTag("html", getLocale(), true));
		add(new BootstrapBaseBehavior());
		add(new HeaderResponseContainer("footer-container", "footer-container"));
		
		// SIDEBAR
		sidebarColumn = new TransparentWebMarkupContainer("sidebarColumn");
		add(sidebarColumn);
		sidebarBlocks = new RepeatingView("sidebarBlocks");
		sidebarColumn.add(sidebarBlocks);
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(new CssResourceReference(BackendPage.class, "assets/jquery-ui/jquery-ui-1.10.1.custom.min.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(BackendPage.class, "css/bootstrap-reset.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(BackendPage.class, "assets/font-awesome/css/font-awesome.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(BackendPage.class, "assets/jvector-map/jquery-jvectormap-1.2.2.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(BackendPage.class, "css/clndr.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(BackendPage.class, "assets/css3clock/css/style.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(BackendPage.class, "assets/morris-chart/morris.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(BackendPage.class, "css/style.css")));
		response.render(CssHeaderItem.forReference(new CssResourceReference(BackendPage.class, "css/style-responsive.css")));
		
		response.render(JavaScriptHeaderItem.forReference(jqueryUiJs));
		response.render(JavaScriptHeaderItem.forReference(accordionMenuJs));
		response.render(JavaScriptHeaderItem.forReference(scrollToJs));
		response.render(JavaScriptHeaderItem.forReference(niceScrollJs));
		response.render(JavaScriptHeaderItem.forReference(slimScroll));
		response.render(JavaScriptHeaderItem.forReference(skyconsJs));
		response.render(JavaScriptHeaderItem.forReference(jqueryEasingJs));
		response.render(JavaScriptHeaderItem.forReference(underscoreJs));
		response.render(JavaScriptHeaderItem.forReference(gaugeJs));
		response.render(JavaScriptHeaderItem.forReference(customSelectJs));
		response.render(JavaScriptHeaderItem.forReference(scriptsJs));
	}
	
}
