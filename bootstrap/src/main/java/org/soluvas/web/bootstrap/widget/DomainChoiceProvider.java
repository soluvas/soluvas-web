package org.soluvas.web.bootstrap.widget;

import org.apache.wicket.injection.Injector;
import org.apache.wicket.model.IModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.soluvas.data.domain.Page;
import org.soluvas.data.domain.PageRequest;
import org.soluvas.data.domain.Sort.Direction;
import org.soluvas.security.DomainPermission2;
import org.soluvas.security.DomainPermissionRepository;
import org.wicketstuff.select2.ChoiceProvider;
import org.wicketstuff.select2.Response;

import javax.inject.Inject;
import java.util.Collection;
import java.util.List;

/**
 * @author rudi
 */
public class DomainChoiceProvider extends ChoiceProvider<DomainPermission2> {

    private static final Logger log = LoggerFactory
            .getLogger(DomainChoiceProvider.class);

    @Inject
    private DomainPermissionRepository repo;

    private final IModel<List<String>> excludedDomainIdsModel;

    public DomainChoiceProvider(final IModel<List<String>> excludedDomainIdsModel) {
        super();
        Injector.get().inject(this);

        this.excludedDomainIdsModel = excludedDomainIdsModel;
    }

    @Override
    public String getDisplayValue(DomainPermission2 choice) {
        return choice.getName();
    }

    @Override
    public String getIdValue(DomainPermission2 choice) {
        return choice.getId();
    }

    @Override
    public void query(String term, int page, Response<DomainPermission2> response) {
        final Page<DomainPermission2> result = repo.findAllBySearchText(term.trim(), excludedDomainIdsModel.getObject(), new PageRequest(page, 5L, Direction.ASC, "id"));
        log.debug("Got {} row(s) for query '{}' and excludedDomainIds '{}'", result.getContent().size(), term, excludedDomainIdsModel.getObject());
        response.addAll(result.getContent());
        response.setHasMore(result.hasNextPage());
    }

    @Override
    public Collection<DomainPermission2> toChoices(Collection<String> ids) {
        return repo.findAll(ids);
    }

}
