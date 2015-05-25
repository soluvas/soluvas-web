package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.geo.Country;

import com.vaynberg.wicket.select2.Select2MultiChoice;

/**
 * @author anton
 *
 */
public class CountrySelect2Multi extends Select2MultiChoice<Country> {
	
	private static final long serialVersionUID = 1L;
	
	public CountrySelect2Multi(final String id, final IModel<Collection<Country>> model) {
		super(id, model, new CountryChoiceProvider());
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xlarge"), " "));
		getSettings().getAjax().setQuietMillis(250);
		getSettings().setFormatResult(
				"function(object, container, query, escapeMarkup) {" +
				"var textMarkup = []; window.Select2.util.markMatch(object.text, query.term, textMarkup, escapeMarkup);" +
				"var thediv = $('<div>').css({marginLeft: '24px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
				"  .append(textMarkup.join('')).append($('<small>').text(object.formalId));" +
				"container.append(thediv);" +
				"}");
	}


}