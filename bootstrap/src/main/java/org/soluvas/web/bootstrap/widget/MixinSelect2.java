package org.soluvas.web.bootstrap.widget;

import java.util.Collection;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.json.JSONException;
import org.json.JSONWriter;
import org.soluvas.data.Mixin;
import org.soluvas.data.MixinManager;
import org.soluvas.web.site.EmfModel;

import com.vaynberg.wicket.select2.ChoiceProvider;
import com.vaynberg.wicket.select2.Response;
import com.vaynberg.wicket.select2.Select2Choice;

/**
 * @author rudi
 *
 */
public class MixinSelect2 extends Select2Choice<Mixin> {

	private static final long serialVersionUID = 1L;
	
	private static class MixinChoiceProvider extends ChoiceProvider<Mixin> {
		@SpringBean
		private MixinManager mixinMgr;

		public MixinChoiceProvider() {
			super();
			Injector.get().inject(this);
		}

		@Override
		public void query(String term, int page, Response<Mixin> response) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void toJson(Mixin choice, JSONWriter writer)
				throws JSONException {
			// TODO Auto-generated method stub
			
		}

		@Override
		public Collection<Mixin> toChoices(Collection<String> ids) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	public MixinSelect2(String id) {
		super(id, new EmfModel<Mixin>(), new MixinChoiceProvider());
	}
	
	public MixinSelect2(String id, IModel<Mixin> mixinModel) {
		super(id, mixinModel, new MixinChoiceProvider());
	}

	
	

}
