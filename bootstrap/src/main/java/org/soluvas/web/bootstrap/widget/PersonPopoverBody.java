package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.html.panel.EmptyPanel;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.PropertyModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.PersonInfo;
import org.soluvas.commons.entity.Person2;
import org.soluvas.commons.impl.CustomerRole2;
import org.soluvas.data.EntityLookup;
import org.soluvas.data.customerrole.CustomerRoleRepository;
import org.soluvas.image.DisplayImage2;
import org.soluvas.image.ImageManager;
import org.soluvas.image.ImageStyles;
import org.soluvas.image.ImageTypes;
import org.soluvas.web.site.ISocialApplication;
import org.soluvas.web.site.widget.DisplayImageContainer;

import com.google.common.base.Strings;

/**
 * Not directly usable. Only used to render the person popover by {@link PersonPopover}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class PersonPopoverBody extends GenericPanel<PersonInfo> {

	@SpringBean
	private ImageManager imageMgr;
	@SpringBean(name="personLookup")
	private EntityLookup<Person2, String> personLookup;
	@SpringBean
	private CustomerRoleRepository customerRoleRepo;

	public PersonPopoverBody(String id, IModel<PersonInfo> model) {
		super(id, model);
		final IModel<DisplayImage2> displayImage = new LoadableDetachableModel<DisplayImage2>() {
			@Override
			protected DisplayImage2 load() {
				final PersonInfo person = getModelObject();
				if (person != null) {
					return imageMgr.getSafePersonPhoto(ImageTypes.PERSON, person.getPhotoId(), ImageStyles.THUMBNAIL, person.getGender());
				} else {
					return null;
				}
			}
		};
		add(new DisplayImageContainer("photo", displayImage));
		
		add( new Label("lblName", new PropertyModel<>(getModel(), "name")) );
		
		if (getModelObject() != null && !Strings.isNullOrEmpty(getModelObject().getSlug())) {
			add(new BookmarkablePageLink<>("profileLink",
					((ISocialApplication) getApplication()).getPersonShowPage(),
					new PageParameters().set("slug", getModelObject().getSlug())));
		} else {
			add(new EmptyPanel("profileLink"));
		}

		final IModel<Person2> customerModel = new Model<>(personLookup.findOne(model.getObject().getId()));
		final IModel<String> currentCustomerRoleModel = new LoadableDetachableModel<String>() {
			@Override
			protected String load() {
				if (customerModel.getObject() == null) {
					return null;
				}
				if (Strings.isNullOrEmpty(customerModel.getObject().getCustomerRole())) {
					return null;
				}
				final CustomerRole2 customerRole = customerRoleRepo.findOne(customerModel.getObject().getCustomerRole());
				return customerRole != null ? customerRole.getName() : null; 
			}
		};
		add(new Label("customerRole", currentCustomerRoleModel));
	}

}
