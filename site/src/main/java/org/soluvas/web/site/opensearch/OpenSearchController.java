package org.soluvas.web.site.opensearch;

import org.joda.time.DateTime;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.GeneralSysConfig;
import org.soluvas.commons.WebAddress;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.nio.charset.StandardCharsets;

/**
 * OpenSearch 1.1 MVC controller.
 *
 * @see <a href="http://www.opensearch.org/Documentation/Developer_how_to_guide">OpenSearch How to</a>
 * @see <a href="https://developer.mozilla.org/en-US/Add-ons/Creating_OpenSearch_plugins_for_Firefox">Creating OpenSearch plugins for Firefox</a>
 * @see <a href="http://www.opensearch.org/Specifications/OpenSearch/1.1">OpenSearch 1.1 Specification</a>
 * @see org.soluvas.web.site.opensearch.OpenSearchLink
 * @see org.soluvas.web.site.opensearch.OpenSearchMvcConfig
 * @author ceefour
 */
@RestController
@Scope("request")
public class OpenSearchController {

	/**
	 * For XHTML auto-discovery:
	 *
	 * <pre>
	 * &lt;link rel="search"
	 *     type="application/opensearchdescription+xml"
	 *     href="http://example.com/content-search.xml"
	 *     title="Content search" />
	 * </pre>
	 */
	public static final MediaType APPLICATION_OPENSEARCHDESCRIPTION_XML = MediaType.parseMediaType("application/opensearchdescription+xml");
	/**
	 * Used to specify the URL to use for fetching search suggestions.
	 * @see <a href="https://developer.mozilla.org/en-US/Add-ons/Creating_OpenSearch_plugins_for_Firefox">Creating OpenSearch plugins for Firefox</a>
	 */
	public static final MediaType APPLICATION_X_SUGGESTIONS_JSON = MediaType.parseMediaType("application/x-suggestions+json");
	/**
	 * Used to specify the URL used when a keyword search is entered in the location bar. This is not supported on Internet Explorer.
	 * @see <a href="https://developer.mozilla.org/en-US/Add-ons/Creating_OpenSearch_plugins_for_Firefox">Creating OpenSearch plugins for Firefox</a>
	 */
	public static final MediaType APPLICATION_X_MOZ_KEYWORDSEARCH = MediaType.parseMediaType("application/x-moz-keywordsearch");

	@Inject
	private AppManifest appManifest;
	@Inject
	private WebAddress webAddress;
	@Inject
	private GeneralSysConfig sysConfig;
	
	@RequestMapping(method = RequestMethod.GET, value = "search.xml")
	public ResponseEntity<OpenSearchDescription> getOpenSearchDescription() {
		final String baseUri = sysConfig.getSslSupported() ? webAddress.getSecureBaseUri() : webAddress.getBaseUri();
		final OpenSearchDescription desc = new OpenSearchDescription();
		desc.setDescription(appManifest.getDescription());
		desc.setShortName(appManifest.getTitle());
		desc.setLongName(appManifest.getTitle() + ": " + appManifest.getSummary());
		desc.setContact(appManifest.getGeneralEmail());
		desc.setTags(appManifest.getTitle());
		desc.setDeveloper("Soluvas.com");
		desc.getInputEncodings().add(StandardCharsets.UTF_8.name());
		desc.getOutputEncodings().add(StandardCharsets.UTF_8.name());
		desc.getImages().add(new Image(baseUri + "favicon.ico", "image/vnd.microsoft.icon", 16, 16));
		// Spring Data REST style query parameters. we actually support sort= but it's not in OpenSearch spec
		desc.getUrls().add(new Url("text/html", baseUri + "search?q={searchTerms}&page={startPage?}&size={count?}",
				Url.Rel.results, 0, 0));
		// support auto-updating OpenSearch plugin (Firefox)
		desc.getUrls().add(new Url(APPLICATION_OPENSEARCHDESCRIPTION_XML.toString(), baseUri + "search.xml",
				Url.Rel.self));
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(APPLICATION_OPENSEARCHDESCRIPTION_XML);
		headers.setExpires(new DateTime().plusMonths(1).getMillis());
		return new ResponseEntity<>(desc, headers, HttpStatus.OK);
	}

}
