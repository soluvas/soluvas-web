package org.soluvas.web.site;

import org.apache.wicket.Component;

/**
 * @author ceefour
 */
public interface ComponentFactory<T extends Component> {

	T create(String id);

}
