package org.soluvas.web.site.sitemap;

import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.google.common.collect.ImmutableSet;
import org.apache.maven.surefire.shade.org.apache.commons.io.IOUtils;
import org.joda.time.DateTime;
import org.soluvas.commons.AppManifest;
import org.soluvas.commons.GeneralSysConfig;
import org.soluvas.commons.WebAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Requires {@code WebMvcConfigurerAdapter} to be set up as follows:
 * 
 * <pre>
 * &commat;Override
 * public void configureMessageConverters(
 * 		List&lt;HttpMessageConverter&lt;?>> converters) {
 * 	converters.add(new Jaxb2RootElementHttpMessageConverter());
 * }
 * </pre>
 * 
 * @author ceefour
 */
@RestController
@Scope("request")
public class SitemapController {

	public static final ImmutableSet<SitemapPart> activeSitemaps = ImmutableSet.of(
			SitemapPart.PAGE, SitemapPart.CATEGORY, SitemapPart.SHOP, SitemapPart.PRODUCT, SitemapPart.PRODUCT_RELEASE);

	@Inject
	private WebAddress webAddress;
	@Inject
	private AppManifest appManifest;
	@Inject
	private GeneralSysConfig sysConfig;
	@Autowired(required=false)
	private List<SitemapSupplier> sitemapSuppliers;

	/**
	 * <?xml-stylesheet type="text/xsl" href="//yoast.com/main-sitemap.xsl"?>
	 * @return
	 * @throws JAXBException 
	 * @throws IOException 
	 */
	@RequestMapping(method = RequestMethod.GET, value = "sitemap_index.xml")
	public ResponseEntity<String> getSitemapIndex() throws JAXBException, IOException {
		final String baseUri = sysConfig.getSslSupported() ? webAddress.getSecureBaseUri() : webAddress.getBaseUri();
		final SitemapIndex index = new SitemapIndex();
		if (activeSitemaps.contains(SitemapPart.PAGE)) {
			index.getSitemaps().add(new Sitemap(baseUri + "page-sitemap.xml", new DateTime(appManifest.getDefaultTimeZone())));
		}
		if (activeSitemaps.contains(SitemapPart.PERSON)) {
			index.getSitemaps().add(new Sitemap(baseUri + "person-sitemap.xml", new DateTime(appManifest.getDefaultTimeZone())));
		}
		if (activeSitemaps.contains(SitemapPart.CATEGORY)) {
			index.getSitemaps().add(new Sitemap(baseUri + "category-sitemap.xml", new DateTime(appManifest.getDefaultTimeZone())));
		}
		if (activeSitemaps.contains(SitemapPart.SHOP)) {
			index.getSitemaps().add(new Sitemap(baseUri + "shop-sitemap.xml", new DateTime(appManifest.getDefaultTimeZone())));
		}
		if (activeSitemaps.contains(SitemapPart.PRODUCT)) {
			index.getSitemaps().add(new Sitemap(baseUri + "product-sitemap.xml", new DateTime(appManifest.getDefaultTimeZone())));
		}
		if (activeSitemaps.contains(SitemapPart.PRODUCT_RELEASE)) {
			index.getSitemaps().add(new Sitemap(baseUri + "product-release-sitemap.xml", new DateTime(appManifest.getDefaultTimeZone())));
		}
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.setExpires(new DateTime().plusDays(1).getMillis());
		
		JAXBContext jaxb = JAXBContext.newInstance(SitemapIndex.class, UrlSet.class);
		Marshaller marshaller = jaxb.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty("com.sun.xml.bind.xmlHeaders", 
			    "<?xml-stylesheet type=\"text/xsl\" href=\"/main-sitemap.xsl\"?>");
		final StringWriter sw = new StringWriter();
		marshaller.marshal(index, sw);
		return new ResponseEntity<>(sw.toString(), headers, HttpStatus.OK);
//		try (final ByteArrayOutputStream os = new ByteArrayOutputStream()) {
//			marshaller.marshal(index, os);
//			return new ResponseEntity<>(os.toByteArray(), headers, HttpStatus.OK);
//		}
	}

	@RequestMapping(method = RequestMethod.GET, value = "page-sitemap.xml")
	public ResponseEntity<String> getPageSitemap() throws JAXBException {
		return getSitemapIfActive(SitemapPart.PAGE);
	}

	@RequestMapping(method = RequestMethod.GET, value = "category-sitemap.xml")
	public ResponseEntity<String> getCategorySitemap() throws JAXBException {
		return getSitemapIfActive(SitemapPart.CATEGORY);
	}

	@RequestMapping(method = RequestMethod.GET, value = "person-sitemap.xml")
	public ResponseEntity<String> getPersonSitemap() throws JAXBException {
		return getSitemapIfActive(SitemapPart.PERSON);
	}

	@RequestMapping(method = RequestMethod.GET, value = "shop-sitemap.xml")
	public ResponseEntity<String> getShopSitemap() throws JAXBException {
		return getSitemapIfActive(SitemapPart.SHOP);
	}

	@RequestMapping(method = RequestMethod.GET, value = "product-sitemap.xml")
	public ResponseEntity<String> getProductSitemap() throws JAXBException {
		return getSitemapIfActive(SitemapPart.PRODUCT);
	}

	@RequestMapping(method = RequestMethod.GET, value = "product-release-sitemap.xml")
	public ResponseEntity<String> getProductReleaseSitemap() throws JAXBException {
		return getSitemapIfActive(SitemapPart.PRODUCT_RELEASE);
	}

	protected ResponseEntity<String> getSitemapIfActive(SitemapPart part) throws JAXBException {
		if (!activeSitemaps.contains(part)) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_XML)
					.body("Sitemap " + part + " is not active.");
		}

		final String baseUri = sysConfig.getSslSupported() ? webAddress.getSecureBaseUri() : webAddress.getBaseUri();
		final UrlSet urlSet = new UrlSet();
		if (part == SitemapPart.PAGE) {
			final Url homePage = new Url(baseUri, new DateTime(appManifest.getDefaultTimeZone()), ChangeFreq.daily, 1);
			urlSet.getUrls().add(homePage);
		}

		if (sitemapSuppliers != null) {
			for (SitemapSupplier supplier : sitemapSuppliers) {
				urlSet.getUrls().addAll(supplier.getUrls(part));
			}
		}

		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.setExpires(new DateTime().plusHours(1).getMillis());

		JAXBContext jaxb = JAXBContext.newInstance(SitemapIndex.class, UrlSet.class);
		Marshaller marshaller = jaxb.createMarshaller();
		marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
		marshaller.setProperty("com.sun.xml.bind.xmlHeaders",
			    "<?xml-stylesheet type=\"text/xsl\" href=\"/main-sitemap.xsl\"?>");
		final StringWriter sw = new StringWriter();
		marshaller.marshal(urlSet, sw);
		return new ResponseEntity<>(sw.toString(), headers, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.GET, value = "main-sitemap.xsl")
	public ResponseEntity<String> mainSitemapXsl() throws IOException {
		final String baseUri = sysConfig.getSslSupported() ? webAddress.getSecureBaseUri() : webAddress.getBaseUri();
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.parseMediaType("text/xsl"));
		headers.setExpires(new DateTime().plusWeeks(1).getMillis());
		return new ResponseEntity<>(IOUtils.toString(SitemapController.class.getResource("main-sitemap.xsl")), 
				headers, HttpStatus.OK);
	}

}
