package com.example.springBoot.Repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.springBoot.model.User;
import com.example.springBoot.service.UserDaoService;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(UserCommandLineRunner.class);

	@Autowired
	private UserDaoService service;
	/* private UserRepoitory userRepoitory; */

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

		User user = new User("Sankalp", "Admin");
		
		long insert = service.insert(user);
		log.info("new user is created" +user);

		/*
		 * userRepoitory.save(new User("Sankalp","IAS")); userRepoitory.save(new
		 * User("Sharma","IPS")); userRepoitory.save(new User("Sam","PSC"));
		 * userRepoitory.save(new User("Shank","BDO"));
		 * 
		 * 
		 * for(User user: userRepoitory.findAll()) { log.info(user.toString()); }
		 * 
		 * 
		 * 
		 * for(User user : userRepoitory.findByRole("IAS")) { log.info(user.toString());
		 * }
		 */

	}

}
