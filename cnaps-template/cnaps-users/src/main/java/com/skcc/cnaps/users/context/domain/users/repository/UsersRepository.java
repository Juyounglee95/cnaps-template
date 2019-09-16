package com.skcc.cnaps.users.context.domain.users.repository;

import java.util.List;

import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.querydsl.core.types.Predicate;
import com.skcc.cnaps.users.context.domain.users.model.Users;

@RepositoryRestResource
public interface UsersRepository extends PagingAndSortingRepository<Users, Long>, QueryDslPredicateExecutor<Users>{
	List<Users> findAll();
	List<Users> findByUserNameLike(@Param("userName") String userName);
	List<Users> findByUserCompanyCompanyNameLike(@Param("companyName") String companyName);
	Users findByUserName(@Param("userName") String userName);
}
