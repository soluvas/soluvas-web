package org.soluvas.web.bootstrap.widget;

import com.google.common.base.Function;
import com.google.common.collect.FluentIterable;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONWriter;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.injection.Injector;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.data.Mixin;
import org.soluvas.data.MixinManager;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.web.site.EmfModel;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

import javax.annotation.Nullable;
import java.util.Collection;

/**
 * @author rudi
 */
public class MixinSelect2 extends InteractiveSelect2Choice<Mixin> {

    private static class MixinChoiceProvider extends ChoiceProvider<Mixin> {
        @SpringBean
        private MixinManager mixinMgr;

        public MixinChoiceProvider() {
            super();
            Injector.get().inject(this);
        }

        @Override
        public String getDisplayValue(Mixin object) {
            return object.getDisplayName();
        }

        @Override
        public String getIdValue(Mixin object) {
            return object.getQName();
        }

        @Override
        public void query(String term, int page, Response<Mixin> response) {
            final Page<Mixin> pagedMixin = mixinMgr.findMixin(term.trim(), new PageRequest(page, 20));
            response.addAll(pagedMixin.getContent());
            response.setHasMore(!pagedMixin.hasNextPage());
        }

        @Override
        protected void toJson(Mixin choice, JSONWriter writer) throws JSONException {
            writer.key("id").value(choice.getQName())
                    .key("text").value(choice.getDisplayName())
                    .key("name").value(choice.getName());
        }

        @Override
        public Collection<Mixin> toChoices(Collection<String> ids) {
            return FluentIterable.from(ids).transform(new Function<String, Mixin>() {
                @Override
                @Nullable
                public Mixin apply(@Nullable String input) {
                    return mixinMgr.findMixin(input);
                }
            }).toList();
        }

        @Override
        public void detach() {
            super.detach();
        }

    }

    public MixinSelect2(String id) {
        super(id, new EmfModel<Mixin>(), new MixinChoiceProvider());
    }

    public MixinSelect2(String id, IModel<Mixin> mixinModel) {
        super(id, mixinModel, new MixinChoiceProvider());
    }

    @Override
    public void renderHead(IHeaderResponse response) {
        super.renderHead(response);
    }

    @Override
    protected void onInitialize() {
        super.onInitialize();
        add(new AttributeAppender("class", new Model<>("col-sm-4")));
        getSettings().getAjax().setDelay(250);
        getSettings().setTemplateResult(
                "function(object, container, query, escapeMarkup) {" +
                        "var textMarkup = []; window.Select2.util.markMatch(object.text, query.term, textMarkup, escapeMarkup);" +
                        "var thediv = $('<div>').css({marginLeft: '24px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
                        "  .append(textMarkup.join('')).append(' ').append($('<small>').text(object.name));" +
                        "container.append(thediv);" +
                        "}");
    }


}
