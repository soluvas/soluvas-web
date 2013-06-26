package org.soluvas.web.site;

import static org.junit.Assert.assertNotNull;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.AppManifest;

public class EmfMapModelTest {

	private static final Logger log = LoggerFactory
			.getLogger(EmfMapModelTest.class);
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void emptyMap() {
		final EmfMapModel<String, AppManifest> emfMapModel = new EmfMapModel<>(new HashMap<String, AppManifest>());
		log.debug("Map was {}", emfMapModel.getObject());
		emfMapModel.detach();
		final Map<String, AppManifest> attachedMap = emfMapModel.getObject();
		log.debug("Map is now {}", emfMapModel.getObject());
		assertNotNull(attachedMap);
	}

	@Test
	public void emptyMapWithoutGetObjectBeforeDetach() {
		final EmfMapModel<String, AppManifest> emfMapModel = new EmfMapModel<>(new HashMap<String, AppManifest>());
		emfMapModel.detach();
		final Map<String, AppManifest> attachedMap = emfMapModel.getObject();
		log.debug("Map is now {}", emfMapModel.getObject());
		assertNotNull(attachedMap);
	}

}
