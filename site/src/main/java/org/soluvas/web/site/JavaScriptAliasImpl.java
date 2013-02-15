package org.soluvas.web.site;

/**
 * Creates a {@literal map} entry in the RequireJS configuration.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class JavaScriptAliasImpl implements JavaScriptAlias {
	
	private final String from;
	private final String minifiedTo;
	private final String developmentTo;
	
	/**
	 * developmentTo is set to null (meaning this alias is not active during development).
	 * @param from
	 * @param minifiedTo
	 */
	public JavaScriptAliasImpl(String from, String minifiedTo) {
		this(from, minifiedTo, null);
	}

	/**
	 * @param from
	 * @param minifiedTo
	 * @param developmentTo
	 */
	public JavaScriptAliasImpl(String from, String minifiedTo,
			String developmentTo) {
		super();
		this.from = from;
		this.minifiedTo = minifiedTo;
		this.developmentTo = developmentTo;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptAlias#getFrom()
	 */
	@Override
	public String getFrom() {
		return from;
	}

	/**
	 * @return the minifiedTo
	 */
	@Override
	public String getMinifiedTo() {
		return minifiedTo;
	}

	/**
	 * @return the developmentTo
	 */
	@Override
	public String getDevelopmentTo() {
		return developmentTo;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "JavaScriptAliasImpl ["
				+ (from != null ? "from=" + from + ", " : "")
				+ (minifiedTo != null ? "minifiedTo=" + minifiedTo + ", " : "")
				+ (developmentTo != null ? "developmentTo=" + developmentTo
						: "") + "]";
	}
	
}
