package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import javax.inject.Inject;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.soluvas.commons.Person;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.image.ImageManager;

/**
 * @author mahendri
 *
 */
public class PeopleSelect2 extends BootstrapSelect2MultiChoice<Person> {
	
	@Inject
	private PersonRepository personRepo;
	@Inject
	private ImageManager imageMgr;

	public PeopleSelect2(String id, IModel<Collection<Person>> model) {
		super(id, model);
	}

	public PeopleSelect2(String id) {
		super(id);
	}
	
	@Override
	protected void onInitialize() {
		super.onInitialize();
		add(new AttributeAppender("class", new Model<>("input-xxlarge"), " "));
		setProvider(new PersonChoiceProvider(personRepo, imageMgr));
		getSettings().getAjax().setDelay(250);
		getSettings().setTemplateResult(
			"function(object) {" +
			"if (!object.id) return object.text;" +
			"var d1 = $('<img>').css({float: 'left'}).attr({src: object.photoUri, width: 50, height: 50});" +
			"var d2 = $('<img>').css({float: 'right', marginTop: '6px'}).attr('src', object.genderIconUri);" +
			"var thediv = $('<div>').css({marginLeft: '60px', marginRight: '20px', marginTop: '5px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
			"  .append(document.createTextNode(object.text)).append(' (ID : '+ object.customerId + ') <br>')" +
			"  .append($('<small>').css({color: '#666'}).text(object.location));" +
			"thediv.css({height: '45px'});" +
			"return [d1, d2, thediv];" +
			"}");
		getSettings().setTemplateSelection(
				"function(object) {" +
				"return [" +
				"  $('<img>').attr('src', object.genderIconUri)," +
				"  ' '," +
				"  document.createTextNode(object.text + '  (ID : ' +  object.customerId + ') ') ];" +
				"}");
	}

}
