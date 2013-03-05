package org.soluvas.web.site;

import org.soluvas.commons.WebAddress;

/**
 * Add a CSS Stylesheet reference.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class CssLinkImpl implements CssLink {
	
	private final String path;
	private final String minifiedPath;
	private final int weight;
	private final String style;
	
	/**
	 * 
	 * @param path
	 *            The path to the CSS file, relative to
	 *            {@link WebAddress#getSkinUri()} (without leading slash).
	 */
	public CssLinkImpl(String path) {
		this(path, path, 0, null);
	}

	/**
	 * 
	 * @param path
	 *            The path to the CSS file, relative to
	 *            {@link WebAddress#getSkinUri()} (without leading slash).
	 * @param weight
	 */
	public CssLinkImpl(String path, String minifiedPath) {
		this(path, minifiedPath, 0, null);
	}
	
	/**
	 * 
	 * @param path
	 *            The path to the CSS file, relative to
	 *            {@link WebAddress#getSkinUri()} (without leading slash).
	 * @param weight
	 */
	public CssLinkImpl(String path, String minifiedPath, int weight) {
		this(path, minifiedPath, weight, null);
	}
	
	/**
	 * @param path
	 * @param weight
	 * @param style
	 */
	public CssLinkImpl(String path, String minifiedPath, int weight, String style) {
		super();
		this.path = path;
		this.minifiedPath = minifiedPath;
		this.weight = weight;
		this.style = style;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#getPath()
	 */
	@Override
	public String getPath() {
		return path;
	}
	
	/**
	 * @return the minifiedPath
	 */
	@Override
	public String getMinifiedPath() {
		return minifiedPath;
	}

	/* (non-Javadoc)
	 * @see org.soluvas.web.site.JavaScriptLink#getWeight()
	 */
	@Override
	public int getWeight() {
		return weight;
	}

	/**
	 * Name of Wicket style to enable this CSS.
	 * @see org.soluvas.web.site.CssLink#getStyle()
	 */
	@Override
	public String getStyle() {
		return style;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CssLinkImpl ["
				+ (path != null ? "path=" + path + ", " : "")
				+ (minifiedPath != null ? "minifiedPath=" + minifiedPath + ", "
						: "") + "weight=" + weight + ", "
				+ (style != null ? "style=" + style : "") + "]";
	}

}
