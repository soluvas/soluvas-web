package org.soluvas.web.site;

import org.apache.wicket.core.request.mapper.MountedMapper;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.component.IRequestablePage;
import org.apache.wicket.request.mapper.parameter.IPageParametersEncoder;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.IProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Captures all segments, useful for e.g. categorySlug ({@literal fabrics/batik/lawasan@}).
 * @author atang
 * @deprecated You can use a mount path such as "${localePrefId}/error" then set trailing path segments
 * using {@link PageParameters#set(int, Object)}, and retrieve it via {@link PageParameters#get(int)}.
 * See {@code com.satukancinta.web.WicketErrorPage} for example.
 * Sample result URL is {@code /id/error/WicketRuntimeException/InvocationTargetException/RuntimeException?1&b=/%3Fref%3Derror}
 */
@Deprecated
public class MultiMountedMapper extends MountedMapper {
	private static final Logger log = LoggerFactory
			.getLogger(MultiMountedMapper.class);

	/**
	 * @param mountPath
	 * @param pageClass
	 */
	public MultiMountedMapper(String mountPath,
			Class<? extends IRequestablePage> pageClass) {
		super(mountPath, pageClass);
	}

	/**
	 * @param mountPath
	 * @param pageClassProvider
	 */
	public MultiMountedMapper(String mountPath,
			IProvider<Class<? extends IRequestablePage>> pageClassProvider) {
		super(mountPath, pageClassProvider);
	}

	/**
	 * @param mountPath
	 * @param pageClass
	 * @param pageParametersEncoder
	 */
	public MultiMountedMapper(String mountPath,
			Class<? extends IRequestablePage> pageClass,
			IPageParametersEncoder pageParametersEncoder) {
		super(mountPath, pageClass, pageParametersEncoder);
	}

	/**
	 * @param mountPath
	 * @param pageClassProvider
	 * @param pageParametersEncoder
	 */
	public MultiMountedMapper(String mountPath,
			IProvider<Class<? extends IRequestablePage>> pageClassProvider,
			IPageParametersEncoder pageParametersEncoder) {
		super(mountPath, pageClassProvider, pageParametersEncoder);
	}
	
	@Override
	protected UrlInfo parseRequest(Request request) {
		final UrlInfo urlInfo = super.parseRequest(request);
		final PageParameters pageParams = urlInfo.getPageParameters();
		final String paramKey = pageParams.getNamedKeys().iterator().next();
		String paramValue = pageParams.get(paramKey).toString();
		final int indexedParams = pageParams.getIndexedCount();
		for (int i = indexedParams - 1; i >= 0; i--) {
			paramValue = pageParams.get(i) + "/" + paramValue;
			pageParams.remove(i);
		}
		pageParams.set(paramKey, paramValue);
		log.debug("URL Info {}", urlInfo);
		return urlInfo;
	}

}
