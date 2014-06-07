package org.soluvas.web.bootstrap.backend;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.filter.HeaderResponseContainer;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.soluvas.web.bootstrap.AfterBootstrapCssResourceReference;
import org.soluvas.web.bootstrap.AfterBootstrapJavaScriptResourceReference;
import org.soluvas.web.bootstrap.GrowlBehavior;
import org.soluvas.web.bootstrap.JQueryEasing;
import org.soluvas.web.site.AfterJQueryJavaScriptResourceReference;
import org.soluvas.web.site.FontAwesomeResourceReference;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.HtmlTag;

/**
 * Only default styling.
 * @author rio
 */
@SuppressWarnings("serial")
public class ManagePage extends WebPage {
	
	private static final JavaScriptResourceReference jqueryUiJs = 
			new AfterJQueryJavaScriptResourceReference(ManagePage.class, "assets/jquery-ui/jquery-ui-1.10.1.custom.min.js");
	private static final JavaScriptResourceReference accordionMenuJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "js/accordion-menu/jquery.dcjqaccordion.2.7.js");
	private static final JavaScriptResourceReference scrollToJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "js/scrollTo/jquery.scrollTo.min.js");
	private static final JavaScriptResourceReference niceScrollJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "js/nicescroll/jquery.nicescroll.js");
	private static final JavaScriptResourceReference slimScroll = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "assets/jQuery-slimScroll-1.3.0/jquery.slimscroll.js");
	private static final JavaScriptResourceReference skyconsJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "assets/skycons/skycons.js");
	private static final JavaScriptResourceReference underscoreJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "js/underscore-min.js");
	private static final JavaScriptResourceReference gaugeJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "assets/gauge/gauge.js");
	private static final JavaScriptResourceReference customSelectJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "js/custom-select/jquery.customSelect.min.js");
//	private static final JavaScriptResourceReference bootstrapSwitchJs = new AfterBootstrapJavaScriptResourceReference(ManagePage.class, "assets/bootstrap-switch-master/build/js/bootstrap-switch.js");
	private static final JavaScriptResourceReference spinnerJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "assets/fuelux/js/spinner.min.js");
	private static final JavaScriptResourceReference bootstrapFileUploadJs = new AfterBootstrapJavaScriptResourceReference(ManagePage.class, "assets/bootstrap-fileupload/bootstrap-fileupload.js");
	private static final JavaScriptResourceReference wysiHtml5Js = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "assets/bootstrap-wysihtml5/wysihtml5-0.3.0.js");
	private static final JavaScriptResourceReference bootstrapWysihtml5Js = new AfterBootstrapJavaScriptResourceReference(ManagePage.class, "assets/bootstrap-wysihtml5/bootstrap-wysihtml5.js");
	private static final JavaScriptResourceReference bootstrapDatePickerJs = new AfterBootstrapJavaScriptResourceReference(ManagePage.class, "assets/bootstrap-datepicker/js/bootstrap-datepicker.js");
	private static final JavaScriptResourceReference bootstrapDateTimePickerJs = new AfterBootstrapJavaScriptResourceReference(ManagePage.class, "assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js");
	private static final JavaScriptResourceReference momentJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "assets/bootstrap-daterangepicker/moment.min.js");
	private static final JavaScriptResourceReference dateRangePickerJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "assets/bootstrap-daterangepicker/daterangepicker.js");
//	private static final JavaScriptResourceReference bootstrapColorPickerJs = new AfterBootstrapJavaScriptResourceReference(BackendPage.class, "assets/bootstrap-colorpicker/js/bootstrap-colorpicker.js");
	private static final JavaScriptResourceReference bootstrapTImePickerJs = new AfterBootstrapJavaScriptResourceReference(ManagePage.class, "assets/bootstrap-timepicker/js/bootstrap-timepicker.js");
	private static final JavaScriptResourceReference jqueryMultiSelectJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "assets/jquery-multi-select/js/jquery.multi-select.js");
	private static final JavaScriptResourceReference jqueryQuickSearchJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "assets/jquery-multi-select/js/jquery.quicksearch.js");
	private static final JavaScriptResourceReference bootstrapInputMaskJs = new AfterBootstrapJavaScriptResourceReference(ManagePage.class, "assets/bootstrap-inputmask/bootstrap-inputmask.min.js");
	private static final JavaScriptResourceReference jqueryTagsinputJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "assets/jquery-tags-input/jquery.tagsinput.js");
	private static final JavaScriptResourceReference scriptsJs = new AfterBootstrapJavaScriptResourceReference(ManagePage.class, "js/scripts.js");
	private static final JavaScriptResourceReference toggleInitJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "js/toggle-button/toggle-init.js");
	private static final JavaScriptResourceReference advancedFormJs = new AfterJQueryJavaScriptResourceReference(ManagePage.class, "js/advanced-form/advanced-form.js");
	
	protected final RepeatingView sidebarBlocks;
	protected TransparentWebMarkupContainer sidebarColumn;

	public ManagePage(PageParameters params) {
		super(params);
		final Subject subject = SecurityUtils.getSubject();
		// FIXME: please implement hotel's Manage login page!
		subject.checkRole("sysadmin");
		
		add(new HtmlTag("html", getLocale(), true));
		add(new BootstrapBaseBehavior());
		add(new HeaderResponseContainer("footer-container", "footer-container"));
		add(new GrowlBehavior());
		
		// TODO: hotel's google analytics
//		add(new GoogleAnalyticsPanel("googleanalytics"));
		
		// SIDEBAR
		sidebarColumn = new TransparentWebMarkupContainer("sidebarColumn");
		add(sidebarColumn);
		sidebarBlocks = new RepeatingView("sidebarBlocks");
		sidebarColumn.add(sidebarBlocks);
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "assets/jquery-ui/jquery-ui-1.10.1.custom.min.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "css/bootstrap-reset.css")));
		response.render(CssHeaderItem.forReference(FontAwesomeResourceReference.INSTANCE));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "assets/jvector-map/jquery-jvectormap-1.2.2.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "css/clndr.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "assets/css3clock/css/style.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "assets/morris-chart/morris.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "assets/bootstrap-fileupload/bootstrap-fileupload.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "assets/bootstrap-wysihtml5/bootstrap-wysihtml5.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "assets/bootstrap-datepicker/css/datepicker.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "assets/bootstrap-timepicker/compiled/timepicker.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "assets/bootstrap-daterangepicker/daterangepicker-bs3.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "assets/bootstrap-datetimepicker/css/datetimepicker.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "assets/jquery-multi-select/css/multi-select.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "assets/jquery-tags-input/jquery.tagsinput.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "css/style.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(ManagePage.class, "css/style-responsive.css")));
		
		response.render(JavaScriptHeaderItem.forReference(jqueryUiJs));
		response.render(JavaScriptHeaderItem.forReference(accordionMenuJs));
		response.render(JavaScriptHeaderItem.forReference(scrollToJs));
		response.render(JavaScriptHeaderItem.forReference(niceScrollJs));
		response.render(JavaScriptHeaderItem.forReference(slimScroll));
		response.render(JavaScriptHeaderItem.forReference(skyconsJs));
		response.render(JavaScriptHeaderItem.forReference(JQueryEasing.instance()));
		response.render(JavaScriptHeaderItem.forReference(underscoreJs));
		response.render(JavaScriptHeaderItem.forReference(gaugeJs));
		response.render(JavaScriptHeaderItem.forReference(customSelectJs));
		response.render(JavaScriptHeaderItem.forReference(spinnerJs));
		response.render(JavaScriptHeaderItem.forReference(bootstrapFileUploadJs));
		response.render(JavaScriptHeaderItem.forReference(wysiHtml5Js));
		response.render(JavaScriptHeaderItem.forReference(bootstrapWysihtml5Js));
		response.render(JavaScriptHeaderItem.forReference(bootstrapDatePickerJs));
		response.render(JavaScriptHeaderItem.forReference(bootstrapDateTimePickerJs));
		response.render(JavaScriptHeaderItem.forReference(momentJs));
		response.render(JavaScriptHeaderItem.forReference(dateRangePickerJs));
		response.render(JavaScriptHeaderItem.forReference(bootstrapTImePickerJs));
		response.render(JavaScriptHeaderItem.forReference(jqueryMultiSelectJs));
		response.render(JavaScriptHeaderItem.forReference(jqueryQuickSearchJs));
		response.render(JavaScriptHeaderItem.forReference(bootstrapInputMaskJs));
		response.render(JavaScriptHeaderItem.forReference(jqueryTagsinputJs));
		response.render(JavaScriptHeaderItem.forReference(scriptsJs));
		response.render(JavaScriptHeaderItem.forReference(toggleInitJs));
		response.render(JavaScriptHeaderItem.forReference(advancedFormJs));
	}
	
}
