/**
 * 
 */
package org.soluvas.web.site;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;

/**
 * @author ceefour
 *
 */
public class BotUtils {

	private static final ImmutableSet<String> dummyBots = ImmutableSet.of("appie", "architext",
			"jeeves", "bjaaland", "ferret", "gulliver", "harvest", "htdig",
			"linkwalker", "lycos_", "moget", "muscatferret", "myweb", "nomad",
			"scooter", "yahoo!", "slurp", "weblayers",
			"antibot", "bruinbot", "digout4u", "echo!", "ia_archiver",
			"jennybot", "mercator", "netcraft", "msnbot", "petersnews",
			"unlost_web_crawler", "voila", "webbase", "webcollage", "cfetch",
			"zyborg", "wisenutbot", "robot", "crawl", "spider",
			// Mozilla/5.0 (compatible; Google-StructuredDataTestingTool; +http://www.google.com/webmasters/tools/richsnippets)
			"richsnippets",
			// Google (+https://developers.google.com/+/web/snippet/)
			"+/web/snippet",
			// facebookexternalhit/1.1 (+http(s)://www.facebook.com/externalhit_uatext.php)
			"facebookexternalhit");
	private static final ImmutableSet<String> cookieCapableBots = ImmutableSet.of("googlebot",
			"msnbot", "slurp", "jeeves");

	/**
	 * Whether user agent is a redirect capable bot.
	 * @param agent
	 * @return
	 */
	public static boolean isRedirectCapableBot(final String agent) {
		if (agent != null) {
			final String lowerAgent = agent.toLowerCase();
			for (final String bot : cookieCapableBots) {
				if (lowerAgent.indexOf(bot) != -1) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Whether user agent is a dummy or redirect capable bot.
	 * @param agent
	 * @return
	 */
	public static boolean isBot(final String agent) {
		if (agent != null) {
			final String lowerAgent = agent.toLowerCase();
			for (final String bot : Iterables.concat(dummyBots, cookieCapableBots)) {
				if (lowerAgent.indexOf(bot) != -1) {
					return true;
				}
			}
		}
		return false;
	}

}
