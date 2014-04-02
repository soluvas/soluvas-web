package org.soluvas.web.site.widget;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.string.Strings;
import org.soluvas.geo.Country;
import org.soluvas.web.site.FlagsCssResourceReference;

/**
 * {@link Country} label.
 * @author rudi
 */
public class CountryLabel extends Label {

	private static final long serialVersionUID = 1L;

	public CountryLabel(String id, IModel<Country> model) {
		super(id, model);
	}
	
	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(FlagsCssResourceReference.INSTANCE));
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
	{
		final Country country = (Country) getDefaultModelObject();
		if (country != null) {
			final String escapedCountryName = Strings.escapeMarkup(country.getName(), false, false).toString();
			final String html = "<span class=\"flag flag-" + country.getIso().toLowerCase() + "\" title=\"" + escapedCountryName + "\"></span> " + escapedCountryName;
			replaceComponentTagBody(markupStream, openTag, html);
		} else {
			replaceComponentTagBody(markupStream, openTag, "");
		}
	}

}
