package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.request.resource.CssResourceReference;

import com.vaynberg.wicket.select2.Select2Choice;
import com.vaynberg.wicket.select2.Select2MultiChoice;

import de.agilecoders.wicket.core.Bootstrap;
import de.agilecoders.wicket.core.settings.IBootstrapSettings;

/**
 * <a href="http://fk.github.io/select2-bootstrap-css/">Select2 Bootstrap 3 CSS</a>:
 * CSS to make Select2 fit in with Bootstrap 3 – ready for use in original, LESS, Sass and Compass flavors.
 * 
 * <p>Usable both for wicket-select2 and wicketstuff-select2 (7.2.0+).</p>
 * 
 * <p>Usage:</p>
 * 
 * <code>
 * 	&commat;Override
 * 	public void renderHead(IHeaderResponse response) {
 * 		super.renderHead(response);
 * 		response.render(Select2Bootstrap.asHeaderItem());
 * 	}
 * 	</code>
 * 
 * @see InteractiveSelect2Choice
 * @see InteractiveSelect2MultiChoice
 * @see Select2Choice
 * @see Select2MultiChoice
 * @author ceefour
 */
public class Select2Bootstrap {

	public static final CssResourceReference SELECT2_BOOTSTRAP_MIN_CSS = new CssResourceReference(Select2Bootstrap.class, "select2-bootstrap.min.css");
	public static final String SELECT2_BOOTSTRAP_MIN_CSS_CDN = "https://cdnjs.cloudflare.com/ajax/libs/select2-bootstrap-css/1.4.6/select2-bootstrap.min.css";
	
	/**
	 * Uses CDN by {@link IBootstrapSettings#useCdnResources()}.
	 * @return
	 */
	public static CssHeaderItem asHeaderItem() {
		if (Bootstrap.getSettings().useCdnResources()) {
			return CssHeaderItem.forUrl(SELECT2_BOOTSTRAP_MIN_CSS_CDN);
		} else {
			return CssHeaderItem.forReference(SELECT2_BOOTSTRAP_MIN_CSS);
		}
	}
	
}
