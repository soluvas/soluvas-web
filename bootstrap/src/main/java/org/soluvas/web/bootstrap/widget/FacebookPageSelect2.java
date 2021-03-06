package org.soluvas.web.bootstrap.widget;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.restfb.types.Account;
import org.apache.commons.lang3.StringUtils;
import org.apache.wicket.ajax.json.JSONException;
import org.apache.wicket.ajax.json.JSONStringer;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;
import org.wicketstuff.select2.Select2Choice;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A {@link Select2Choice} for Facebook {@link Account} (managed page),
 * displaying the {@link Account#getId()}, {@link Account#getName()},
 * {@link Account#getCategory()}, plus the page profile picture.
 * @author ceefour
 */
public class FacebookPageSelect2 extends BootstrapSelect2Choice<Account> {

	public static class AccountChoiceProvider extends ChoiceProvider<Account> {

		private final IModel<List<Account>> accountsModel;
		
		public AccountChoiceProvider(IModel<List<Account>> accountsModel) {
			super();
			this.accountsModel = accountsModel;
		}

		@Override
		public String getDisplayValue(Account choice) {
			return choice.getName();
		}

		@Override
		public String getIdValue(Account choice) {
			return choice.getId();
		}

		@Override
		public void query(String term, int page, Response<Account> response) {
			for (Account acc : accountsModel.getObject()) {
				if (StringUtils.containsIgnoreCase(acc.getName(), term) ||
						StringUtils.containsIgnoreCase(acc.getId(), term) ||
						StringUtils.containsIgnoreCase(acc.getCategory(), term)) { 
					response.add(acc);
				}
			}
		}

		@Override
		public void toJson(Account choice, JSONStringer writer)
				throws JSONException {
			writer.key("id").value(choice.getId())
				.key("text").value(choice.getName())
				.key("photoUri").value("http://graph.facebook.com/" + choice.getId() + "/picture") // 50×50px
				.key("category").value(choice.getCategory());
		}

		@Override
		public Collection<Account> toChoices(Collection<String> ids) {
			final List<Account> result = new ArrayList<>();
			if (ids != null) {
				for (final String id : ids) {
					Optional<Account> found = Iterables.tryFind(accountsModel.getObject(), new Predicate<Account>() {
						@Override
						public boolean apply(@Nullable Account input) {
							return id.equals(input.getId());
						}
					});
					if (found.isPresent()) {
						result.add(found.get());
					}
				}
			}
			return result;
		}
		
	}

	public FacebookPageSelect2(String id, IModel<Account> model,
			ChoiceProvider<Account> provider) {
		super(id, model, provider);
	}

	public FacebookPageSelect2(String id, IModel<Account> model) {
		super(id, model);
	}

	public FacebookPageSelect2(String id, IModel<Account> model, IModel<List<Account>> accountsModel) {
		super(id, model, new AccountChoiceProvider(accountsModel));
	}

	public FacebookPageSelect2(String id) {
		super(id);
	}

	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xxlarge"), " "));
//		setProvider(new PersonChoiceProvider(personLdapRepo, imageMgr));
		getSettings().getAjax().setDelay(250);
		getSettings().setTemplateResult(
			"function(object) {" +
			"if (!object.id) return object.text;" +
			"var d1 = $('<img>').css({float: 'left'}).attr({src: object.photoUri, width: 50, height: 50});" +
			"var thediv = $('<div>').css({marginLeft: '60px', marginRight: '20px', marginTop: '5px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
			"  .append(document.createTextNode(object.text)).append(' ').append($('<span class=\"label\">').text(object.id)).append('<br>')" +
			"  .append($('<small>').css({color: '#666'}).append(document.createTextNode(object.category));" +
			"thediv.css({height: '45px'});" +
			"return [d1, thediv];" +
			"}");
		getSettings().setTemplateSelection(
				"function(object) {" +
				"return document.createTextNode(object.text + ' · #' +  object.id);" +
				"}");
	}

}
