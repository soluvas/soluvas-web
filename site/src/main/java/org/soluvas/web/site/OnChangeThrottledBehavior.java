package org.soluvas.web.site;

import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.util.time.Duration;
import org.soluvas.web.site.widget.AutoDisableAjaxButton;
import org.soluvas.web.site.widget.AutoDisableAjaxCallListener;

/**
 * {@link OnChangeThrottledBehavior} with {@link ThrottlingSettings} (default 400ms).
 * 
 * @author ceefour
 * @see AutoDisableAjaxButton
 * @see AutoDisableAjaxCallListener
 */
public abstract class OnChangeThrottledBehavior extends AjaxFormComponentUpdatingBehavior {

	private static final long serialVersionUID = 1L;
	public static final ThrottlingSettings DEFAULT_THROTTLING =
			new ThrottlingSettings("OnChangeThrottledBehavior_400ms", Duration.milliseconds(400), true);
	private final ThrottlingSettings throttlingSettings;
	
	/**
	 * Uses {@link #DEFAULT_THROTTLING}. 
	 */
	public OnChangeThrottledBehavior(String event) {
		super(event);
		this.throttlingSettings = DEFAULT_THROTTLING;
	}
	
	public OnChangeThrottledBehavior(String event, int millis) {
		super(event);
		this.throttlingSettings = new ThrottlingSettings(millis + "ms", Duration.milliseconds(millis), true);
	}
	
	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
		super.updateAjaxAttributes(attributes);
		attributes.setThrottlingSettings(throttlingSettings);
	}

}
