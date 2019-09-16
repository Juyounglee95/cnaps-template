package com.skcc.cnaps.users.context.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skcc.cnaps.users.context.domain.usergroup.repository.UserGroupRepository;
import com.skcc.cnaps.users.context.domain.users.model.Users;
import com.skcc.cnaps.users.context.domain.users.repository.UsersRepository;

@Service("usersLogic")
public class UsersLogic implements UsersService{
	@Autowired
	private UserGroupRepository userGroupRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	
	@Transactional
	public Users setUserGroup(Long userId, Long userGroupId ) {
		Users user = usersRepository.findOne(userId);
		if(user!=null) {
			if(userGroupRepository.findOne(userGroupId)!=null) {
					if(user.getUserGroupId().contains(userGroupId)) {
						System.out.println("The user has had the group.");
						return null; 
					}else {
						user.getUserGroupId().add(userGroupId);
						return usersRepository.save(user);
					}	
			}else {
				System.out.println("The group does not exist!!");
				return null;
			}
		}else {
			System.out.println("The user does not exist!!");
			return null;
		}
	}
	
	@Transactional
	public Users unsetUserGroup(Long userId, Long userGroupId) {
		Users user = usersRepository.findOne(userId);
		if(user!=null) {
			if(user.getUserGroupId().contains(userGroupId)) {
				user.getUserGroupId().remove(userGroupId);
				return usersRepository.save(user);
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
	
	@Transactional
	public void deleteUserGroup(Long userGroupId) {
		userGroupRepository.delete(userGroupId);
		List<Users> userList = usersRepository.findAll();
		for(Users user:userList) {
			if(user.getUserGroupId().contains(userGroupId)) {
				user.getUserGroupId().remove((Long)userGroupId);
				return;
			}
		}
	}
}
