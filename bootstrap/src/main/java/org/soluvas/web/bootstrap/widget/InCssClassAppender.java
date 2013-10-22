package org.soluvas.web.bootstrap.widget;

import javax.annotation.Nullable;

import org.apache.wicket.Page;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.AbstractReadOnlyModel;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;

/**
 * Bootstrap-enhances a component (usually {@link WebMarkupContainer} @{code li}) by appending
 * {@code class="in"} if at least one of the provided {@link BookmarkablePageLink} links to the current {@link Page}.
 * 
 * <p>Usage:
 * 
 * <pre>{@literal
 * <li wicket:id="guardianMenu" class="hasSubmenu">
 * 	<a wicket:id="toggle" data-toggle="collapse" class="glyphicons log_book collapsed" href="#menu_forms"><i></i><span>Guardian</span></a>
 * 	<ul wicket:id="ul" class="collapse" id="menu_forms">
 * 		<li wicket:id="checklists" class=""><a wicket:id="link" href="form_demo.html?lang=en"><span>Checklists</span></a></li>
 * 		<li wicket:id="checklistTemplates" class=""><a wicket:id="link" href="form_elements.html?lang=en"><span>Checklist Templates</span></a></li>
 * 	</ul>
 * </li>			
 * }</pre>
 * 
 * <pre>{@literal
 * final WebMarkupContainer guardianMenu = new WebMarkupContainer("guardianMenu");
 * final WebMarkupContainer guardianToggle = new WebMarkupContainer("toggle");
 * final WebMarkupContainer guardianUl = new WebMarkupContainer("ul");
 * final WebMarkupContainer checklistsItem = new WebMarkupContainer("checklists");
 * final BookmarkablePageLink<Page> checklistsLink = new BookmarkablePageLink<>("link", pageProvider.getGuardianPage());
 * checklistsItem.add(checklistsLink);
 * checklistsItem.add(new ActiveCssClassAppender(checklistsLink));
 * guardianUl.add(checklistsItem);
 * final WebMarkupContainer checklistTemplatesItem = new WebMarkupContainer("checklistTemplates");
 * final BookmarkablePageLink<Page> checklistTemplatesLink = new BookmarkablePageLink<>("link", pageProvider.getGuardianPage());
 * checklistTemplatesItem.add(checklistTemplatesLink);
 * checklistTemplatesItem.add(new ActiveCssClassAppender(checklistTemplatesLink));
 * guardianUl.add(checklistTemplatesItem);
 * guardianUl.add(new InCssClassAppender(checklistsLink, checklistTemplatesLink));
 * guardianMenu.add(guardianUl);
 * guardianToggle.add(new CollapsedCssClassRemover(checklistsLink, checklistTemplatesLink));
 * guardianMenu.add(guardianToggle);
 * guardianMenu.add(new ActiveCssClassAppender(checklistsLink, checklistTemplatesLink));
 * add(guardianMenu);
 * }</pre>
 * 
 * @author ceefour
 */
public class InCssClassAppender extends CssClassNameAppender {
	
	private static final long serialVersionUID = 1L;
	
	public InCssClassAppender(final BookmarkablePageLink<?>... links) {
		super(new AbstractReadOnlyModel<String>() {
			@Override @Nullable
			public String getObject() {
				for (BookmarkablePageLink<?> link : links) {
					if (link.linksTo(link.getPage())) {
						return "in";
					}
				}
				return null;
			}
		});
	}
	
}
