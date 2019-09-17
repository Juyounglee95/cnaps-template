package com.skcc.cnaps.role.context.domain.role.repository;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.skcc.cnaps.role.context.domain.role.model.Role;


@RepositoryRestResource
public interface RoleRepository extends PagingAndSortingRepository<Role, Long>, QueryDslPredicateExecutor<Role> {

}
