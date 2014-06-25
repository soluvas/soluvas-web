package org.soluvas.web.bootstrap;

import java.io.File;
import java.util.Map;

import javax.annotation.Nullable;

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

	/**
	 * @param tenantId
	 * @param style User provided style if exists. If {@code null}, will use {@link #getDefaultTheme()}.
	 * @param themePref
	 * @return
	 */
	Optional<File> generateThemeStyle(String tenantId, @Nullable String style,
			ThemePref themePref);

	Map<String, SoluvasTheme> getThemes();

	SoluvasTheme getDefaultTheme();

}