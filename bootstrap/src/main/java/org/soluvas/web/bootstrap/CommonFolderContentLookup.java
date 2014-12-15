package org.soluvas.web.bootstrap;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.regex.Pattern;

import com.google.common.collect.ImmutableSet;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.StatusMask;
import org.soluvas.data.push.RepositoryException;
import org.soluvas.web.bootstrap.annotation.ContentRelated;
import org.soluvas.web.bootstrap.content.ContentPanel;
import org.soluvas.web.bootstrap.content.ContentRepository;
import org.soluvas.web.site.SiteException;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

/**
 * Looks up HTML content from "${dataFolder}/common/content/${slug}.html".
 * Used by {@link ContentPanel}.
 * 
 * <p>It can be used to load:
 * 
 * <ol>
 * <li>Page content, e.g. <b>about</b>.html.</li>
 * <li>Sidebar content, e.g. <b>about.sidebar</b>.html</li>
 * </ol>
 * 
 * <p>To load sidebar, use e.g. "about.sidebar" as slug.
 * 
 * @author rudi
 * @see ContentRelated
 * @see ContentNode
 * @see ContentPanel
 */
public class CommonFolderContentLookup implements ContentRepository {
	
	private static final Logger log = LoggerFactory
			.getLogger(CommonFolderContentLookup.class);
	
	private final File dataDir;
	private static final Pattern contentPagePattern = Pattern.compile("[a-z][^.]*");
	
	public CommonFolderContentLookup(File dataDir) {
		super();
		this.dataDir = dataDir;
	}
	
	public File getDataDir() {
		return dataDir;
	}

	@SuppressWarnings("unchecked") @Override
	public String findOne(String id) {
		final File file = new File(dataDir, "common/content/" + id + ".html");
		log.trace("Reading {}", file);
		String content;
		try {
			content = FileUtils.readFileToString(file);
		} catch (IOException e) {
			throw new SiteException(e, "Cannot read %s", file);
		}
		log.debug("Read {} ({} bytes) in {}", file.getName(), content.length(), file.getParent());
		return content;
	}

	@Override
	public String toString() {
		return "CommonFolderContentLookup [dataDir=" + dataDir + "]";
	}

	@Override
	public ImmutableSet<String> findAllSlugPathsByStatus(StatusMask statusMask) {
		final String pattern = "file:" + dataDir + "/common/content/*.html";
		final HashSet<String> slugs = new HashSet<>();
		try {
			final Resource[] resources = new PathMatchingResourcePatternResolver().getResources(pattern);
			for (final Resource res : resources) {
				final String baseName = FilenameUtils.getBaseName(res.getFilename());
				if (contentPagePattern.matcher(baseName).matches()) {
					slugs.add(baseName);
				}
			}
			return ImmutableSet.copyOf(slugs);
		} catch (IOException e) {
			throw new RepositoryException(e, "Cannot list files using '%s'", pattern);
		}
	}

}
