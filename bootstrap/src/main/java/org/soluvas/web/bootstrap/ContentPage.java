package org.soluvas.web.bootstrap;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.ops4j.pax.wicket.api.PaxWicketBean;
import org.ops4j.pax.wicket.api.PaxWicketMountPoint;
import org.soluvas.data.EntityLookup;

/**
 * Reads HTML file from specified folder or classpath location.
 * URI is e.g. /p/how-to-order
 * @author rudi
 * @todo Merge with Soluvas Content.
 */
@SuppressWarnings("serial")
@PaxWicketMountPoint(mountPoint="p/${slug}")
public class ContentPage extends BootstrapPage {

	@PaxWicketBean(name="contentLookup") @SpringBean(name="contentLookup")
	private EntityLookup<String, String> contentLookup;
	
	public ContentPage(PageParameters params) {
		super();
		final String slug = params.get("slug").toString();
		final Label contentLabel = new Label("content", new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				return contentLookup.findOne(slug);
			}
		});
		contentLabel.setEscapeModelStrings(false);
		add(contentLabel);
	}
	
}
