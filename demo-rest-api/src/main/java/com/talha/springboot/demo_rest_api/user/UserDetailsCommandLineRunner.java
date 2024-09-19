package com.talha.springboot.demo_rest_api.user;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsCommandLineRunner implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(getClass());
	private UserDetailsRepository repository;
	
	public UserDetailsCommandLineRunner(UserDetailsRepository reposityory) {
		super();
		this.repository = reposityory;
	}

	@Override
	public void run(String... args) throws Exception {
		
		
		repository.save(new UserDetails("Ranga","Admin"));
		repository.save(new UserDetails("Talha","Admin"));
		repository.save(new UserDetails("Timur","User"));
		
//		List<UserDetails> users = repository.findAll();
		
		List<UserDetails> users = repository.findByRole("Admin");
		users.forEach(user -> logger.info(user.toString()));
		
		
		
	}

}
