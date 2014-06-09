package org.soluvas.web.site.alexa;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import javax.annotation.Nullable;
import javax.servlet.ServletRequest;

import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.IRequestMapper;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.handler.resource.ResourceReferenceRequestHandler;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ByteArrayResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;
import org.soluvas.web.site.AlexaSysConfig;
import org.soluvas.web.site.SiteException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;

/**
 * @author ceefour
 *
 */
public class AlexaVerifyRequestMapper implements IRequestMapper {

	private static final DefaultMustacheFactory MF = new DefaultMustacheFactory("org/soluvas/web/site/alexa");
	private static final Mustache MUSTACHE = MF.compile("alexaverify.html.mustache");

	private ResourceReference resourceReference;
	
	/**
	 * @param path
	 * @param resourceReference
	 */
	@SuppressWarnings("serial")
	public AlexaVerifyRequestMapper() {
		super();
		this.resourceReference = new ResourceReference("alexaVerify.html") {
			@Override
			public IResource getResource() {
				return new ByteArrayResource("text/html") {
					@Override
					protected byte[] getData(Attributes attributes) {
						final WebApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(
								((ServletRequest) attributes.getRequest().getContainerRequest()).getServletContext());
						final AlexaSysConfig sysConfig = appCtx.getBean(AlexaSysConfig.class);
						Preconditions.checkState(!Strings.isNullOrEmpty(sysConfig.getAlexaVerifyId()),
								"This site has no Alexa Verify ID");
						try (final ByteArrayOutputStream ostream = new ByteArrayOutputStream()) {
							try (final OutputStreamWriter writer = new OutputStreamWriter(ostream)) {
								MUSTACHE.execute(writer, sysConfig);
							}
							return ostream.toByteArray();
						} catch (IOException e) {
							throw new SiteException(e, "Cannot generate Alexa Verify: %s", e);
						}
					}
				};
			}
		};
	}
	
	@Override @Nullable
	public IRequestHandler mapRequest(Request request) {
		final WebApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(
				((ServletRequest) request.getContainerRequest()).getServletContext());
		final AlexaSysConfig sysConfig = appCtx.getBean(AlexaSysConfig.class);
		if (!Strings.isNullOrEmpty(sysConfig.getAlexaVerifyId())) {
			final Url url = new Url(request.getUrl());
			final String alexaVerifyPath = sysConfig.getAlexaVerifyId() + ".html";
			if (alexaVerifyPath.equals(url.getPath())) {
				return new ResourceReferenceRequestHandler(resourceReference, 
						new PageParameters().set("alexaVerifyId", sysConfig.getAlexaVerifyId()));
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@Override
	public int getCompatibilityScore(Request request) {
		return -1;
	}

	@Override
	public Url mapHandler(IRequestHandler requestHandler) {
		if (requestHandler instanceof ResourceReferenceRequestHandler) {
			if (((ResourceReferenceRequestHandler) requestHandler).getResourceReference() == resourceReference) {
				final String alexaVerifyId = ((ResourceReferenceRequestHandler) requestHandler).getPageParameters().get("alexaVerifyId").toString();
				if (!Strings.isNullOrEmpty(alexaVerifyId)) {
					final String alexaVerifyPath = alexaVerifyId + ".html";
					return Url.parse(alexaVerifyPath);
				}
			}
		}
		return null;
	}

}
