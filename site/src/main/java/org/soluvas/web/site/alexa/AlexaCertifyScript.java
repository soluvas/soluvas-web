package org.soluvas.web.site.alexa;

import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;
import org.soluvas.web.site.MustachePanel;

/**
 * Outputs the Alexa Certify script.
 * 
 * <p>Sample:
 * 
 * <code>@{literal
 * <!-- Start Alexa Certify Javascript -->
 * <script type="text/javascript">
 * _atrk_opts = { atrk_acct:"QB0hh1a0k700Eo", domain:"berbatik.com",dynamic: true};
 * (function() { var as = document.createElement('script'); as.type = 'text/javascript'; as.async = true; as.src = "https://d31qbv1cthcecs.cloudfront.net/atrk.js"; var s = document.getElementsByTagName('script')[0];s.parentNode.insertBefore(as, s); })();
 * </script>
 * <noscript><img src="https://d5nxst8fruw4z.cloudfront.net/atrk.gif?account=QB0hh1a0k700Eo" style="display:none" height="1" width="1" alt="" /></noscript>
 * <!-- End Alexa Certify Javascript -->
 * }</code> 
 *
 * <p>We can't replace this with {@link Behavior}, because there's {@code noscript}. However we can move the JavaScript part using {@link #renderHead(org.apache.wicket.markup.head.IHeaderResponse)}.
 * @author rudi
 */
@SuppressWarnings("serial")
public class AlexaCertifyScript extends MustachePanel {

	public AlexaCertifyScript(String id, IModel<AlexaCertify> model) {
		super(id, model);
		setRenderBodyOnly(true);
	}
	
	@Override
	protected void onConfigure() {
		super.onConfigure();
		final AlexaCertify alexaCertify = (AlexaCertify) getDefaultModelObject();
		setVisible(alexaCertify != null && alexaCertify.isEnabled()); 
	}
	
}
