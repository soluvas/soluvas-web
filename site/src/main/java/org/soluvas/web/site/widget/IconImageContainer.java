package org.soluvas.web.site.widget;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Gender;
import org.soluvas.commons.PersonInfo;
import org.soluvas.image.ImageManager;

/**
 * @author adri
 *
 */
@SuppressWarnings("serial")
public class IconImageContainer extends ImageContainer {

	private static final Logger log = LoggerFactory
			.getLogger(IconImageContainer.class);
	@SpringBean
	private ImageManager imageMgr;
	private final IModel<?> origModel;
	
	/**
	 * @param id
	 * @param model Can be either {@link PersonInfo} or {@link Gender}.
	 */
	public IconImageContainer(String id, IModel<?> model) {
		super(id, new Model<String>());
		this.origModel = model;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		setDefaultModel(new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				final Object orig = origModel.getObject();
				if (orig != null) {
					final Gender gender;
					if (orig instanceof PersonInfo) {
						gender = ((PersonInfo) orig).getGender();
					} else if (orig != null && orig instanceof Gender) { 
						gender = (Gender) orig;
					} else {
						log.warn("Unknown model object {}", orig);
						gender = null;
					}
					return imageMgr.getPersonIconUri(gender);
				} else {
					return null;
				}
			}
		});
	}
	
}
