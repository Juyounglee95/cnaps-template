package com.skcc.cnaps.users.context.domain;

import java.util.List;


import com.skcc.cnaps.users.context.domain.users.model.Users;

public interface UsersService {
	
	Users setUserGroup(Long userId, Long userGroupId);
	
	Users unsetUserGroup(Long userId, Long userGroupId);
	
	void deleteUserGroup(Long userGroupId);
	
	
	
}
