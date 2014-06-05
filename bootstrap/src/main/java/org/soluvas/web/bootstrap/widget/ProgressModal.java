package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import de.agilecoders.wicket.core.markup.html.bootstrap.components.progress.ProgressBar;
import de.agilecoders.wicket.core.markup.html.bootstrap.dialog.Modal;

/**
 * @author rudi
 */
@SuppressWarnings("serial")
public class ProgressModal extends Modal<String> {

	/**
	 * @param id
	 * @param model
	 */
	public ProgressModal(String id) {
		super(id);
		setModelObject("Please wait...");
	}
	
	public ProgressModal(String id, IModel<String> statusModel) {
		super(id, statusModel);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		final ProgressBar progressBar = new ProgressBar("progressBar").active(true).striped(true);
		progressBar.setDefaultModelObject(100);
		add(progressBar);
		final Label progressStatus = new Label("progressStatus", getModel());
		add(progressStatus);
	}

}
