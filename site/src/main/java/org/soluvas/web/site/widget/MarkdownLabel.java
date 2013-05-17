package org.soluvas.web.site.widget;

import java.io.Serializable;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.pegdown.Extensions;
import org.pegdown.PegDownProcessor;

import com.google.common.base.Strings;

/**
 * Prettifies text using Markdown markup via {@link PegDownProcessor}.
 * 
 * <p><a href="https://github.com/sirthias/pegdown">pegdown on github</a>
 * 
 * <p>Note, there are some eccentricies with dependencies:
 * 
 * <pre>{@literal
 * <dependency>
 * 	<groupId>cglib</groupId>
 * 	<artifactId>cglib-nodep</artifactId>
 * 	<version>2.2.2</version>
 * 	<scope>compile</scope>
 * </dependency>
 * 
 * <dependency>
 * 	<groupId>org.apache.wicket</groupId>
 * 	<artifactId>wicket-spring</artifactId>
 * 	<exclusions>
 * 		<exclusion>
 * 			<artifactId>asm</artifactId>
 * 			<groupId>asm</groupId>
 * 		</exclusion>
 * 		<exclusion>
 * 			<artifactId>cglib</artifactId>
 * 			<groupId>cglib</groupId>
 * 		</exclusion>
 * 	</exclusions>
 * </dependency>
 * }</pre>
 * 
 * Otherwise you'll get <a href="https://github.com/sirthias/pegdown/issues/66">java.lang.IncompatibleClassChangeError</a>
 * 
 * @author ceefour
 */
public class MarkdownLabel extends Label {

	private static final long serialVersionUID = 1L;
	
	protected static final ThreadLocal<PegDownProcessor> localProcessor = new ThreadLocal<PegDownProcessor>() {
		@Override
		protected PegDownProcessor initialValue() {
			return new PegDownProcessor(Extensions.ALL);
		}
	};
	
	/**
	 * @param id
	 */
	public MarkdownLabel(String id) {
		super(id);
	}

	/**
	 * @param id
	 * @param label
	 */
	public MarkdownLabel(String id, String label) {
		super(id, label);
	}

	/**
	 * @param id
	 * @param label
	 */
	public MarkdownLabel(String id, Serializable label) {
		super(id, label);
	}

	/**
	 * @param id
	 * @param model
	 */
	public MarkdownLabel(String id, IModel<?> model) {
		super(id, model);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
	}
	
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag) {
		final String modelStr = Strings.nullToEmpty((String) getDefaultModelObject());
		final String html = localProcessor.get().markdownToHtml(modelStr);
		replaceComponentTagBody(markupStream, openTag, html);
	}

}
