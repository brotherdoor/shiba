package menu.store;

import java.util.List;

import menu.domain.Menu;

public interface MenuDao {
	//
	void create(Menu menu);
	Menu retrieve(String id);
	List<Menu> retrieveAllMenus();
}
