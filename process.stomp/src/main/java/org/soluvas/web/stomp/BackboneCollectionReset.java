package org.soluvas.web.stomp;

import java.util.concurrent.atomic.AtomicReference;

import org.soluvas.async.CallbackAdapter;
import org.soluvas.json.JsonUtils;
import org.soluvas.web.nav.Menu;
import org.soluvas.web.nav.MenuRepository;
import org.soluvas.web.site.JavaScriptSourceImpl;

/**
 * Reset Backbone Collection on the client for first view, so that the Backbone View(s)
 * are attached to the Backbone Collection.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class BackboneCollectionReset extends JavaScriptSourceImpl {

	private MenuRepository menuRepository;
	
	public BackboneCollectionReset(MenuRepository menuRepository, int weight) {
		super(null, weight);
		this.menuRepository = menuRepository;
	}

	/**
	 * Output JavaScript like this:
	 * 
	 * <code>
	 * 		sidebarMenuItems.reset([{id: 'checkin', label: 'Checkin', 'iconName': 'check', 'clientPath': 'checkin/'},
	 *	                        {id: 'processList', label: 'Process List', 'iconName': 'cog', 'clientPath': 'process/'}]);
	 * </code>
	 */
	@Override
	public String getBody() {
		final AtomicReference<String> body = new AtomicReference<String>();
		menuRepository.findOne("main", new CallbackAdapter<Void, Void, Menu>() {
			@Override
			public void success(Menu data) {
				String buf = "$(document).ready(function() {\n";
				buf += "	navbarMenuItems.reset( " + JsonUtils.asJson(data.getItems()) + " );\n";
				buf += "	sidebarMenuItems.reset( " + JsonUtils.asJson(data.getItems()) + " );\n";
				buf += "});\n";
				body.set( buf );
			}
		});
		return body.get();
	}

}
