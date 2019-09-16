package com.skcc.cnaps.role.context.domain.permission.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.skcc.cnaps.role.context.domain.permission.model.Permission;

@RepositoryRestResource
public interface PermissionRepository extends PagingAndSortingRepository<Permission, Long>, QueryDslPredicateExecutor<Permission>{

}
