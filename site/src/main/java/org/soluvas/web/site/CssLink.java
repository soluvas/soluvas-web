package org.soluvas.web.site;

import java.io.Serializable;

import org.soluvas.commons.WebAddress;

/**
 * CSS Stylesheet reference information.
 * 
 * Usage:
 * 
 * <pre>
 * {@code 
 * <service auto-export="interfaces"> 
 * 	<bean class="org.soluvas.web.site.CssLinkImpl"> 
 * 		<argument value="id.co.bippo.salesorder.web/person.css"/> 
 * 	</bean> 
 * </service>
 * }
 * </pre>
 * 
 * @author ceefour
 */
public interface CssLink extends Serializable {

	/**
	 * The path to the CSS file, relative to {@link WebAddress#getSkinUri()}
	 * (without leading slash).
	 * 
	 * @return
	 */
	String getPath();

	/**
	 * Weight of the CSS file. Larger number will override previous CSS.
	 * @return
	 */
	int getWeight();

}