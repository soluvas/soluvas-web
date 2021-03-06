package org.soluvas.web.site;

import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.ajax.form.OnChangeAjaxBehavior;
import org.apache.wicket.util.time.Duration;

/**
 * {@link OnChangeThrottledBehavior} with {@link ThrottlingSettings} (default 400ms).
 * 
 * @author ceefour
 */
public abstract class OnChangeThrottledBehavior extends OnChangeAjaxBehavior {

	private static final long serialVersionUID = 1L;
	public static final ThrottlingSettings DEFAULT_THROTTLING =
			new ThrottlingSettings("OnChangeThrottledBehavior_400ms", Duration.milliseconds(400), true);
	
	private final ThrottlingSettings throttlingSettings;
	
	/**
	 * Uses {@link #DEFAULT_THROTTLING}.
	 */
	public OnChangeThrottledBehavior() {
		super();
		this.throttlingSettings = DEFAULT_THROTTLING;
	}
	
	public OnChangeThrottledBehavior(int millis) {
		super();
		this.throttlingSettings = new ThrottlingSettings(millis + "ms", Duration.milliseconds(millis), true);
	}
	
	/**
	 * Uses {@link #DEFAULT_THROTTLING}.
	 * @param event Ignored.
	 * @deprecated Wicket 6.17 has fixed {@link OnChangeAjaxBehavior}'s {@code event}. https://issues.apache.org/jira/browse/WICKET-5603 
	 */
	@Deprecated
	public OnChangeThrottledBehavior(String event) {
		this();
	}
	
	/**
	 * @param event Ignored.
	 * @param millis
	 * @deprecated Wicket 6.17 has fixed {@link OnChangeAjaxBehavior}'s {@code event}. https://issues.apache.org/jira/browse/WICKET-5603
	 */
	@Deprecated
	public OnChangeThrottledBehavior(String event, int millis) {
		this(millis);
	}
	
	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {
		super.updateAjaxAttributes(attributes);
		attributes.setThrottlingSettings(throttlingSettings);
	}

}
