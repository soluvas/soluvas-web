package org.soluvas.web.site.google;

import com.github.mustachejava.DefaultMustacheFactory;
import com.github.mustachejava.Mustache;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.apache.wicket.request.IRequestHandler;
import org.apache.wicket.request.IRequestMapper;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.handler.resource.ResourceReferenceRequestHandler;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.ByteArrayResource;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;
import org.soluvas.web.site.GoogleSysConfig;
import org.soluvas.web.site.GoogleSysConfig2;
import org.soluvas.web.site.SiteException;
import org.springframework.beans.BeansException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.annotation.Nullable;
import javax.servlet.ServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * @author ceefour
 *
 */
public class GoogleVerifyRequestMapper implements IRequestMapper {

	private static final DefaultMustacheFactory MF = new DefaultMustacheFactory("org/soluvas/web/site/google");
	private static final Mustache MUSTACHE = MF.compile("googleverify.html.mustache");

	private ResourceReference resourceReference;
	
	@SuppressWarnings("serial")
	public GoogleVerifyRequestMapper() {
		super();
		this.resourceReference = new ResourceReference("googleverify.html") {
			@Override
			public IResource getResource() {
				return new ByteArrayResource("text/html") {
					@Override
					protected byte[] getData(Attributes attributes) {
						final WebApplicationContext appCtx = WebApplicationContextUtils.getRequiredWebApplicationContext(
								((ServletRequest) attributes.getRequest().getContainerRequest()).getServletContext());
						final GoogleSysConfig sysConfig = appCtx.getBean(GoogleSysConfig.class);
						Preconditions.checkState(!Strings.isNullOrEmpty(sysConfig.getGoogleVerifyId()),
								"This site has no Google Webmasters Verify ID");
						try (final ByteArrayOutputStream ostream = new ByteArrayOutputStream()) {
							try (final OutputStreamWriter writer = new OutputStreamWriter(ostream)) {
								MUSTACHE.execute(writer, sysConfig);
							}
							return ostream.toByteArray();
						} catch (IOException e) {
							throw new SiteException(e, "Cannot generate Google Webmasters Verify: %s", e);
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

		try {
			final GoogleSysConfig2 sysConfig = appCtx.getBean(GoogleSysConfig2.class);
			if (!Strings.isNullOrEmpty(sysConfig.getGoogleVerifyId())) {
				final Url url = new Url(request.getUrl());
				final String googleVerifyPath = sysConfig.getGoogleVerifyId() + ".html";
				if (googleVerifyPath.equals(url.getPath())) {
					return new ResourceReferenceRequestHandler(resourceReference,
							new PageParameters().set("googleVerifyId", sysConfig.getGoogleVerifyId()));
				} else {
					return null;
				}
			} else {
				return null;
			}
		} catch (BeansException e) {
			final GoogleSysConfig sysConfig = appCtx.getBean(GoogleSysConfig.class);
			if (!Strings.isNullOrEmpty(sysConfig.getGoogleVerifyId())) {
				final Url url = new Url(request.getUrl());
				final String googleVerifyPath = sysConfig.getGoogleVerifyId() + ".html";
				if (googleVerifyPath.equals(url.getPath())) {
					return new ResourceReferenceRequestHandler(resourceReference,
							new PageParameters().set("googleVerifyId", sysConfig.getGoogleVerifyId()));
				} else {
					return null;
				}
			} else {
				return null;
			}
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
				final String googleVerifyId = ((ResourceReferenceRequestHandler) requestHandler)
						.getPageParameters().get("googleVerifyId").toString();
				if (!Strings.isNullOrEmpty(googleVerifyId)) {
					final String googleVerifyPath = googleVerifyId + ".html";
					return Url.parse(googleVerifyPath);
				}
			}
		}
		return null;
	}

}
