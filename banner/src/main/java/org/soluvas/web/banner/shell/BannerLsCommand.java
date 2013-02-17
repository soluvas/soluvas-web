package org.soluvas.web.banner.shell;

import static org.fusesource.jansi.Ansi.ansi;

import org.apache.commons.lang3.StringUtils;
import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.eclipse.emf.common.util.EList;
import org.osgi.framework.ServiceReference;
import org.soluvas.web.banner.Banner;
import org.soluvas.web.banner.BannerCatalog;

import com.google.common.base.Strings;

/**
 * List registered {@link Banner}s.
 * @author ceefour
 */
@Command(scope="banner", name="ls", description="List registered Banners.")
public class BannerLsCommand extends OsgiCommandSupport {
	
	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		final ServiceReference<BannerCatalog> bannerCatalogRef = bundleContext.getServiceReference(BannerCatalog.class);
		final BannerCatalog bannerCatalog = getService(BannerCatalog.class, bannerCatalogRef);
		final EList<Banner> banners = bannerCatalog.getBanners();
		System.out.println(ansi().render("@|negative_on %3s|%-20s|%-25s|%-25s|%-20s|@",
				"№", "Title", "Image", "Link", "Bundle"));
		int i = 0;
		for (final Banner banner : banners) {
			final String title = StringUtils.left(banner.getTitle(), 20);
			final String imageUri = StringUtils.left(Strings.nullToEmpty(banner.getImageUri()).replace("http://",  ""), 24);
			final String linkUri = StringUtils.left(Strings.nullToEmpty(banner.getLinkUri()).replace("http://",  ""), 25);
			final String baseSymbol;
			switch (banner.getImageBase()) {
			case ABSOLUTE:
				baseSymbol = "@|bold,blue ▶|@";
				break;
			case IMAGES:
				baseSymbol = "@|bold,green ⓘ|@";
				break;
			default:
				baseSymbol = "@|bold,red ?|@";
			}
			// FIXME: Resource aware!
			final String bundleAnsi = "";//NameUtils.shortenBundleAnsi(banner.getBundle(), 20);
			System.out.println(ansi().render("@|bold,black %3d||@%-20s@|bold,black ||@" + baseSymbol + "%-24s@|bold,black ||@%-25s@|bold,black ||@" + bundleAnsi,
				++i, title, imageUri, linkUri ));
		}
		System.out.println(ansi().render("@|bold %d|@ banners", i));
		return null;
	}

}
