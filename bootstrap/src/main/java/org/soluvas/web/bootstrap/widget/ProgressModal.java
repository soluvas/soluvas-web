package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import de.agilecoders.wicket.markup.html.bootstrap.components.ProgressBar;
import de.agilecoders.wicket.markup.html.bootstrap.dialog.Modal;

/**
 * @author rudi
 */
public class ProgressModal extends Modal {

	private IModel<String> statusModel;

	/**
	 * @param markupId
	 */
	public ProgressModal(String markupId) {
		super(markupId);
		setDefaultModelObject("Please wait...");
	}

	/**
	 * @param id
	 * @param model
	 */
	public ProgressModal(String id, IModel<String> headerModel) {
		super(id, headerModel);
		this.statusModel = headerModel;
	}
	
	public ProgressModal(String id, IModel<String> headerModel, IModel<String> statusModel) {
		super(id, headerModel);
		this.statusModel = statusModel;
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		header((IModel<String>) getDefaultModel());
		final ProgressBar progressBar = new ProgressBar("progressBar").active(true).striped(true);
		progressBar.setDefaultModelObject(100);
		add(progressBar);
		final Label progressStatus = new Label("progressStatus", statusModel);
		add(progressStatus);
	}

}
