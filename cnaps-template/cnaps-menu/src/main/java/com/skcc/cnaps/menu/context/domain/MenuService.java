package com.skcc.cnaps.menu.context.domain;

import com.skcc.cnaps.menu.context.domain.menu.model.Menu;

public interface MenuService {
	
	Menu setMenuGroup(Long menuId, Long menuGroupId);
	Menu unsetMenuGroup(Long menuId, Long menuGroupId);
	void deleteMenuGroup(Long menuGroupId);
	
}
