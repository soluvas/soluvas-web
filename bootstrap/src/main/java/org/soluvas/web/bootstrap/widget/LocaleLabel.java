package org.soluvas.web.bootstrap.widget;

import java.util.Locale;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.web.site.FlagsCssResourceReference;

import com.vaynberg.wicket.select2.Select2Choice;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;

/**
 * {@link Select2Choice} UI component for {@link Locale}.
 * The {@link IModel} can be a {@link Locale} or a language tag as {@link String}.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class LocaleLabel extends Label {

	public LocaleLabel(String id, IModel<?> model) {
		super(id, model);
		add(new CssClassNameAppender(new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				Object modelObj = getDefaultModelObject();
				Locale locale = null;
				if (modelObj instanceof Locale) {
					locale = (Locale) modelObj;
				} else if (modelObj instanceof String) {
					locale = Locale.forLanguageTag((String) modelObj);
				}
				if (locale != null) {
					String country = locale.getCountry();
					if (country != null) {
						return "flag flag-" + country.toLowerCase();
					} else {
						return null;
					}
				} else {
					return null;
				}
			}
		}));
		add(new AttributeModifier("title", new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				Object modelObj = getDefaultModelObject();
				Locale locale = null;
				if (modelObj instanceof Locale) {
					locale = (Locale) modelObj;
				} else if (modelObj instanceof String) {
					locale = Locale.forLanguageTag((String) modelObj);
				}
				if (locale != null) {
					return locale.getDisplayName(getLocale());
				} else {
					return null;
				}
			};
		}));
	}
	
	public LocaleLabel(String id, String model) {
		this(id, new Model<>(model));
	}

	public LocaleLabel(String id, Locale model) {
		this(id, new Model<>(model));
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(FlagsCssResourceReference.INSTANCE));
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		// flag only
		replaceComponentTagBody(markupStream, openTag, null);
//		super.onComponentTagBody(markupStream, openTag);
	}
	
}
