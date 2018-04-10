package org.soluvas.web.site;

import java.io.Serializable;

import org.apache.wicket.ajax.AjaxRequestTarget;

public interface CancelCallback extends Serializable {
	
	public abstract void onCancel(AjaxRequestTarget target);
	
}
