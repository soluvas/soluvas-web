package org.soluvas.web.site;

import java.io.File;
import java.net.URL;
import java.util.Map;

import javax.annotation.Nullable;
import javax.servlet.ServletContext;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.MapPropertySource;

import com.google.common.collect.ImmutableMap;

/**
 * Provides the following properties:
 * 
 * <ol>
 * 	<li>{@code configDir}. the expanded webapp {@code /WEB-INF/classes/META-INF} (production) or
 * 		{@code ~/git/projectname/app/src/main/resources/META-INF} (development).</li>
 * </ol>
 * @todo Check 1. the servlet config, then 2. environment variable, then 3. either {@code $HOME} subfolder or the expanded webapp {@code /WEB-INF/classes/META-INF}.
 * 		As described in http://stackoverflow.com/a/18413224/122441.
 * 		Note: Only webapps have the luxury of expanded {@code /WEB-INF/classes/META-INF}, and even so it only
 * 		works on expanded webapps. So on production, the {@code $HOME} subfolder configuration is preferred.
 * 		The {@code /WEB-INF/classes/META-INF} approach is practical during development due to ease of copy-paste {@code .dev} template files,
 * 		although during development the actual path will never be {@code /WEB-INF/classes/META-INF} but {@code ~/git/projectname/app/src/main/resources/META-INF} instead.
 * 		Yet we probably should just auto-create the configurations in {@code $HOME} subfolder so initial setup is very easy.
 * @author ceefour
 * @see AppInitializer
 */
public class WebPropertySource extends MapPropertySource {
	
	private static final Logger log = LoggerFactory
			.getLogger(WebPropertySource.class);
	
	public WebPropertySource(String name, ServletContext servletContext) {
		super(name, getProperties(servletContext));
	}
	
	protected static Map<String, Object> getProperties(ServletContext servletContext) {
		final File configDir;
		if (servletContext != null) {
			final String webInf = servletContext.getRealPath("/WEB-INF"); //"/home/ceefour/git/quikdo-hub/hub.app/src/main/webapp/WEB-INF";
			final File metaInfInClasses = new File(webInf, "classes/META-INF");
			// If /WEB-INF/classes/META-INF not found, assume we're running inside Tomcat, inside Eclipse WTP
			configDir = metaInfInClasses.exists() ? metaInfInClasses :
					new File(new File(webInf).getParentFile().getParentFile(), "resources/META-INF");
		} else {
			// assume we're running inside Spring Boot, inside either IDEA, or command line using build classpath, or using packaged artifact
			// user.dir inside IDEA: /home/ceefour/git/bippo-commerce (not so helpful, furthermore it's customizable)
			// /META-INF/template.AppManifest.xmi works, e.g. file:/home/ceefour/git/bippo-commerce/springapp/target/classes/META-INF/template.AppManifest.xmi
			@Nullable
			URL someMetaInfUrl = WebPropertySource.class.getResource("/META-INF/template.AppManifest.xmi");
			if (someMetaInfUrl == null) {
				someMetaInfUrl = WebPropertySource.class.getResource("/META-INF/template.WebAddress.xmi");
			}
			Preconditions.checkState(someMetaInfUrl != null,
					"/META-INF/template.AppManifest.xmi or /META-INF/template.WebAddress.xmi must exist in order to detect configDir");
			Preconditions.checkState(!Strings.isNullOrEmpty(someMetaInfUrl.getFile()),
					"appManifest template '%s' must be in file system in order to detect configDir", someMetaInfUrl);
			configDir = new File(someMetaInfUrl.getFile()).getParentFile();
		}
		log.debug("Web configDir: {}", configDir);
		return ImmutableMap.<String, Object>of("configDir", configDir.getPath());
	}
	
}
