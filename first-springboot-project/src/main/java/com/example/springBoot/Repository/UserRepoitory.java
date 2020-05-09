package com.example.springBoot.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.springBoot.model.User;

@RepositoryRestResource(path="users", collectionResourceRel="users")
public interface UserRepoitory extends PagingAndSortingRepository<User, Long>{

	
	 List<User> findByRole(@Param("role")String role); 
}
