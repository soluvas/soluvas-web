package org.soluvas.web.bootstrap;

import org.soluvas.web.site.CssLink;
import org.soluvas.web.site.CssLinkImpl;
import org.soluvas.web.site.JavaScriptAlias;
import org.soluvas.web.site.JavaScriptAliasImpl;
import org.soluvas.web.site.JavaScriptModule;
import org.soluvas.web.site.JavaScriptModuleImpl;
import org.soluvas.web.site.JavaScriptShim;
import org.soluvas.web.site.JavaScriptShimImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.collect.ImmutableSet;

/**
 * @author agus
 *
 */
@Configuration
public class BootstrapConfig {
	
	@Bean
	public JavaScriptAlias uiCoreAlias() {
		return new JavaScriptAliasImpl("jquery-ui/jquery.ui.core", "jquery-ui.custom");
	}

	@Bean
	public JavaScriptAlias uiAutocompleteAlias() {
		return new JavaScriptAliasImpl("jquery-ui/jquery.ui.autocomplete", "jquery-ui.custom");
	}

	@Bean
	public JavaScriptAlias uiWidgetAlias() {
		return new JavaScriptAliasImpl("jquery-ui/jquery.ui.widget", "jquery-ui.custom");
	}
	
	@Bean
	public JavaScriptModule uiModule() {
		return new JavaScriptModuleImpl("jquery-ui",
				"org.soluvas.web.bootstrap/development-bundle/ui",
				"org.soluvas.web.bootstrap/development-bundle/ui/minified");
	}

	@Bean
	public JavaScriptShim coreShim() {
		return new JavaScriptShimImpl("jquery-ui/jquery.ui.core",
				ImmutableSet.of("jquery"));
	}

	@Bean
	public JavaScriptShim widgetShim() {
		return new JavaScriptShimImpl("jquery-ui/jquery.ui.widget",
				ImmutableSet.of("jquery-ui/jquery.ui.core"));
	}

	@Bean
	public JavaScriptShim autocompleteShim() {
		return new JavaScriptShimImpl("jquery-ui/jquery.ui.autocomplete",
				ImmutableSet.of("jquery-ui/jquery.ui.widget"));
	}

	/**
	 * jquery-ui.custom is always served via Google CDN
	 * @return
	 */
	@Bean
	public JavaScriptModule uiCustomModule() {
		return new JavaScriptModuleImpl("jquery-ui.custom",
				"//ajax.googleapis.com/ajax/libs/jqueryui/1.10.0/jquery-ui.min",
				"//ajax.googleapis.com/ajax/libs/jqueryui/1.10.0/jquery-ui.min");
	}

	@Bean
	public JavaScriptShim customShim() {
		return new JavaScriptShimImpl("jquery-ui.custom",
				ImmutableSet.of("jquery"));
	}
	
	@Bean
	public CssLink uiCss() {
		return new CssLinkImpl("org.soluvas.web.bootstrap/css/ui-lightness/jquery-ui-1.10.0.custom.css",
				"//ajax.googleapis.com/ajax/libs/jqueryui/1.10.0/themes/ui-lightness/jquery-ui.css", -1);
	}

	@Bean
	public JavaScriptModule selectmenuModule() {
		return new JavaScriptModuleImpl("jquery-selectmenu",
				"org.soluvas.web.bootstrap/jquery.ui.selectmenu",
				"org.soluvas.web.bootstrap/jquery.ui.selectmenu");
	}
	
//	@Bean
//	public JavaScriptModule tinynavModule() {
//		return new JavaScriptModuleImpl("tinynav",
//				"org.soluvas.web.bootstrap/tinynav",
//				"org.soluvas.web.bootstrap/tinynav.min");
//	}

	@Bean
	public JavaScriptShim selectmenuShim() {
		return new JavaScriptShimImpl("jquery-selectmenu",
				ImmutableSet.of("jquery-ui/jquery.ui.widget"));
	}
	
	@Bean
	public CssLink selectmenuCss() {
		return new CssLinkImpl("org.soluvas.web.bootstrap/css/jquery.ui.selectmenu.css");
	}

	@Bean
	public JavaScriptModule datatablesModule() {
		return new JavaScriptModuleImpl("jquery.dataTables",
				"org.soluvas.web.bootstrap/datatables/jquery.dataTables",
				"//ajax.aspnetcdn.com/ajax/jquery.dataTables/1.9.4/jquery.dataTables.min");
	}
	
	@Bean
	public JavaScriptShim datatablesShim() {
		return new JavaScriptShimImpl("jquery.dataTables",
				ImmutableSet.of("jquery-ui/jquery.ui.widget"));
	}
	
	@Bean
	public CssLink datatablesCss() {
		return new CssLinkImpl("org.soluvas.web.bootstrap/datatables/css/jquery.dataTables_bootstrap2.css",
				"org.soluvas.web.bootstrap/datatables/css/jquery.dataTables_bootstrap2.css", -1);
	}

	@Bean
	public JavaScriptModule masonryModule() {
		return new JavaScriptModuleImpl("jquery.masonry",
				"org.soluvas.web.bootstrap/jquery.masonry-2.1.08",
				"//cdnjs.cloudflare.com/ajax/libs/masonry/2.1.08/jquery.masonry.min");
	}

	@Bean
	public JavaScriptShim masonryShim() {
		return new JavaScriptShimImpl("jquery.masonry",
				ImmutableSet.of("jquery"));
	}
	
	@Bean
	public JavaScriptModule notifyModule() {
		return new JavaScriptModuleImpl("jquery.notify", "org.soluvas.web.bootstrap/jquery.notify");
	}
	
	@Bean
	public JavaScriptShim notifyShim() {
		return new JavaScriptShimImpl("jquery.notify", ImmutableSet.of("jquery-ui/jquery.ui.widget"));
	}
	
	@Bean
	public CssLink notifyCss() {
		return new CssLinkImpl("org.soluvas.web.bootstrap/ui.notify.css");
	}
	
	@Bean
	public CssLink notifyCustomCss() {
		return new CssLinkImpl("org.soluvas.web.bootstrap/ui.notify.custom.css");
	}
	
	@Bean
	public JavaScriptModule easingModule() {
		return new JavaScriptModuleImpl("easing", "org.soluvas.web.bootstrap/easing.js");
	}
	
	@Bean
	public JavaScriptModule uiTotopModule() {
		return new JavaScriptModuleImpl("jquery.ui.totop", "org.soluvas.web.bootstrap/jquery.ui.totop.js");
	}
	
	@Bean
	public JavaScriptAlias easingAlias() {
		return new JavaScriptAliasImpl("easing", "org.soluvas.web.bootstrap/easing.js");
	}
	
	@Bean
	public JavaScriptAlias uiBackTopAlias() {
		return new JavaScriptAliasImpl("jquery.ui.totop", "org.soluvas.web.bootstrap/jquery.ui.totop.js");
	}
	
}
