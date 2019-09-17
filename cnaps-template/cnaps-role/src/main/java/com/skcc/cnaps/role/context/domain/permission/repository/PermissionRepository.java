package com.skcc.cnaps.role.context.domain.permission.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.skcc.cnaps.role.context.domain.permission.model.Permission;
import com.skcc.cnaps.role.context.domain.permission.model.PermissionLevel;

import feign.Param;

@RepositoryRestResource
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long>, QueryDslPredicateExecutor<Permission>{
	List<Permission> findByPerLevelType(PermissionLevel perLevelType);
}
