package org.soluvas.web.site.shell;

import static org.fusesource.jansi.Ansi.ansi;

import java.util.Collection;

import javax.inject.Inject;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.osgi.framework.Bundle;
import org.soluvas.data.repository.CrudRepository;
import org.soluvas.web.site.annotation.SlaveRelated;
import org.soluvas.web.site.compose.LiveSlave;
import org.soluvas.web.site.compose.Slave;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 * List registered {@link Slave}s.
 * @author ceefour
 */
@Service @Lazy
@Command(scope="compose", name="slavels", description="List registered Slaves.")
public class ComposeSlaveLsCommand extends OsgiCommandSupport {
	
	private final CrudRepository<LiveSlave, Integer> slaveRepo;

	@SuppressWarnings({ "rawtypes", "unchecked" }) @Inject
	public ComposeSlaveLsCommand(@SlaveRelated CrudRepository slaveRepo) {
		super();
		this.slaveRepo = slaveRepo;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		System.out.println(ansi().render("@|negative_on %3s|%-40s|%-40s|%-40s|%-34s|@",
				"№", "Page", "Path", "IModel", "Bundle"));
		int i = 0;
		final Collection<LiveSlave> origSlaves = slaveRepo.findAll();
		final Collection<LiveSlave> sortedSlaves = origSlaves;
		for (final LiveSlave slave : sortedSlaves) {
			final Bundle bundle = slave.getBundle();
			System.out.println(ansi().render("@|bold,black %3d||@%-40s@|bold,black ||@%-40s@|bold,black ||@%-40s@|bold,black ||@%-30s@|bold,yellow %4d|@",
				++i, slave.getPageClassName(), slave.getPath(), slave.getModelClassName(),
				bundle != null ? bundle.getSymbolicName() : null, bundle != null ? bundle.getBundleId() : null ));
		}
		System.out.println(ansi().render("@|bold %d|@ slaves", i));
		return null;
	}

}
