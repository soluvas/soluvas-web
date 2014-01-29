package org.soluvas.web.bootstrap.widget;

import java.text.NumberFormat;

import javax.annotation.Nullable;

import org.apache.wicket.Component;
import org.apache.wicket.extensions.breadcrumb.BreadCrumbLink;
import org.apache.wicket.extensions.breadcrumb.IBreadCrumbModel;
import org.apache.wicket.extensions.breadcrumb.IBreadCrumbParticipant;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;

import de.agilecoders.wicket.core.markup.html.bootstrap.button.Activatable;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.IconType;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.ImmutableNavbarComponent;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;

/**
 * Simplified BreadCrumb Link with {@link IconType} support.
 * To be used with Bootstrap {@link Navbar} and {@link ImmutableNavbarComponent}.
 * @author ceefour
 */
public abstract class NavbarBreadCrumbLink<P extends IBreadCrumbParticipant> extends BreadCrumbLink implements Activatable  {
	
	private static final long serialVersionUID = 1L;
	private final IBreadCrumbModel breadCrumbModel;
	private final IBreadCrumbParticipant root;
	private final P participant;
	@Nullable
	private IconType iconType = null;
	private Class<P> participantClass;
	private IModel<?> badgeModel = new Model<>();

	/**
	 * @param label
	 * @param breadCrumbModel
	 * @param root When clicked, will activate this participant first before activating the target participant. 
	 */
	public NavbarBreadCrumbLink(IModel<String> label, Class<P> participantClass, P participant, IBreadCrumbModel breadCrumbModel, IBreadCrumbParticipant root) {
		super(Navbar.componentId(), breadCrumbModel);
		this.participantClass = participantClass;
		this.participant = participant;
		this.breadCrumbModel = breadCrumbModel;
		this.root = root;
		setBody(label);
	}
	
	public NavbarBreadCrumbLink(IModel<String> label, Class<P> participantClass, P participant, IBreadCrumbModel breadCrumbModel) {
		this(label, participantClass, participant, breadCrumbModel, null);
	}
	
	@Override
	public void onComponentTagBody(MarkupStream markupStream,
			ComponentTag openTag) {
		if (iconType != null) {
			getResponse().write("<i class=\"" + iconType.cssClassName() + "\"></i> ");
		}
		super.onComponentTagBody(markupStream, openTag);
		final Object badge = badgeModel.getObject();
		if (badge != null && !"".equals(badge)) {
			final String badgeStr;
			if (badge instanceof Number) {
				badgeStr = NumberFormat.getNumberInstance(getLocale()).format(badge);
			} else {
				badgeStr = badge.toString();
			}
			getResponse().write(" <span class=\"badge\">" + Strings.escapeMarkup(badgeStr) + "</badge>");
		}
	}
	
	public IconType getIconType() {
		return iconType;
	}
	
	public NavbarBreadCrumbLink<P> setIconType(IconType iconType) {
		this.iconType = iconType;
		return this;
	}
	
	public IModel<?> getBadgeModel() {
		return badgeModel;
	}
	
	public NavbarBreadCrumbLink<P> setBadgeModel(IModel<?> badgeModel) {
		this.badgeModel = badgeModel;
		return this;
	}
	
	@Override
	protected void onComponentTag(ComponentTag tag) {
		tag.setName("a");
		super.onComponentTag(tag);
	}
	
	@Override
	public void onClick() {
		if (root != null) {
			breadCrumbModel.setActive(root);
		}
		super.onClick();
	}

//	@Override
//	protected IBreadCrumbParticipant getParticipant(String componentId) {
//		return participant;
//	}

	@Override
	public boolean isActive(Component item) {
		return participantClass.isAssignableFrom(breadCrumbModel.getActive().getClass());
	}
	
	@Override
	protected abstract P getParticipant(String componentId);
	
	@Override
	protected void onDetach() {
		badgeModel.detach();
		super.onDetach();
	}

}
