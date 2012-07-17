package org.soluvas.web.nav.shell;

import java.util.List;

import org.apache.felix.gogo.commands.Command;
import org.apache.karaf.shell.console.OsgiCommandSupport;
import org.soluvas.async.Callback;
import org.soluvas.web.nav.Menu;
import org.soluvas.web.nav.MenuItem;
import org.soluvas.web.nav.MenuRepository;

/**
 * @author ceefour
 */
@Command(scope="nav", name="ls", description="List navigation elements.")
public class NavLsCommand extends OsgiCommandSupport {
	
	private MenuRepository menuRepository;
	
	public NavLsCommand(MenuRepository menuRepository) {
		super();
		this.menuRepository = menuRepository;
	}

	/* (non-Javadoc)
	 * @see org.apache.karaf.shell.console.AbstractAction#doExecute()
	 */
	@Override
	protected Object doExecute() throws Exception {
		menuRepository.findAll(new Callback<List<Menu>>() {
			@Override
			public void success(List<Menu> data) {
				for (Menu menu : data) {
					System.out.println(String.format("%s : %d items", menu.getId(), menu.getItems().size()));
					for (MenuItem item : menu.getItems()) {
						System.out.println(String.format("  %-20s %s", item.getId(), item.getLabel()));	
					}
				}
				System.out.println(String.format("%d menus", data.size()));
			}
		});
		return null;
	}

}
