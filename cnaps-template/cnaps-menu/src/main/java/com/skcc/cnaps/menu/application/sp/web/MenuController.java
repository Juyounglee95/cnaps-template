package com.skcc.cnaps.menu.application.sp.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.cnaps.menu.context.domain.MenuService;
import com.skcc.cnaps.menu.context.domain.menu.model.Menu;
import com.skcc.cnaps.menu.context.domain.menu.repository.MenuRepository;
import com.skcc.cnaps.menu.context.domain.menugroup.model.MenuGroup;
import com.skcc.cnaps.menu.context.domain.menugroup.repository.MenuGroupRepository;

@RestController
@RequestMapping(value="/ver1")
public class MenuController implements MenuService{
	@Autowired
	MenuService menuService;
	
	@Autowired
	MenuGroupRepository menuGroupRepository;
	
	@Autowired
	MenuRepository menuRepository;
	
/************************MENU CRUD*********************************/	
	@PostMapping("/menuservice/newmenu")
	public Menu createMenu(String menuName) {
		Menu newMenu = new Menu(menuName);
		return menuRepository.save(newMenu);
	}
	
	@GetMapping("/menuservice/getmenu/{menuId}")
	public Menu getMenu(Long menuId) {
		Menu menu = menuRepository.findOne(menuId);
		if(menu!=null) {
			return menuRepository.findOne(menuId);
			
		}else {
			System.out.println("The menu does not exist");
			return null;
		}
	}
	@DeleteMapping("/menuservice/deletemenu/{menuId}")
	public void deleteMenu(Long menuId) {
		Menu menu = menuRepository.findOne(menuId);
		if(menu!=null) {
			menuRepository.delete(menuId);
		}else {
			System.out.println("The menu does not exist");
		}
	}
	@PutMapping("/menuservice/editmenu/{menuId}")
	public Menu editMenu(Long menuId, Menu newData) {
		Menu menu = menuRepository.findOne(menuId);
		if(menu!=null) {
			BeanUtils.copyProperties(newData, menu, "id","menuGroupId");
			return menuRepository.save(menu);
		}else {
			System.out.println("The menu does not exist");
			return null;
		}
		
	}
/******************************************************************/	
	

/************************MENU GROUP CRUD*********************************/	
	@PostMapping("/menuservice/newgroup")
	public MenuGroup createGroup(String groupName) {
		MenuGroup newGroup = new MenuGroup(groupName);
		return menuGroupRepository.save(newGroup);
	}
	
	@GetMapping("/menuservice/getgroup/{groupId}")
	public MenuGroup getGroup(Long groupId) {
		MenuGroup group = menuGroupRepository.findOne(groupId);
		if(group!=null) {
			return menuGroupRepository.findOne(groupId);
			
		}else {
			System.out.println("The menugroup does not exist");
			return null;
		}
	}
	
	@PutMapping("/menuservice/editgroup/{groupId}")
	public MenuGroup editGroup(Long groupId, MenuGroup newData) {
		MenuGroup group = menuGroupRepository.findOne(groupId);
		if(group!=null) {
			BeanUtils.copyProperties(newData, group, "id","menuGroupName");
			return menuGroupRepository.save(group);
		}else {
			System.out.println("The menugroup does not exist");
			return null;
		}
		
	}
	
	@DeleteMapping("/menuservice/deletegroup/{menuGroupId}")
	public void deleteMenuGroup(Long menuGroupId) {
		menuService.deleteMenuGroup(menuGroupId);
		
	}
/******************************************************************/	
	@PutMapping("/menuservice/setgroup/{menuId}")
	public Menu setMenuGroup(Long menuId, Long menuGroupId) {
		return menuService.setMenuGroup(menuId, menuGroupId);
	}
	
	@PutMapping("/menuservice/unsetgroup/{menuId}")
	public Menu unsetMenuGroup(Long menuId, Long menuGroupId) {
		return menuService.unsetMenuGroup(menuId, menuGroupId);
	}

	
	
}
