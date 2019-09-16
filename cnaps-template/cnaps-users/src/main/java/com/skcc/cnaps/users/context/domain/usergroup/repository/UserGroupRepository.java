package com.skcc.cnaps.users.context.domain.usergroup.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.skcc.cnaps.users.context.domain.usergroup.model.UserGroup;

@RepositoryRestResource
public interface UserGroupRepository extends PagingAndSortingRepository<UserGroup, Long>, QueryDslPredicateExecutor<UserGroup>{
	List<UserGroup> findAll();
	List<UserGroup> findByUserGroupUsage(@Param("userGroupUsage") Boolean userGroupUsage);
	List<UserGroup> findByUserGroupNameLike(@Param("userGroupName") String userGroupName);
	UserGroup findByUserGroupName(@Param("userGroupName") String userGroupName);
	
}
