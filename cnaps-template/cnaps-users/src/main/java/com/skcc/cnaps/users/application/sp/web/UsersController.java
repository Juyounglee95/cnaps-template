package com.skcc.cnaps.users.application.sp.web;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skcc.cnaps.users.context.domain.UsersService;
import com.skcc.cnaps.users.context.domain.usergroup.model.UserGroup;
import com.skcc.cnaps.users.context.domain.usergroup.repository.UserGroupRepository;
import com.skcc.cnaps.users.context.domain.users.model.UserCompany;
import com.skcc.cnaps.users.context.domain.users.model.Users;
import com.skcc.cnaps.users.context.domain.users.repository.UsersRepository;

@RestController
@RequestMapping(value="/ver1")
public class UsersController implements UsersService{
	@Autowired
	UsersService usersService;
	
	@Autowired
	UsersRepository usersRepository;
	
	@Autowired
	UserGroupRepository userGroupRepository;
	
	
/*********************USER CRUD*************************/
	@PostMapping("/userservice/newuser")
	public Users createUser(String userName, String company) {
		Users newUser = new Users(userName);
		UserCompany userCompany = new UserCompany(company);
		newUser.setUserCompany(userCompany);
		return usersRepository.save(newUser);
	}
	@GetMapping("/userservice/getuser/{userId}")
	public Users getUser(Long userId) {
		Users user = usersRepository.findOne(userId);
		if(user!=null) {
			return usersRepository.findOne(userId);
		}else {
			System.out.println("The user does not exist.");
			return null;
		}
	}
	@DeleteMapping("/userservice/deleteuser/{userId}")
	public void deleteUser(Long userId) {
		Users user = usersRepository.findOne(userId);
		if(user!=null) {
			usersRepository.delete(userId);
		}else {
			System.out.println("The user does not exist.");
		}
	}
	@PutMapping("/userservice/edituser/{userId}")
	public Users editUser(Long userId, Users newData) {
		Users user = usersRepository.findOne(userId);
		if(user!=null) {
			BeanUtils.copyProperties(newData, user, "id","userCompany","userGroupId");
			return usersRepository.save(user);
		}else {
			System.out.println("The user does not exist.");
			return null;
		}
	}
/***********************************************************/

/*********************USERGROUP CRUD*************************/
	@PostMapping("/groupservice/newgroup")
	public UserGroup createGroup(String groupName) {
		UserGroup userGroup = new UserGroup(groupName);
		return userGroupRepository.save(userGroup);
	}
	@GetMapping("/groupservice/getgroup/{groupId}")
	public UserGroup getGroup(Long groupId) {
		UserGroup userGroup = userGroupRepository.findOne(groupId);
		if(userGroup!=null) {
			return userGroupRepository.findOne(groupId);
		}else {
			System.out.println("The group does not exist.");
			return null;
		}
	}
	
	@DeleteMapping("/userservice/deletegroup/{groupId}")
	public void deleteUserGroup(Long groupId) {
		usersService.deleteUserGroup(groupId);
		
	}
	
	@PutMapping("/userservice/editgroup/{groupId}")
	public UserGroup editGroup(Long groupId, UserGroup newData) {
		UserGroup userGroup = userGroupRepository.findOne(groupId);
		if(userGroup!=null) {
			BeanUtils.copyProperties(newData, userGroup, "id","userGroupName");
			return userGroupRepository.save(userGroup);
		}else {
			System.out.println("The group does not exist.");
			return null;
		}
	}
/***********************************************************/
	@PutMapping("/userservice/setgroup/{userId}")
	public Users setUserGroup(Long userId, Long userGroupId) {
		return usersService.setUserGroup(userId, userGroupId);
	}
	@PutMapping("/userservice/unsetgroup/{userId}")
	public Users unsetUserGroup(Long userId, Long userGroupId) {
		return usersService.unsetUserGroup(userId, userGroupId);
	}
	
	
	
	
	
}
