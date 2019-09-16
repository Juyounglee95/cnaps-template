package com.skcc.cnaps.menu.context.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skcc.cnaps.menu.context.domain.menu.model.Menu;
import com.skcc.cnaps.menu.context.domain.menu.repository.MenuRepository;
import com.skcc.cnaps.menu.context.domain.menugroup.model.MenuGroup;
import com.skcc.cnaps.menu.context.domain.menugroup.repository.MenuGroupRepository;

@Service("menuLogic")
public class MenuLogic implements MenuService{
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private MenuGroupRepository menuGroupRepository;
	
	@Transactional
	public Menu setMenuGroup(Long menuId, Long menuGroupId) {
		
			Menu menu = menuRepository.findOne(menuId);
			if(menu!=null) {
				if(menuGroupRepository.findOne(menuGroupId)!=null) {
					
					menu.setMenuGroupId(menuGroupId);
					return menuRepository.save(menu);
				}else {
					System.out.println("The menugroup does not exist");
					return null;
				}
			}else {
				System.out.println("The menu does not exist");
				return null;
			}
		
	}

	@Override
	@Transactional
	public Menu unsetMenuGroup(Long menuId, Long menuGroupId) {
		Menu menu = menuRepository.findOne(menuId);
		if(menu!=null) {
			if(menuGroupRepository.findOne(menuGroupId)!=null) {
				menu.setMenuGroupId(null);
				return menuRepository.save(menu);
			}else {
				System.out.println("The menugroup does not exist.");
				return null;
			}
		}else {
			System.out.println("The menu does not exist");

			return null;
		}
	}

	@Override
	@Transactional
	public void deleteMenuGroup(Long menuGroupId) {
		MenuGroup menugroup = menuGroupRepository.findOne(menuGroupId);
		if(menugroup!=null) {
			List<Menu> menuList = menuRepository.findByMenuGroupId(menuGroupId);
			for(Menu menu:menuList) {
				menu.setMenuGroupId(null);
				menuRepository.save(menu);
			}
			menuGroupRepository.delete(menuGroupId);
		}else {
			System.out.println("The menugroup does not exist");
			
		}
		
	}
	
	

}
