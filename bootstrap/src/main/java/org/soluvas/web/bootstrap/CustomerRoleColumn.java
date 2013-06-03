package org.soluvas.web.bootstrap;

import org.apache.wicket.extensions.markup.html.repeater.data.grid.ICellPopulator;
import org.apache.wicket.extensions.markup.html.repeater.data.table.PropertyColumn;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.Item;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.PropertyModel;
import org.soluvas.commons.PersonInfo;
import org.soluvas.data.EntityLookup;
import org.soluvas.ldap.SocialPerson;

/**
 * Has joined to {@link PersonColumn}.
 * @author rudi
 *
 */
@Deprecated
@SuppressWarnings("serial")
public class CustomerRoleColumn<SalesOrder> extends PropertyColumn<SalesOrder, String> {
	
	private final String propertyExpression;
	private final EntityLookup<SocialPerson, String> personLookup;

	public CustomerRoleColumn(IModel<String> displayModel, String sortProperty,
			String propertyExpression, EntityLookup<SocialPerson, String> personLookup) {
		super(displayModel, sortProperty, propertyExpression);
		
		this.propertyExpression = propertyExpression;
		this.personLookup = personLookup;
	}
	
	
	
	@Override
	public void populateItem(Item<ICellPopulator<SalesOrder>> item,
			String componentId, IModel<SalesOrder> rowModel) {
		final PropertyModel<PersonInfo> customerModel = new PropertyModel<>(rowModel, propertyExpression);
		final SocialPerson customer = personLookup.findOne(customerModel.getObject().getId());
		item.add(new Label(componentId, customer.getCustomerRole()));
	}
	
}
