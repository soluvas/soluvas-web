package org.soluvas.web.site;

import javax.annotation.Nullable;

import com.google.common.base.Function;

@SuppressWarnings("null")
public class Nl2Br implements Function<String, String> {
	@Override @Nullable
	public String apply(@Nullable String input) {
		return input != null ? input.replace("\n", "<br>\n") : null;
	}
}