package org.soluvas.web.bootstrap;

import java.io.IOException;

import javax.inject.Inject;

import org.apache.commons.io.FileUtils;
import org.apache.wicket.util.file.File;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.commons.DataFolder;
import org.soluvas.data.EntityLookup;
import org.soluvas.web.bootstrap.annotation.ContentRelated;
import org.soluvas.web.site.SiteException;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * Looks up HTML content from "${dataFolder}/common/content/${slug}.html".
 * Used by {@link ContentPage}.
 * It can be used to load:
 * <ol>
 * <li>Page content, e.g. <b>about</b>.html.</li>
 * <li>Sidebar content, e.g. <b>about.sidebar</b>.html</li>
 * </ol>
 * To load sidebar, use e.g. "about.sidebar" as slug.
 * @author rudi
 */
@Service("contentLookup") @Lazy @ContentRelated
public class CommonFolderContentLookup implements EntityLookup<String, String> {
	
	private static final Logger log = LoggerFactory
			.getLogger(CommonFolderContentLookup.class);
	
	@Inject @DataFolder
	private String dataFolder;

	@SuppressWarnings("unchecked") @Override
	public <S extends String> S findOne(String id) {
		final File file = new File(dataFolder + "/common/content", id + ".html");
		log.trace("Reading {}", file);
		String content;
		try {
			content = FileUtils.readFileToString(file);
		} catch (IOException e) {
			throw new SiteException(e, "Cannot read %s", file);
		}
		log.debug("Read {} ({} bytes) in {}", file.getName(), content.length(), file.getParent());
		return (S) content;
	}

}
