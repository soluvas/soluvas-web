package org.soluvas.web.bootstrap;

import org.apache.wicket.util.resource.IResourceStream;
import org.stringtemplate.v4.ST;

import de.agilecoders.wicket.less.LessResourceStream;

/**
 * A {@link LessResourceStream} that passes through {@link ST}.
 * @author anton
 * @deprecated kayanya gak jadi, pake {@link ThemeManager} aja
 */
@Deprecated
public class StringTemplateLessResourceStream extends LessResourceStream {

	private static final long serialVersionUID = 1L;

	/**
	 * @param lessStream
	 */
	public StringTemplateLessResourceStream(IResourceStream lessStream) {
		super(lessStream);
	}

}
