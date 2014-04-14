package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.ExternalLink;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.CustomerRole;
import org.soluvas.commons.Person;
import org.soluvas.commons.PersonInfo;
import org.soluvas.data.EntityLookup;
import org.soluvas.data.customerrole.CustomerRoleRepository;
import org.soluvas.image.DisplayImage;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.soluvas.web.site.EmfModel;
import org.soluvas.web.site.PermalinkManager;
import org.soluvas.web.site.widget.DisplayImageContainer;

import com.google.common.base.Strings;

/**
 * Not directly usable. Only used to render the person popover by {@link PersonPopover}.
 * @author adri
 */
public class PersonPopoverBody extends GenericPanel<PersonInfo> {

	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private ImageManager imageMgr;
	@SpringBean
	private PermalinkManager permalinkMgr;
	@SpringBean(name="personLookup")
	private EntityLookup<Person, String> personLookup;
	@SpringBean
	private CustomerRoleRepository customerRoleRepo;
	

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
		
		final IModel<Person> customerModel = new EmfModel<>(personLookup.findOne(model.getObject().getId()));
		final IModel<String> currentCustomerRoleModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				if (customerModel.getObject() == null) {
					return null;
				}
				if (Strings.isNullOrEmpty(customerModel.getObject().getCustomerRole())) {
					return null;
				}
				final CustomerRole customerRole = customerRoleRepo.findOne(customerModel.getObject().getCustomerRole());
				return customerRole != null ? customerRole.getName() : null; 
			}
		};
		add(new Label("customerRole", currentCustomerRoleModel));
	}

}
