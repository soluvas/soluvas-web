define(['underscore', 'org.soluvas.web.site/permalinkConfigs', 'uritemplate', 'org.soluvas.web.site/webAddress'],
		function(_, permalinkConfigs, UriTemplate, webAddress) {

var permalinkTemplates = {};
_.each(permalinkConfigs, function(permalink) {
	permalinkTemplates[permalink.namespace] = UriTemplate.parse(permalink.template);
});
console.debug('Loaded', _.size(permalinkTemplates), 'Permalink templates:', _.keys(permalinkTemplates));

var PermalinkManager = {
	/**
	 * Get permalink URI relative to current website.
	 */
	relative: function(namespace, slugPath) {
		return permalinkTemplates[namespace].expand({namespace: namespace, slug: slugPath,
			slugPath: slugPath, baseUri: '/'});
	},
	/**
	 * Get absolute permalink URI, considering plain HTTP vs secure HTTPS.
	 */
	absolute: function(namespace, slugPath) {
		return permalinkTemplates[namespace].expand({namespace: namespace, slug: slugPath,
			slugPath: slugPath, baseUri: webAddress.baseUri});
	},
	/**
	 * Get absolute permalink URI, plain HTTP only.
	 */
	unsecureAbsolute: function(namespace, slugPath) {
		return permalinkTemplates[namespace].expand({namespace: namespace, slug: slugPath,
			slugPath: slugPath, baseUri: webAddress.baseUri});
	},
	/**
	 * Get absolute permalink URI, secure HTTPS.
	 */
	secureAbsolute: function(namespace, slugPath) {
		return permalinkTemplates[namespace].expand({namespace: namespace, slug: slugPath,
			slugPath: slugPath, baseUri: webAddress.secureBaseUri});
	}
};

return PermalinkManager;
	
});
