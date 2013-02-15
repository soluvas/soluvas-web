package org.soluvas.web.site;

/**
 * Creates a {@literal map} entry in the RequireJS configuration.
 * @author ceefour
 */
public class JavaScriptAliasImpl implements JavaScriptAlias {
	
	private final String from;
	private final String to;
	private final AliasMode mode;
	
	/**
	 * @param from
	 * @param to
	 * @param mode
	 */
	public JavaScriptAliasImpl(String from, String to, AliasMode mode) {
		super();
		this.from = from;
		this.to = to;
		this.mode = mode;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptAlias#getFrom()
	 */
	@Override
	public String getFrom() {
		return from;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptAlias#getTo()
	 */
	@Override
	public String getTo() {
		return to;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptAlias#getMode()
	 */
	@Override
	public AliasMode getMode() {
		return mode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JavaScriptAliasImpl ["
				+ (from != null ? "from=" + from + ", " : "")
				+ (to != null ? "to=" + to + ", " : "")
				+ (mode != null ? "mode=" + mode : "") + "]";
	}

}
