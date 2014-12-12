package org.soluvas.web.site.sitemap;

import java.io.IOException;
import java.io.StringWriter;

import javax.inject.Inject;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.apache.maven.surefire.shade.org.apache.commons.io.IOUtils;
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
	
	@Inject
	private WebAddress webAddress;
	@Inject
	private AppManifest appManifest;
	@Inject
	private GeneralSysConfig sysConfig;
	
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
		index.getSitemaps().add(new Sitemap(baseUri + "page-sitemap.xml", new DateTime(appManifest.getDefaultTimeZone())));
		final HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_XML);
		headers.setExpires(new DateTime().plusHours(1).getMillis());
		
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
	public ResponseEntity<String> getPageIndex() throws JAXBException {
		final String baseUri = sysConfig.getSslSupported() ? webAddress.getSecureBaseUri() : webAddress.getBaseUri();
		final UrlSet urlSet = new UrlSet();
		final Url homePage = new Url(baseUri, new DateTime(appManifest.getDefaultTimeZone()), ChangeFreq.daily, 1);
		urlSet.getUrls().add(homePage);
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
		headers.setExpires(new DateTime().plusDays(1).getMillis());
		return new ResponseEntity<>(IOUtils.toString(SitemapController.class.getResource("main-sitemap.xsl")), 
				headers, HttpStatus.OK);
	}

}
