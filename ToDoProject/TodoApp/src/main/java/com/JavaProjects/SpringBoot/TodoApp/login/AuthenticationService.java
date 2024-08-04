package com.JavaProjects.SpringBoot.TodoApp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean authenticate(String username,String password) {
		
		boolean isValidUserName = username.equalsIgnoreCase("Talha");
		boolean isValidPassword = password.equalsIgnoreCase("123");
		return isValidUserName && isValidPassword;
	}
}
