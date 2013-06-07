package org.soluvas.web.bootstrap.category;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.soluvas.category.impl.CategoryImpl;
import org.soluvas.web.site.EmfModel;

public class CategoryEmfModelTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void dontStealMyChildren() {
		final CategoryImpl parent = new CategoryImpl();
		parent.setName("Roti");
		
		final CategoryImpl child = new CategoryImpl();
		child.setName("Tawar");
		
		parent.getCategories().add(child);
		child.setParent(parent);

		assertThat(parent.getCategories(), hasSize(1));

		EmfModel<CategoryImpl> model1 = new EmfModel<>(parent);
		model1.detach();
		EmfModel<CategoryImpl> model2 = new EmfModel<>(child);
		model2.detach();
		
		assertThat(parent.getCategories(), hasSize(1));
	}

}
