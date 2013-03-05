package org.soluvas.web.site;

import org.apache.wicket.core.request.mapper.MountedMapper;
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
public class CleanUrlMapper extends MountedMapper {

	public CleanUrlMapper(String mountPath,
			Class<? extends IRequestablePage> pageClass,
			IPageParametersEncoder pageParametersEncoder) {
		super(mountPath, pageClass, pageParametersEncoder);
	}

	public CleanUrlMapper(String mountPath,
			Class<? extends IRequestablePage> pageClass) {
		super(mountPath, pageClass);
	}

	public CleanUrlMapper(String mountPath,
			IProvider<Class<? extends IRequestablePage>> pageClassProvider,
			IPageParametersEncoder pageParametersEncoder) {
		super(mountPath, pageClassProvider, pageParametersEncoder);
	}

	public CleanUrlMapper(String mountPath,
			IProvider<Class<? extends IRequestablePage>> pageClassProvider) {
		super(mountPath, pageClassProvider);
	}
	
	@Override
	protected void encodePageComponentInfo(Url url, PageComponentInfo info) {
		// do nothing so that component info does not get rendered in url
	}

}
