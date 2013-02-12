/**
 * 
 */
package org.soluvas.web.login;

import id.co.bippo.common.MallManager;
import id.co.bippo.shop.ShopRepository;

import java.util.List;
import java.util.Set;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.soluvas.commons.WebAddress;
import org.soluvas.ldap.SocialPerson;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;


/**
 * @author haidar
 *
 */
public class RedirectByUserType implements Function<String, String> {
	
//	@Inject
	private final MallManager mallManager;
	private final ShopRepository shopRepo;
//	@Inject @Supplied
	private final WebAddress webAddress;
	
	public RedirectByUserType(@Nonnull final MallManager mallManager,
			@Nonnull final WebAddress webAddress, @Nonnull final ShopRepository shopRepo) {
		super();
		
		this.mallManager = mallManager;
		this.webAddress = webAddress;
		this.shopRepo = shopRepo;
	}
	
	@Override
	@Nullable
	public String apply(@Nullable String personId) {
		Preconditions.checkNotNull(mallManager, "Mall manager must not be null.");
		final List<SocialPerson> mallAdmins = ImmutableList.copyOf(mallManager.getMallAdmins());
		final Set<String> mallAdminIds = ImmutableSet.copyOf(Iterables.transform(mallAdmins, new Function<SocialPerson, String>() {
			@Override
			@Nullable
			public String apply(@Nullable SocialPerson input) {
				return input.getId();
			}
		}));
		if (mallAdminIds.contains(personId)) {
			// ke id.co.bippo.web.mall.IndexMallPage 
			
			return (webAddress.getBaseUri() + "mall");
		} else if (!shopRepo.findShopsByPersonId(personId).isEmpty()) {
			// ke id.co.bippo.web.shop.IndexShopPage
			return (webAddress.getBaseUri() + "shop_index/"+ personId);
			//user biasa
		} else {
			return (webAddress.getBaseUri());
		}
	}
	
}
