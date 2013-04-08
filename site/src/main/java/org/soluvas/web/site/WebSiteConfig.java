package org.soluvas.web.site;

import org.soluvas.web.site.JavaScriptModule.Base;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import com.google.common.collect.ImmutableSet;

/**
 * @author agus
 *
 */
@Configuration @Lazy
@ComponentScan({"org.soluvas.web.site", "org.soluvas.web.olark",
		"org.soluvas.web.googleanalytics",
		"org.soluvas.web.bootstrap"})
public class WebSiteConfig {

	@Bean
	public JavaScriptModule webAddressModule() {
		return new JavaScriptModuleImpl("org.soluvas.web.site/webAddress",
				"org.soluvas.web.site/webAddress",
				"org.soluvas.web.site/webAddress",
				Base.DYNAMIC);
	}

	@Bean
	public JavaScriptModule permalinkConfigsModule() {
		return new JavaScriptModuleImpl("org.soluvas.web.site/permalinkConfigs",
				"org.soluvas.web.site/permalinkConfigs",
				"org.soluvas.web.site/permalinkConfigs",
				Base.DYNAMIC);
	}

	@Bean
	public JavaScriptModule underscoreModule() {
		return new JavaScriptModuleImpl("underscore",
				"org.soluvas.web.site/underscore-1.4.4",
				"//cdnjs.cloudflare.com/ajax/libs/underscore.js/1.4.4/underscore-min");
	}

	@Bean
	public JavaScriptShim underscoreShim() {
		return new JavaScriptShimImpl("underscore", 
				ImmutableSet.<String>of(), "_");
	}

	@Bean
	public JavaScriptModule backboneModule() {
		return new JavaScriptModuleImpl("backbone",
				"org.soluvas.web.site/backbone-1.0.0",
				"//cdnjs.cloudflare.com/ajax/libs/backbone.js/1.0.0/backbone-min");
	}
	
	@Bean
	public JavaScriptShim backboneShim() {
		return new JavaScriptShimImpl("backbone", 
				ImmutableSet.of("underscore", "jquery"), "Backbone");
	}

	@Bean
	public JavaScriptModule handlebarsModule() {
		return new JavaScriptModuleImpl("handlebars",
				"org.soluvas.web.site/handlebars-1.0.rc.3",
				"//cdnjs.cloudflare.com/ajax/libs/handlebars.js/1.0.0-rc.3/handlebars.min");
	}
	
	@Bean
	public JavaScriptShim handlebarsShim() {
		return new JavaScriptShimImpl("handlebars", 
				ImmutableSet.<String>of(), "Handlebars");
	}

	@Bean
	public JavaScriptAlias handlebarsAlias() {
		return new JavaScriptAliasImpl("handlebars.runtime", 
				"handlebars", "handlebars");
	}

	@Bean
	public JavaScriptModule sugarModule() {
		return new JavaScriptModuleImpl("sugar",
				"org.soluvas.web.site/sugar-1.3.9-custom.development",
				"//cdnjs.cloudflare.com/ajax/libs/sugar/1.3.8/sugar.min");
	}
	
	@Bean
	public JavaScriptShim sugarShim() {
		return new JavaScriptShimImpl("sugar", 
				ImmutableSet.<String>of(), "Date");
	}

	@Bean
	public JavaScriptModule sugarIdModule() {
		return new JavaScriptModuleImpl("sugar_id",
				"org.soluvas.web.site/sugar_id");
	}
	
	@Bean
	public JavaScriptShim sugarIdShim() {
		return new JavaScriptShimImpl("sugar_id", 
				ImmutableSet.of("sugar"), "Date");
	}

	@Bean
	public JavaScriptModule livevalidationModule() {
		return new JavaScriptModuleImpl("livevalidation",
				"org.soluvas.web.site/livevalidation_amd-1.3");
	}
	
	@Bean
	public JavaScriptModule preflocaleModule() {
		return new JavaScriptModuleImpl("pref.locale",
				"org.soluvas.web.site/pref.locale");
	}
	
	@Bean
	public JavaScriptModule uritemplateModule() {
		return new JavaScriptModuleImpl("uritemplate",
				"org.soluvas.web.site/uritemplate");
	}
	
	@Bean
	public JavaScriptShim uritemplateShim() {
		return new JavaScriptShimImpl("uritemplate", 
				ImmutableSet.<String>of(), "UriTemplate");
	}

	@Bean
	public JavaScriptModule paginatorModule() {
		return new JavaScriptModuleImpl("backbone.paginator",
				"org.soluvas.web.site/backbone.paginator");
	}
	
	@Bean
	public JavaScriptShim paginatorShim() {
		return new JavaScriptShimImpl("backbone.paginator", 
				ImmutableSet.of("jquery", "backbone"), "Backbone.Paginator");
	}

	@Bean
	public JavaScriptModule diacriticModule() {
		return new JavaScriptModuleImpl("diacritic",
				"org.soluvas.web.site/diacritic");
	}
	
	@Bean
	public JavaScriptShim diacriticShim() {
		return new JavaScriptShimImpl("diacritic", 
				ImmutableSet.of("backbone"), "Diacritic");
	}
	
//	@Bean
//	public PageMetaCatalog webSiteCatalog() {
//		return new XmiObjectLoader<PageMetaCatalog>(PagemetaPackage.eINSTANCE,
//				SiteConfig.class, "default.PageMetaCatalog.xmi").get();
//	}

}
