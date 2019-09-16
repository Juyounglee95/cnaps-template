package com.skcc.cnaps.menu.context.domain.menugroup.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.skcc.cnaps.menu.context.domain.menugroup.model.MenuGroup;

@RepositoryRestResource
public interface MenuGroupRepository extends PagingAndSortingRepository<MenuGroup, Long>, QueryDslPredicateExecutor<MenuGroup>{
	List<MenuGroup> findByMenuGroupNameLike(String menuGroupName);
	List<MenuGroup> findByMenuGroupUsage(Boolean menuGroupUsage);
	MenuGroup findByMenuGroupName(String menuGroupName);
}
