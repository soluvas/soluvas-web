package org.soluvas.web.bootstrap;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.EntityLookup;
import org.soluvas.web.bootstrap.annotation.ContentRelated;
import org.soluvas.web.site.SiteException;

/**
 * Looks up HTML content from "${dataFolder}/common/content/${slug}.html".
 * Used by {@link ContentPanel}.
 * It can be used to load:
 * <ol>
 * <li>Page content, e.g. <b>about</b>.html.</li>
 * <li>Sidebar content, e.g. <b>about.sidebar</b>.html</li>
 * </ol>
 * To load sidebar, use e.g. "about.sidebar" as slug.
 * @author rudi
 * @see ContentRelated
 */
public class CommonFolderContentLookup implements EntityLookup<String, String> {
	
	private static final Logger log = LoggerFactory
			.getLogger(CommonFolderContentLookup.class);
	
	private final File dataDir;
	
	public CommonFolderContentLookup(File dataDir) {
		super();
		this.dataDir = dataDir;
	}

	@SuppressWarnings("unchecked") @Override
	public <S extends String> S findOne(String id) {
		final File file = new File(dataDir, "common/content/" + id + ".html");
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
