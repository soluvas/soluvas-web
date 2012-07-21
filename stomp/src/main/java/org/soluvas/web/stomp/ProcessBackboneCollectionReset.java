package org.soluvas.web.stomp;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.soluvas.async.CallbackAdapter;
import org.soluvas.json.JsonUtils;
import org.soluvas.process.ProcessRepository;
import org.soluvas.web.nav.Menu;
import org.soluvas.web.site.JavaScriptSourceImpl;

/**
 * Reset Backbone Collection on the client for first view, so that the Backbone View(s)
 * are attached to the Backbone Collection.
 * @author ceefour
 */
@SuppressWarnings("serial")
public class ProcessBackboneCollectionReset extends JavaScriptSourceImpl {

	private ProcessRepository processRepository;
	
	public ProcessBackboneCollectionReset(ProcessRepository processRepository, int weight) {
		super(null, weight);
		this.processRepository = processRepository;
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
		processRepository.findAll(new CallbackAdapter<Void, Void, List<org.soluvas.process.Process>>() {
			@Override
			public void success(List<org.soluvas.process.Process> processes) {
				String buf = "$(document).ready(function() {\n";
				buf += "	processItems.reset( " + JsonUtils.asJson(processes) + " );\n";
				buf += "});\n";
				body.set( buf );
			}
		});
		return body.get();
	}

}
