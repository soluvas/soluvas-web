package org.soluvas.web.site.widget;

import java.util.Map;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.EnumLabel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.string.Strings;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EAnnotation;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;

/**
 * Renders {@link Enumerator} with genmodel annotation as <code>abbr title</code>.
 * If resource message is missing, will simply humanize the enum's <code>toString()</code>.
 * Optionally provides icon if mapping is provided.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class TitledEnumLabel<T extends Enum<T>> extends EnumLabel<T> {

	private static final Logger log = LoggerFactory
			.getLogger(TitledEnumLabel.class);
	private final Map<T, String> iconMapping;
	private boolean enumVisible = true;
	private final Map<T, String> docs;
	
	public TitledEnumLabel(String id, final IModel<T> model) {
		super(id, model);
		this.iconMapping = ImmutableMap.of();
		this.docs = ImmutableMap.of();
	}

	public TitledEnumLabel(String id, final IModel<T> model, final EEnum eEnum) {
		super(id, model);
		this.iconMapping = ImmutableMap.of();
		this.docs = (Map<T, String>) getEEnumDocs(eEnum);
	}

	public TitledEnumLabel(String id, final IModel<T> model, final EEnum eEnum,
			Map<T, String> mapping) {
		super(id, model);
		this.iconMapping = mapping;
		this.docs = (Map<T, String>) getEEnumDocs(eEnum);
	}
	
	public TitledEnumLabel(String id, final IModel<T> model, final Map<T, String> docs,
			Map<T, String> mapping) {
		super(id, model);
		this.iconMapping = mapping;
		this.docs = docs;
	}
	
	public TitledEnumLabel(String id, final IModel<T> model, Map<T, String> iconMapping) {
		super(id, model);
		this.iconMapping = iconMapping;
		this.docs = ImmutableMap.of();
	}
	
	public static <E extends Enum<E>> Map<E, String> getEEnumDocs(final EEnum eEnum) {
		Preconditions.checkNotNull(eEnum, "EEnum must be specified");
		final ImmutableMap.Builder<E, String> b = ImmutableMap.builder();
		for (final EEnumLiteral literal : eEnum.getELiterals()) {
			final EAnnotation eAnnotation = literal
					.getEAnnotation("http://www.eclipse.org/emf/2002/GenModel");
			if (eAnnotation != null && eAnnotation.getDetails().containsKey("documentation")) {
				final String doc = eAnnotation.getDetails().get("documentation");
				b.put((E) literal.getInstance(), doc);
			}
		}
		return b.build();
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
		
		final String title = docs.get(obj);
		final String iconStr;
		if (!iconMapping.isEmpty() && obj != null) {
			final String icon = iconMapping.containsKey(obj) ? iconMapping.get(obj) : "question-sign";
			iconStr = "<i class=\"icon-" + icon + "\" title=\"" + Strings.escapeMarkup(enumValue) + ". " + Strings.escapeMarkup(Optional.fromNullable(title).or("")) +"\" data-toggle=\"tooltip\"></i> ";
		} else {
			iconStr = "";
		}
		String enumStr = "";
		if (enumVisible) {
			final String titleAttr = title != null ? " title=\"" + Strings.escapeMarkup(title) + "\"" : "";
			enumStr = "<abbr" + titleAttr + " data-toggle=\"tooltip\">" + Strings.escapeMarkup(enumValue) + "</abbr>";
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
