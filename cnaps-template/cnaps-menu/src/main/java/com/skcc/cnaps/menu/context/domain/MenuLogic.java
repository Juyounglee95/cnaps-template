package com.skcc.cnaps.menu.context.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skcc.cnaps.menu.context.domain.menu.model.Menu;
import com.skcc.cnaps.menu.context.domain.menu.repository.MenuRepository;

@Service("menuLogic")
public class MenuLogic implements MenuService{
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Transactional
	public Menu setMenuGroup(Long menuId, Long menuGroupId) {
		
			Menu menu = menuRepository.findOne(menuId);
			if(menu!=null) {
				menu.setMenuGroupId(menuGroupId);
				return menuRepository.save(menu);
			}else {
				System.out.println("The menu does not exist");
				return null;
			}
		
	}
	
	

}
