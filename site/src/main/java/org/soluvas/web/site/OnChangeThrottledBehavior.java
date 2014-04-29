package org.soluvas.web.site;

import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.util.time.Duration;

/**
 * {@link OnChangeThrottledBehavior} with {@link ThrottlingSettings} (default 250ms).
 * @author ceefour
 */
public abstract class OnChangeThrottledBehavior extends OnChangeAjaxBehavior {

	private static final long serialVersionUID = 1L;
	public static final ThrottlingSettings DEFAULT_THROTTLING =
			new ThrottlingSettings("OnChangeThrottledBehavior_250", Duration.milliseconds(250), true);
	private final ThrottlingSettings throttlingSettings;
	
	/**
	 * Uses {@link #DEFAULT_THROTTLING} of 250ms. 
	 */
	public OnChangeThrottledBehavior() {
		super();
		this.throttlingSettings = DEFAULT_THROTTLING;
	}
	
	public OnChangeThrottledBehavior(int millis) {
		super();
		this.throttlingSettings = new ThrottlingSettings(millis + "ms", Duration.milliseconds(millis), true);
	}
	
	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
		super.updateAjaxAttributes(attributes);
		attributes.setThrottlingSettings(throttlingSettings);
	}

}
