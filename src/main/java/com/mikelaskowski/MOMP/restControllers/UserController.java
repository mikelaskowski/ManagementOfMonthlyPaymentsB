package com.mikelaskowski.MOMP.restControllers;

import com.mikelaskowski.MOMP.entity.User;
import com.mikelaskowski.MOMP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value = "/users")
    public User saveUser(@RequestBody User user){
        userService.save(user);
        return user;
    }
}
