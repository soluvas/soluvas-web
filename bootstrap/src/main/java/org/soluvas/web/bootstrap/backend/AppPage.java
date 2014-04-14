package org.soluvas.web.bootstrap.backend;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.filter.HeaderResponseContainer;
import org.apache.wicket.markup.html.TransparentWebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.JavaScriptResourceReference;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.WebAddress;
import org.soluvas.web.bootstrap.AfterBootstrapCssResourceReference;
import org.soluvas.web.bootstrap.AfterBootstrapJavaScriptResourceReference;
import org.soluvas.web.bootstrap.AfterJQueryJavaScriptResourceReference;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.BootstrapBaseBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.html.HtmlTag;

/**
 * Only default styling.
 * @author rio
 */
public class AppPage extends WebPage {
	
	@SpringBean
	protected WebAddress webAddress;

	private static final JavaScriptResourceReference jqueryUiJs = 
			new AfterJQueryJavaScriptResourceReference(AppPage.class, "assets/jquery-ui/jquery-ui-1.10.1.custom.min.js");
	private static final JavaScriptResourceReference accordionMenuJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "js/accordion-menu/jquery.dcjqaccordion.2.7.js");
	private static final JavaScriptResourceReference scrollToJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "js/scrollTo/jquery.scrollTo.min.js");
	private static final JavaScriptResourceReference niceScrollJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "js/nicescroll/jquery.nicescroll.js");
	private static final JavaScriptResourceReference slimScroll = new AfterJQueryJavaScriptResourceReference(AppPage.class, "assets/jQuery-slimScroll-1.3.0/jquery.slimscroll.js");
	private static final JavaScriptResourceReference skyconsJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "assets/skycons/skycons.js");
	private static final JavaScriptResourceReference jqueryEasingJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "js/jquery.easing.min.js");
	private static final JavaScriptResourceReference underscoreJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "js/underscore-min.js");
	private static final JavaScriptResourceReference gaugeJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "assets/gauge/gauge.js");
	private static final JavaScriptResourceReference customSelectJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "js/custom-select/jquery.customSelect.min.js");
	private static final JavaScriptResourceReference bootstrapSwitchJs = new AfterBootstrapJavaScriptResourceReference(AppPage.class, "assets/bootstrap-switch-master/build/js/bootstrap-switch.js");
	private static final JavaScriptResourceReference spinnerJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "assets/fuelux/js/spinner.min.js");
	private static final JavaScriptResourceReference bootstrapFileUploadJs = new AfterBootstrapJavaScriptResourceReference(AppPage.class, "assets/bootstrap-fileupload/bootstrap-fileupload.js");
	private static final JavaScriptResourceReference wysiHtml5Js = new AfterJQueryJavaScriptResourceReference(AppPage.class, "assets/bootstrap-wysihtml5/wysihtml5-0.3.0.js");
	private static final JavaScriptResourceReference bootstrapWysihtml5Js = new AfterBootstrapJavaScriptResourceReference(AppPage.class, "assets/bootstrap-wysihtml5/bootstrap-wysihtml5.js");
	private static final JavaScriptResourceReference bootstrapDatePickerJs = new AfterBootstrapJavaScriptResourceReference(AppPage.class, "assets/bootstrap-datepicker/js/bootstrap-datepicker.js");
	private static final JavaScriptResourceReference bootstrapDateTimePickerJs = new AfterBootstrapJavaScriptResourceReference(AppPage.class, "assets/bootstrap-datetimepicker/js/bootstrap-datetimepicker.js");
	private static final JavaScriptResourceReference momentJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "assets/bootstrap-daterangepicker/moment.min.js");
	private static final JavaScriptResourceReference dateRangePickerJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "assets/bootstrap-daterangepicker/daterangepicker.js");
//	private static final JavaScriptResourceReference bootstrapColorPickerJs = new AfterBootstrapJavaScriptResourceReference(BackendPage.class, "assets/bootstrap-colorpicker/js/bootstrap-colorpicker.js");
	private static final JavaScriptResourceReference bootstrapTImePickerJs = new AfterBootstrapJavaScriptResourceReference(AppPage.class, "assets/bootstrap-timepicker/js/bootstrap-timepicker.js");
	private static final JavaScriptResourceReference jqueryMultiSelectJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "assets/jquery-multi-select/js/jquery.multi-select.js");
	private static final JavaScriptResourceReference jqueryQuickSearchJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "assets/jquery-multi-select/js/jquery.quicksearch.js");
	private static final JavaScriptResourceReference bootstrapInputMaskJs = new AfterBootstrapJavaScriptResourceReference(AppPage.class, "assets/bootstrap-inputmask/bootstrap-inputmask.min.js");
	private static final JavaScriptResourceReference jqueryTagsinputJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "assets/jquery-tags-input/jquery.tagsinput.js");
	private static final JavaScriptResourceReference scriptsJs = new AfterBootstrapJavaScriptResourceReference(AppPage.class, "js/scripts.js");
	private static final JavaScriptResourceReference toggleInitJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "js/toggle-button/toggle-init.js");
	private static final JavaScriptResourceReference advancedFormJs = new AfterJQueryJavaScriptResourceReference(AppPage.class, "js/advanced-form/advanced-form.js");
	
	private static final long serialVersionUID = 1L;
	
	protected final RepeatingView sidebarBlocks;
	protected TransparentWebMarkupContainer sidebarColumn;

	public AppPage(PageParameters params) {
		super(params);
		add(new HtmlTag("html", getLocale(), true));
		add(new BootstrapBaseBehavior());
		add(new HeaderResponseContainer("footer-container", "footer-container"));
		
		// SIDEBAR
		sidebarColumn = new TransparentWebMarkupContainer("sidebarColumn");
		add(sidebarColumn);
		sidebarBlocks = new RepeatingView("sidebarBlocks");
		sidebarColumn.add(sidebarBlocks);
	}

	@Override
	public void renderHead(IHeaderResponse response) {
		super.renderHead(response);
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/jquery-ui/jquery-ui-1.10.1.custom.min.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "css/bootstrap-reset.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/font-awesome/css/font-awesome.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/jvector-map/jquery-jvectormap-1.2.2.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "css/clndr.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/css3clock/css/style.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/morris-chart/morris.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/bootstrap-switch-master/build/css/bootstrap3/bootstrap-switch.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/bootstrap-fileupload/bootstrap-fileupload.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/bootstrap-wysihtml5/bootstrap-wysihtml5.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/bootstrap-datepicker/css/datepicker.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/bootstrap-timepicker/compiled/timepicker.css")));
//		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(BackendPage.class, "assets/bootstrap-colorpicker/css/colorpicker.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/bootstrap-daterangepicker/daterangepicker-bs3.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/bootstrap-datetimepicker/css/datetimepicker.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/jquery-multi-select/css/multi-select.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "assets/jquery-tags-input/jquery.tagsinput.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "css/style.css")));
		response.render(CssHeaderItem.forReference(new AfterBootstrapCssResourceReference(AppPage.class, "css/style-responsive.css")));
		
		response.render(JavaScriptHeaderItem.forReference(jqueryUiJs));
		response.render(JavaScriptHeaderItem.forReference(accordionMenuJs));
		response.render(JavaScriptHeaderItem.forReference(scrollToJs));
		response.render(JavaScriptHeaderItem.forReference(niceScrollJs));
		response.render(JavaScriptHeaderItem.forReference(slimScroll));
		response.render(JavaScriptHeaderItem.forReference(skyconsJs));
		response.render(JavaScriptHeaderItem.forReference(jqueryEasingJs));
		response.render(JavaScriptHeaderItem.forReference(underscoreJs));
		response.render(JavaScriptHeaderItem.forReference(gaugeJs));
		response.render(JavaScriptHeaderItem.forReference(customSelectJs));
		response.render(JavaScriptHeaderItem.forReference(bootstrapSwitchJs));
		response.render(JavaScriptHeaderItem.forReference(spinnerJs));
		response.render(JavaScriptHeaderItem.forReference(bootstrapFileUploadJs));
		response.render(JavaScriptHeaderItem.forReference(wysiHtml5Js));
		response.render(JavaScriptHeaderItem.forReference(bootstrapWysihtml5Js));
		response.render(JavaScriptHeaderItem.forReference(bootstrapDatePickerJs));
		response.render(JavaScriptHeaderItem.forReference(bootstrapDateTimePickerJs));
		response.render(JavaScriptHeaderItem.forReference(momentJs));
		response.render(JavaScriptHeaderItem.forReference(dateRangePickerJs));
//		response.render(JavaScriptHeaderItem.forReference(bootstrapColorPickerJs));
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
