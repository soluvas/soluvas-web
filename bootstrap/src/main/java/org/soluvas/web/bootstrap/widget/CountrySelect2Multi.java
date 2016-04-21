package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.geo.Country;

/**
 * @author anton
 *
 */
public class CountrySelect2Multi extends BootstrapSelect2MultiChoice<Country> {
	
	public CountrySelect2Multi(final String id, final IModel<Collection<Country>> model) {
		super(id, model, new CountryChoiceProvider());
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
	}
	
}
