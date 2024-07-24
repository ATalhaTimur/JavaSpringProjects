package com.hoaxify.ws.user;

import org.springframework.web.bind.annotation.RestController;

import com.hoaxify.ws.error.ApiError;
import com.hoaxify.ws.shared.GenericMessage;

import jakarta.validation.Validation;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class UserController {

   @Autowired
    UserService UserService;

    
    @PostMapping("/api/1.0/users")
    ResponseEntity <?>  createUser(@RequestBody User user)
    {
        if(user.getUsername() == null|| user.getUsername().isEmpty() || user.getEmail() == null || user.getPassword() == null)
        {
            ApiError apiError = new ApiError();
            apiError.setPath("/api/1.0/users");
            apiError.setMessage("Validation error");
            apiError.setSatatus(400);

            Map<String, String> ValidationErrors = new HashMap<>();

            ValidationErrors.put("username", "Username cannot be null");
            apiError.setValidationErrors(ValidationErrors);

            return ResponseEntity.badRequest().body(apiError);
        }
        UserService.save(user);
        return ResponseEntity.ok(new GenericMessage("User saved"));
    }

}
