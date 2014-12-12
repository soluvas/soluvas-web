package org.soluvas.web.bootstrap;

import org.apache.wicket.request.http.WebResponse;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * Usage:
 * 
 * <pre>{@literal
 * categoryModel = new LoadableDetachableModel<Category>() {
 * 	@Override
 * 	protected Category load() {
 * 		final Category category = categoryRepo.findOneBySlugPath(slugPath, ImmutableSet.of(CategoryStatus.ACTIVE));
 * 		if (category == null) {
 * 			log.debug("Cannot find ACTIVE category with slug path '{}'", slugPath);
 * 			throw new NonResettingRestartException(PageNotFound.class, null, RedirectPolicy.NEVER_REDIRECT);
 * 		}
 * 	return category;
 * 	}
 * };
 * }</pre>
 * 
 * @author atang
 */
@SuppressWarnings("serial")
public class PageNotFound extends BootstrapPage {

	public PageNotFound(PageParameters params) {
		super(params);
//		add(new Page404());
	}
	
	@Override
	protected void configureResponse(WebResponse response) {
		// see http://stackoverflow.com/a/18941652/122441
		super.configureResponse(response);
		response.setStatus(404);
	}
	
}
