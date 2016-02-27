package org.soluvas.web.bootstrap.widget;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.FluentIterable;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONWriter;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.joda.time.DateTimeZone;
import org.soluvas.data.domain.PageRequest;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;
import org.wicketstuff.select2.Select2Choice;

import javax.annotation.Nullable;
import java.util.Collection;

/**
 * {@link Select2Choice} UI component for Joda {@link DateTimeZone}.
 *
 * @author ceefour
 */
public class DateTimeZoneSelect2 extends InteractiveSelect2Choice<DateTimeZone> {

    private static final long serialVersionUID = 1L;

    private static class DateTimeZoneChoiceProvider extends ChoiceProvider<DateTimeZone> {

        @Override
        public String getDisplayValue(DateTimeZone choice) {
            return choice.getID();
        }

        @Override
        public String getIdValue(DateTimeZone choice) {
            return choice.getID();
        }

        @Override
        public void query(String term, int page, Response<DateTimeZone> response) {
            final PageRequest pageable = new PageRequest(page, 20);
            final String trimmedTerm = term.trim();
            final FluentIterable<DateTimeZone> filtered = FluentIterable.from(DateTimeZone.getAvailableIDs())
                    .filter(new Predicate<String>() {
                        @Override
                        public boolean apply(@Nullable String input) {
                            return StringUtils.containsIgnoreCase(input, trimmedTerm);
                        }
                    }).transform(new Function<String, DateTimeZone>() {
                        @Override
                        @Nullable
                        public DateTimeZone apply(@Nullable String input) {
                            return DateTimeZone.forID(input);
                        }
                    });
            response.addAll(filtered.skip((int) pageable.getOffset()).limit((int) pageable.getPageSize()).toList());
            response.setHasMore(!filtered.skip((int) ((page + 1) * pageable.getPageSize())).isEmpty());
        }

        @Override
        public Collection<DateTimeZone> toChoices(Collection<String> ids) {
            return FluentIterable.from(ids).transform(new Function<String, DateTimeZone>() {
                @Override
                @Nullable
                public DateTimeZone apply(@Nullable String input) {
                    return DateTimeZone.forID(input);
                }
            }).toSet();
//			// Workaround for Select2Choice "bug": https://github.com/ivaynberg/wicket-select2/issues/56
//			if (!ids.isEmpty() && found.isEmpty()) {
//				return Arrays.asList(new DateTimeZone[] { null });
//			} else {
//				return found;
//			}
        }

        @Override
        public void toJson(DateTimeZone choice, JSONWriter writer)
                throws JSONException {
            writer.key("id").value(choice.getID())
                    .key("text").value(choice.getID());
        }

        @Override
        public void detach() {
            super.detach();
        }

    }

    public DateTimeZoneSelect2(String id, IModel<DateTimeZone> model) {
        super(id, model, new DateTimeZoneChoiceProvider());
    }

    public DateTimeZoneSelect2(String id) {
        super(id, new Model<DateTimeZone>(), new DateTimeZoneChoiceProvider());
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new AttributeAppender("class", new Model<>("input-large"), " "));
        getSettings().getAjax().setDelay(250);
//		getSettings().setTemplateResult(
//			"function(object, container, query, escapeMarkup) {" +
//			"container.append($('<img>').css({float: 'left'}).attr({src: object.photoUri, width: 50, height: 50}));" +		
//			"container.append($('<img>').css({float: 'right', marginTop: '6px'}).attr('src', object.genderIconUri));" +
//			"var textMarkup = []; window.Select2.util.markMatch(object.text, query.term, textMarkup, escapeMarkup);" +
//			"var thediv = $('<div>').css({marginLeft: '60px', marginRight: '20px', marginTop: '5px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
//			"  .append(textMarkup.join('')).append(' (ID : '+ object.customerId + ') <br>')" +
//			"  .append($('<small>').css({color: '#666'}).text(object.location));" +
//			"container.append(thediv);" +
//			"thediv.css({height: '45px'});" +
//			"}");
//		getSettings().setTemplateSelection(
//				"function(object, container, query) {" +
//				"container.append($('<img>').attr('src', object.genderIconUri));" +
//				"container.append(' ');" +
//				"container.append(document.createTextNode(object.text + '  (ID : ' +  object.customerId + ') '));" +
//				"}");
    }

}
