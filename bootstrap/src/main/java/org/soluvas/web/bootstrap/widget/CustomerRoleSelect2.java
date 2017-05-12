package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.commons.CustomerRole;
import org.soluvas.commons.impl.CustomerRole2;
import org.soluvas.web.site.EmfModel;

/**
 * @author rudi
 *
 */
@SuppressWarnings("serial")
public class CustomerRoleSelect2 extends BootstrapSelect2Choice<CustomerRole2> {
	
	public CustomerRoleSelect2(final String id) {
		super(id, new Model<CustomerRole2>(), new CustomerRoleChoiceProvider());
	}
	
	public CustomerRoleSelect2(final String id, final IModel<CustomerRole2> model) {
		super(id, model, new CustomerRoleChoiceProvider());
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		getSettings().getAjax().setDelay(250);
		getSettings().setTemplateResult(
				"function(object) {" +
				"if (!object.id) return object.text;" +
				"var thediv = $('<div>').css({marginLeft: '24px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
				"  .append(document.createTextNode(object.text)).append($('<small>').text(object.formalId));" +
				"return thediv;" +
				"}");
		getSettings().setCloseOnSelect(true);
	}

}
