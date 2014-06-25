package org.soluvas.web.bootstrap;

import java.io.File;
import java.util.Map;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.soluvas.web.site.ThemePref;

import com.google.common.base.Optional;

public interface ThemeManager {

	/**
	 * Renders the {@link CssHeaderItem} for the theme of the specified {@code tenantId}.
	 * Only affects {@link SoluvasTheme.Format#LESS}, otherwise noop.
	 * @param tenantId
	 * @param style
	 * @param response
	 */
	void renderThemeStyle(String tenantId, String style,
			IHeaderResponse response);

	Optional<File> generateThemeStyle(String tenantId, String style,
			ThemePref themePref);

	Map<String, SoluvasTheme> getThemes();

	SoluvasTheme getDefaultTheme();

}