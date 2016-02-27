package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.soluvas.commons.Person;
import org.soluvas.data.person.PersonRepository;
import org.soluvas.image.ImageManager;

/**
 * @author mahendri
 *
 */
public class PeopleSelect2 extends InteractiveSelect2MultiChoice<Person> {
	
	private static final long serialVersionUID = 1L;
	
	@SpringBean
	private PersonRepository personRepo;
	@SpringBean
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
			"function(object, container, query, escapeMarkup) {" +
			"container.append($('<img>').css({float: 'left'}).attr({src: object.photoUri, width: 50, height: 50}));" +		
			"container.append($('<img>').css({float: 'right', marginTop: '6px'}).attr('src', object.genderIconUri));" +
			"var textMarkup = []; window.Select2.util.markMatch(object.text, query.term, textMarkup, escapeMarkup);" +
			"var thediv = $('<div>').css({marginLeft: '60px', marginRight: '20px', marginTop: '5px', textOverflow: 'ellipsis', overflow: 'hidden', whiteSpace: 'nowrap'})" +
			"  .append(textMarkup.join('')).append(' (ID : '+ object.customerId + ') <br>')" +
			"  .append($('<small>').css({color: '#666'}).text(object.location));" +
			"container.append(thediv);" +
			"thediv.css({height: '45px'});" +
			"}");
		getSettings().setTemplateSelection(
				"function(object, container, query) {" +
				"container.append($('<img>').attr('src', object.genderIconUri));" +
				"container.append(' ');" +
				"container.append(document.createTextNode(object.text + '  (ID : ' +  object.customerId + ') '));" +
				"}");
	}

}
