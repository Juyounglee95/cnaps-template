package com.skcc.cnaps.menu.context.domain.menu.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.skcc.cnaps.menu.context.domain.menu.model.Menu;

@RepositoryRestResource
public interface MenuRepository extends PagingAndSortingRepository<Menu, Long>, QueryDslPredicateExecutor<Menu>{
	List<Menu> findByMenuNameLike(String menuName);
	List<Menu> findByMenuGroupId(Long menuGroupId);
	List<Menu> findByMenuUsage(Boolean menuUsage);
	Menu findByMenuName(String menuName);
	
}
