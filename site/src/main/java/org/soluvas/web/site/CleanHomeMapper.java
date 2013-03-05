package org.soluvas.web.site;

import org.apache.wicket.core.request.mapper.HomePageMapper;
import org.apache.wicket.request.Url;
import org.apache.wicket.request.component.IRequestablePage;
import org.apache.wicket.request.mapper.info.PageComponentInfo;
import org.apache.wicket.request.mapper.parameter.IPageParametersEncoder;
import org.apache.wicket.util.IProvider;

/**
 * http://stackoverflow.com/a/8667136/1343587
 * @author rudi
 *
 */
public class CleanHomeMapper extends HomePageMapper {
	
	public CleanHomeMapper(Class<? extends IRequestablePage> pageClass,
			IPageParametersEncoder pageParametersEncoder) {
		super(pageClass, pageParametersEncoder);
	}

	public CleanHomeMapper(Class<? extends IRequestablePage> pageClass) {
		super(pageClass);
	}

	public CleanHomeMapper(
			IProvider<Class<? extends IRequestablePage>> pageClassProvider) {
		super(pageClassProvider);
	}

	@Override
	protected void encodePageComponentInfo(Url url, PageComponentInfo info) {
		// do nothing so that component info does not get rendered in url
	}

}
