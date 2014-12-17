package org.soluvas.web.site.opensearch;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ceefour on 17/12/14.
 */
@XmlRootElement(name = "OpenSearchDescription", namespace = "http://a9.com/-/spec/opensearch/1.1/")
public class OpenSearchDescription {

    private String shortName;
    private String longName;
    private String description;
    private String tags;
    private String contact;
    private List<Url> urls = new ArrayList<>();
    private List<Image> images = new ArrayList<>();
    private List<String> inputEncodings = new ArrayList<>();
    private List<String> outputEncodings = new ArrayList<>();
    private String developer;
    private String searchForm;

    @XmlElement(name = "ShortName")
    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @XmlElement(name = "LongName")
    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    @XmlElement(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Contains a set of words that are used as keywords to identify and categorize this search content. Tags must be a single word and are delimited by the space character (' ').
     *
     * Parent: OpenSearchDescription
     * Restrictions: The value must contain 256 or fewer characters of plain text. The value must not contain HTML or other markup.
     * Requirements: This element may appear zero or one time.
     * Example:
     *
     * <pre>
     * &lt;Tags>example web&lt;/Tags>
     * </pre>
     */
    @XmlElement(name = "Tags")
    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * Contains an email address at which the maintainer of the description document can be reached.
     *
     * Parent: OpenSearchDescription
     * Restrictions: The value must conform to the requirements of Section 3.4.1 "Addr-spec specification" in RFC 2822.
     * Requirements: This element may appear zero or one time.
     * Example:
     *
     * <pre>
     * &lt;Contact>admin&commat;example.com&lt;/Contact>
     * </pre>
     */
    @XmlElement(name = "Contact")
    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @XmlElement(name = "Url")
    public List<Url> getUrls() {
        return urls;
    }

    @XmlElement(name = "Image")
    public List<Image> getImages() {
        return images;
    }

    @XmlElement(name = "InputEncoding")
    public List<String> getInputEncodings() {
        return inputEncodings;
    }

    @XmlElement(name = "OutputEncoding")
    public List<String> getOutputEncodings() {
        return outputEncodings;
    }

    @XmlElement(name = "Developer")
    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    @XmlElement(name = "SearchForm", namespace = "http://www.mozilla.org/2006/browser/search/")
    public String getSearchForm() {
        return searchForm;
    }

    public void setSearchForm(String searchForm) {
        this.searchForm = searchForm;
    }
}
