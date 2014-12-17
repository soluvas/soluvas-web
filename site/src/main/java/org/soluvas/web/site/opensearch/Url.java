package org.soluvas.web.site.opensearch;

import javax.annotation.Nullable;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * Created by ceefour on 17/12/14.
 */
public class Url {

    public static enum Rel {
        /**
         * (default) Represents a request for search results in the specified format.
         */
        results,
        /**
         * Represents a request for search suggestions in the specified format. See the OpenSearch Suggestions extension for further details.
         */
        suggestions,
        /**
         * Represents the canonical URL of this description document.
         */
        self,
        /**
         * Represents a request for a set of resources.
         */
        collection
    }

    /**
     * The MIME type of the resource being described.
     * Restrictions: The value must be a valid MIME type.
     * Requirements: This attribute is required.
     */
    private String type;
    /**
     * The URL template to be processed according to the OpenSearch URL template syntax.
     * Requirements: This attribute is required.
     */
    private String template;
    /**
     * The role of the resource being described in relation to the description document.
     * Restrictions: Contains a space-delimited list of valid rel value tokens. See the Url rel values specification for allowed rel values.
     * Default: "results"
     * Requirements: This attribute is optional.
     */
    private Rel rel;
    /**
     * The index number of the first search result.
     * Restrictions: The value must be an integer.
     * Default: "1"
     * Requirements: This attribute is optional.
     *
     */
    private Integer indexOffset;
    /**
     * The page number of the first set of search results.
     * Restrictions: The value must be an integer.
     * Default: "1"
     * Requirements: This attribute is optional.
     */
    private Integer pageOffset;

    public Url() {
    }

    public Url(String type, String template) {
        this.type = type;
        this.template = template;
    }

    public Url(String type, String template, Rel rel) {
        this.type = type;
        this.template = template;
        this.rel = rel;
    }

    public Url(String type, String template, Rel rel, Integer indexOffset, Integer pageOffset) {
        this.type = type;
        this.template = template;
        this.rel = rel;
        this.indexOffset = indexOffset;
        this.pageOffset = pageOffset;
    }

    @XmlAttribute
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @XmlAttribute
    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    @XmlAttribute @Nullable
    public Rel getRel() {
        return rel;
    }

    public void setRel(Rel rel) {
        this.rel = rel;
    }

    @XmlAttribute @Nullable
    public Integer getIndexOffset() {
        return indexOffset;
    }

    public void setIndexOffset(Integer indexOffset) {
        this.indexOffset = indexOffset;
    }

    @XmlAttribute @Nullable
    public Integer getPageOffset() {
        return pageOffset;
    }

    public void setPageOffset(Integer pageOffset) {
        this.pageOffset = pageOffset;
    }
}
