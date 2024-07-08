package com.hoaxify.ws.user;

import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.ws.shared.GenericMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {

   @Autowired
    UserService UserService;

    
    @PostMapping("/api/1.0/users")
    public GenericMessage createUser(@RequestBody User user) {
        UserService.save(user);
        return new GenericMessage("User saved");
    }

}
