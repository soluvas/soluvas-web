package org.soluvas.web.site.widget;

import java.util.Locale;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.string.Strings;
import org.eclipse.emf.common.util.EMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.Translation;
import org.soluvas.commons.WebAddress;
import org.soluvas.data.MeasureValue;
import org.soluvas.data.Term2;
import org.soluvas.data.TermManager;
import org.soluvas.data.TermValue;
import org.soluvas.data.Value;
import org.soluvas.mongo.MongoTermRepository;
import org.soluvas.web.site.EmfModel;

/**
 * Formats a {@link Value}, and if lookup successful via {@link TermManager}, with associated
 * image or color.
 * @author agus
 */
@SuppressWarnings("serial")
public class ValueLabel2 extends Label {
	
	private static final Logger log = LoggerFactory.getLogger(ValueLabel2.class);

	@SpringBean
	private MongoTermRepository termRepo;
	@SpringBean
	private WebAddress webAddress;
	
	private boolean hideTextIfImageExists = false;
	private IModel<Locale> originalLocaleModel = new Model<>(new Locale("id", "ID"));

	public ValueLabel2(String id, IModel<Value<?>> model) {
		super(id, model);
	}

	public ValueLabel2(String id, Value<?> value) {
		this(id, new EmfModel<Value<?>>(value));
	}
	
	public ValueLabel2(String id, IModel<Value<?>> model, boolean hideTextIfImageExists) {
		super(id, model);
		this.hideTextIfImageExists = hideTextIfImageExists;
	}

	public ValueLabel2(String id, Value<?> value, boolean hideTextIfImageExists) {
		this(id, new EmfModel<Value<?>>(value), hideTextIfImageExists);
	}
	
	public ValueLabel2(String id, IModel<Value<?>> model, IModel<Locale> originalLocaleModel) {
		super(id, model);
//		log.debug("Constructor with original locale: {}", originalLocaleModel.getObject());
		this.originalLocaleModel = originalLocaleModel;
	}
	
	@Override
	protected void onConfigure() {
		super.onConfigure();
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag)
	{
		replaceComponentTagBody(markupStream, openTag, getDefaultModelObjectAsFormattedString());
	}

	private String getDefaultModelObjectAsFormattedString() {
		final Value<?> valueObj = (Value<?>) getDefaultModelObject();
//		log.debug("Value obj: {}", valueObj);
//		final Locale locale = getLocale();
		if (valueObj != null) {
			String displayName;
			final String languageTag = getSession().getLocale().toLanguageTag();
//			log.debug("Session language tag: {}", languageTag);
			if (originalLocaleModel.getObject().toLanguageTag().equals(languageTag)) {
				displayName = valueObj.getDisplayValue();
			} else {
				final EMap<String, Translation> translations = valueObj.getTranslations();
				if (translations.isEmpty()) {
					displayName = valueObj.getDisplayValue();
				} else {
					if (!translations.containsKey(languageTag)) {
						displayName = valueObj.getDisplayValue();
					} else {
						final Translation translation = translations.get(languageTag);
						if (!translation.getMessages().containsKey(Value.DISPLAY_VALUE_ATTR)) {
							log.debug("Got translation by {}, but not value by attribute {}",
									languageTag, Value.DISPLAY_VALUE_ATTR);
							displayName = valueObj.getDisplayValue();
						} else {
							displayName = translation.getMessages().get(Value.DISPLAY_VALUE_ATTR);
							log.debug("Got translation by {} with value by attribute {}: {}",
									languageTag, Value.DISPLAY_VALUE_ATTR, displayName);
						}
					}
				}
			}
			
//			log.debug("displayName: {}", displayName);
			if (valueObj instanceof MeasureValue) {
				final MeasureValue measureValue = (MeasureValue) valueObj;
				displayName += " " + measureValue.getValueUnit().toString();
				return Strings.escapeMarkup(displayName) + "";
			} else if (valueObj instanceof TermValue) {
				final Term2 term = termRepo.findOne(String.valueOf(valueObj.getValue()));
				
				final String iconHtml;
				if (term.getImageId() != null) {
					final String uri = term.getImageUri(webAddress.getImagesUri());
					iconHtml = "<img class=\"img-circle\" src=\"" + uri + "\" alt=\"" + Strings.escapeMarkup(displayName) + "\" title=\"" + org.apache.wicket.util.string.Strings.escapeMarkup(displayName) + "\"/> ";
				} else {
					final String color = term.getColor();
					if (color != null) {
						iconHtml = "<span class=\"img-circle\" style=\"background: " + color + "; width: 20px; display: inline-block; border: 1px solid #ccc;\">&nbsp;</span> "; 
					} else {
						iconHtml = "";
					}
				}
				if (hideTextIfImageExists && !"".equals(iconHtml)) {
					return iconHtml;
				} else {
					return iconHtml + Strings.escapeMarkup(displayName);
				}
			} else {
				return Strings.escapeMarkup(displayName) + ""; // foolproof way to convert CharSequence to String, do NOT cast CharSequence to String!
			}
		} else {
			return "";
		}
	}
	
}
