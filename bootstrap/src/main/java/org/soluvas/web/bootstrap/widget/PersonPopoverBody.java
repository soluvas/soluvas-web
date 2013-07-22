package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.PersonInfo;
import org.soluvas.data.EntityLookup;
import org.soluvas.image.DisplayImage;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.soluvas.ldap.CustomerRoles;
import org.soluvas.ldap.SocialPerson;
import org.soluvas.web.site.PermalinkManager;
import org.soluvas.web.site.widget.DisplayImageContainer;

import com.google.common.base.Strings;

/**
 * Not directly usable. Only used to render the person popover by {@link PersonPopover}.
 * @author adri
 */
@SuppressWarnings("serial")
public class PersonPopoverBody extends GenericPanel<PersonInfo> {

	@SpringBean
	private ImageManager imageMgr;
	@SpringBean
	private PermalinkManager permalinkMgr;
	@SpringBean(name="personLookup")
	private EntityLookup<SocialPerson, String> personLookup;
	

	public PersonPopoverBody(String id, IModel<PersonInfo> model) {
		super(id, model);
		final IModel<DisplayImage> displayImage = new LoadableDetachableModel<DisplayImage>() {
			@Override
			protected DisplayImage load() {
				final PersonInfo person = getModelObject();
				if (person != null) {
					return imageMgr.getSafePersonPhoto(ImageTypes.PERSON, person.getPhotoId(), ImageStyles.THUMBNAIL, person.getGender());
				} else {
					return null;
				}
			}
		};
		add(new DisplayImageContainer("photo", displayImage));
		add(new ExternalLink("profileLink", new Model<String>()) {
			@Override
			protected void onConfigure() {
				if (getModelObject() != null && !Strings.isNullOrEmpty(getModelObject().getSlug())) {
					setDefaultModelObject(permalinkMgr.relative("person", getModelObject().getSlug()));
				} else {
					setVisible(false);
				}
				super.onConfigure();
			}
		});
		
		final IModel<SocialPerson> customerModel = new Model<>(personLookup.findOne(model.getObject().getId()));
		final Model<String> currentCustomerRoleModel = new Model<>(
				customerModel.getObject() != null ? CustomerRoles.DISPLAY_NAMES.get(customerModel.getObject().getCustomerRole()) : null);
		add(new Label("customerRole", currentCustomerRoleModel));
	}

}
