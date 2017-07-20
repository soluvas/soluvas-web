package org.soluvas.web.site.facebook;

import com.google.common.collect.ImmutableList;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * {@code <div wicket:id="fbPagePlugin"></div>}
 *
 * Requirement: Facebook SDK script for the parent {@link org.apache.wicket.markup.html.WebPage} (after {@code <body>})
 *
 * Created by ceefour on 18/06/2016.
 */
public class FacebookPagePlugin extends WebComponent {

    private List<FacebookPagePluginTab> tabs = new ArrayList<>(ImmutableList.of(FacebookPagePluginTab.TIMELINE));
    private boolean smallHeader = false;
    private boolean adaptContainerWidth = true;
    private boolean hideCover = false;
    private boolean showFacepile = true;

    /**
     *
     * @param id
     * @param pageUri e.g. {@code https://www.facebook.com/satukancinta/}
     */
    public FacebookPagePlugin(String id, String pageUri) {
        super(id, new Model<>(pageUri));
    }

    public FacebookPagePlugin(String id, IModel<String> model) {
        super(id, model);
    }

    @Override
    protected void onComponentTag(ComponentTag tag) {
        super.onComponentTag(tag);
        tag.append("class", "fb-page", " ");
        tag.put("data-href", getDefaultModelObjectAsString());
        tag.put("data-tabs",
                tabs.stream().map(Object::toString).map(String::toLowerCase).collect(Collectors.joining(",")));
        tag.put("data-small-header", Boolean.toString(smallHeader));
        tag.put("data-adapt-container-width", Boolean.toString(adaptContainerWidth));
        tag.put("data-hide-cover", Boolean.toString(hideCover));
        tag.put("data-show-facepile", Boolean.toString(showFacepile));
    }

    @Override
    public void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {
        super.onComponentTagBody(markupStream, openTag);
        getWebResponse().write("<blockquote cite=\"" + getDefaultModelObject() +
                "\" class=\"fb-xfbml-parse-ignore\"><a href=" + getDefaultModelObject() + ">Facebook page</a></blockquote>");
    }

    public List<FacebookPagePluginTab> getTabs() {
        return tabs;
    }

    public void setTabs(List<FacebookPagePluginTab> tabs) {
        this.tabs = tabs;
    }

    public FacebookPagePlugin setTabs(FacebookPagePluginTab... tabs) {
        this.tabs = new ArrayList<>(ImmutableList.copyOf(tabs));
        return this;
    }

    public boolean isSmallHeader() {
        return smallHeader;
    }

    public void setSmallHeader(boolean smallHeader) {
        this.smallHeader = smallHeader;
    }

    public boolean isAdaptContainerWidth() {
        return adaptContainerWidth;
    }

    public void setAdaptContainerWidth(boolean adaptContainerWidth) {
        this.adaptContainerWidth = adaptContainerWidth;
    }

    public boolean isHideCover() {
        return hideCover;
    }

    public void setHideCover(boolean hideCover) {
        this.hideCover = hideCover;
    }

    public boolean isShowFacepile() {
        return showFacepile;
    }

    public void setShowFacepile(boolean showFacepile) {
        this.showFacepile = showFacepile;
    }
}
