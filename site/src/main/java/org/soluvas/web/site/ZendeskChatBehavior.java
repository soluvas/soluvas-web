package org.soluvas.web.site;

import javax.inject.Inject;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.StringHeaderItem;

/**
 * @author rudi
 *
 */
public class ZendeskChatBehavior extends Behavior {
	
	@Inject
	private ZendeskChatSysConfig sysConfig;
	
	@Override
	public void renderHead(Component component, IHeaderResponse response) {
		super.renderHead(component, response);
		
		if (sysConfig.isZendeskChatEnabled()) {
			final String js = "<!--Start of Zendesk Chat Script--> \n"
					+ "<script type=\"text/javascript\"> \n"
					+ "window.$zopim||(function(d,s){var z=$zopim=function(c){z._.push(c)},$=z.s= \n"
					+ "d.createElement(s),e=d.getElementsByTagName(s)[0];z.set=function(o){z.set. \n"
					+ "_.push(o)};z._=[];z.set._=[];$.async=!0;$.setAttribute(\"charset\",\"utf-8\"); \n"
					+ "$.src=\"https://v2.zopim.com/?591cZbmmebWXzYVcg6g0jyePRgzx6Iyg\";z.t=+new Date;$. \n"
					+ "type=\"text/javascript\";e.parentNode.insertBefore($,e)})(document,\"script\"); \n"
					+ "</script> \n"
					+ "<!--End of Zendesk Chat Script--> \n"
					+ "";

			response.render(StringHeaderItem.forString(js));
		}
	}

}
