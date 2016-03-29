package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.security.ActionPermission;
import org.soluvas.security.DomainPermission2;
import org.soluvas.security.DomainPermissionRepository;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

import javax.inject.Inject;
import java.util.Collection;

/**
 * @author anisa
 */
public class ActionPermissionChoiceProvider extends ChoiceProvider<ActionPermission> {

    private static final Logger log = LoggerFactory
            .getLogger(ActionPermissionChoiceProvider.class);

    @Inject
    private DomainPermissionRepository domainPermissionRepo;

    private final IModel<DomainPermission2> domainPermissionModel;

    public ActionPermissionChoiceProvider(final IModel<DomainPermission2> domainPermissionModel) {
        super();
        this.domainPermissionModel = domainPermissionModel;
        Injector.get().inject(this);
    }

    @Override
    public String getDisplayValue(ActionPermission choice) {
        return choice.getName();
    }

    @Override
    public String getIdValue(ActionPermission choice) {
        return choice.getId();
    }

    @Override
    public void query(String term, int page, Response<ActionPermission> response) {
        final Page<ActionPermission> result = domainPermissionRepo.findAllActionPermissionsBySearchText(term.trim(), domainPermissionModel.getObject().getId(),
                new PageRequest(page, 5L, Direction.ASC, "id"));
        //log.debug("Got {} row(s) for query '{}'", result.getContent().size(), term);
        if (result != null) {
            response.addAll(result.getContent());
            response.setHasMore(result.hasNextPage());
        }
    }

	@Override
	public Collection<ActionPermission> toChoices(Collection<String> ids) {
		if (domainPermissionModel.getObject() != null) {
			return domainPermissionRepo.findAllActionPermissions(domainPermissionModel.getObject().getId(), ids);
		} else {
			return null;
		}
	}

}
