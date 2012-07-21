package org.soluvas.web.site;

import org.apache.wicket.Component;

public class SidebarNavFactory implements SidebarBlock {

	@Override
	public Component create() {
		return new SidebarNav("block");
	}

}
