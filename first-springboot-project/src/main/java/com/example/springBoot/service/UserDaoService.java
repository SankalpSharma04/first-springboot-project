package com.example.springBoot.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.springBoot.model.User;

@Repository
@Transactional
public class UserDaoService {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user) {
		//Open transaction
		
		
		entityManager.persist(user);
		//close transaction
		return user.getId();
		
	}

}
