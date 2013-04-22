package org.soluvas.web.site;

import java.io.Serializable;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxButton;
import org.apache.wicket.extensions.ajax.markup.html.modal.ModalWindow;

/**
 * Used to pass a callback function to a child {@link ModalWindow}/Bootstrap Modal
 * when the <b>Yes</b> {@link AjaxButton} is clicked.
 * @author rudi
 */
public interface YesCallback extends Serializable {
	
	public abstract void onYes(AjaxRequestTarget target);

}
