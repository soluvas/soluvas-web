package org.soluvas.web.site.widget;

import java.util.Map;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.EnumLabel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;

/**
 * Renders {@link Enumerator} with genmodel annotation as <code>abbr title</code>.
 * If resource message is missing, will simply humanize the enum's <code>toString()</code>.
 * Optionally provides icon if mapping is provided.
 * @author adri
 */
@SuppressWarnings("serial")
public class TitledEnumLabel<T extends Enum<T>> extends EnumLabel<T> {

	private static final Logger log = LoggerFactory
			.getLogger(TitledEnumLabel.class);
	private final Map<T, String> mapping;
	private boolean enumVisible = true;
	private final IModel<String> titleModel;
	
	public TitledEnumLabel(String id, final IModel<T> model) {
		super(id, model);
		this.mapping = ImmutableMap.of();
		this.titleModel = new Model<>();
	}

	public TitledEnumLabel(String id, final IModel<T> model, final EEnum eEnum) {
		super(id, model);
		this.mapping = ImmutableMap.of();
		this.titleModel = initEEnum(eEnum);
	}

	public TitledEnumLabel(String id, final IModel<T> model, final EEnum eEnum,
			Map<T, String> mapping) {
		super(id, model);
		this.mapping = mapping;
		this.titleModel = initEEnum(eEnum);
	}
	
	public TitledEnumLabel(String id, final IModel<T> model, Map<T, String> mapping) {
		super(id, model);
		this.mapping = mapping;
		this.titleModel = new Model<>();
	}
	
	private IModel<String> initEEnum(final EEnum eEnum) {
		return new AbstractReadOnlyModel<String>() {
			@Override
			public String getObject() {
				final T enumValue = getModelObject();
				if (enumValue == null) {
					return null;
				}
//				incorrect result: final EEnumLiteral literal = eEnum.getEEnumLiteral(enumValue.ordinal());
				final EEnumLiteral literal = eEnum.getEEnumLiteral(enumValue.name().toLowerCase());
				if (literal != null) {
					final EAnnotation eAnnotation = literal
							.getEAnnotation("http://www.eclipse.org/emf/2002/GenModel");
					if (eAnnotation != null && eAnnotation.getDetails().containsKey("documentation")) {
						return eAnnotation.getDetails().get("documentation");
					} else {
						return null;
					}
				} else {
					log.warn("Cannot get {} enum literal {}", eEnum);
					return null;
				}
			}
		};
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		setRenderBodyOnly(true);
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		super.onComponentTag(tag);
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		final T obj = getModelObject();
		String enumValue = "";
		try {
			enumValue = getStringValue();
		} catch (Exception e) {
			enumValue = obj != null ? WordUtils.capitalizeFully(obj.toString().replace('_', ' ')) : "";
		}
		
		final String title = titleModel.getObject();
		final String iconStr;
		if (!mapping.isEmpty() && obj != null) {
			final String icon = mapping.containsKey(obj) ? mapping.get(obj) : "question-sign";
			iconStr = "<i class=\"icon-" + icon + "\" title=\"" + Strings.escapeMarkup(enumValue) + ". " + Strings.escapeMarkup(title) +"\"></i> ";
		} else {
			iconStr = "";
		}
		String enumStr = "";
		if (enumVisible) {
			final String titleStr = title != null ? " title=\"" + Strings.escapeMarkup(title) + "\"" : "";
			enumStr = "<abbr" + titleStr + ">" + Strings.escapeMarkup(enumValue) + "</abbr>";
		}
		replaceComponentTagBody(markupStream, openTag, iconStr + enumStr);
	}
	
	/**
	 * Converts model object into the display value
	 * 
	 * @return display value
	 */
	private String getStringValue()
	{
		T value = getModelObject();
		String converted = value != null ? getString(resourceKey(value)) : nullValue();
		return getDefaultModelObjectAsString(converted);
	}

	public boolean isEnumVisible() {
		return enumVisible;
	}

	public void setEnumVisible(boolean enumVisible) {
		this.enumVisible = enumVisible;
	}
}
