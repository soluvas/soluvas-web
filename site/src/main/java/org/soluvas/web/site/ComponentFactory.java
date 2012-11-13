package org.soluvas.web.site;

import org.apache.wicket.Component;

/**
 * To be used as OSGi Service to add components to a predefined component region ("kavling").
 * 
 * Sample producer (in the kavling side):
 * 
 * <pre>{@code
 * 	<service auto-export="interfaces">
 *		<service-properties>
 *			<entry key="region" value="sidebar"/>
 *		</service-properties>
 *		<bean class="id.co.bippo.product.web.pub.CategorySidebarFactory"/>
 *	</service>
 * }</pre>
 * 
 * Sample consumer (in the kavling side):
 * 
 * <pre>{@code
 * <reference-list id="sidebarBlocks" interface="org.soluvas.web.site.ComponentFactory" availability="optional"
 *		filter="(region=sidebar)"/>
 * }</pre>
 * 
 * @author ceefour
 */
public interface ComponentFactory<T extends Component> {

	public <S extends T> S create(String id);

}
