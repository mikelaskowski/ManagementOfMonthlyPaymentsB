package com.mikelaskowski.MOMP.restControllers;

import com.mikelaskowski.MOMP.entity.User;
import com.mikelaskowski.MOMP.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> findUsers() {
        List<User> users = userService.findUsers();

        return users;
    }

    @PostMapping(value = "/users")
    public User saveUser(@RequestBody User user) {

        // assign 0 to user's id because we use method saveOrUpdate() in UserDaoImpl
        // when we assing 0, we inform Hibernate that we create new object
        user.setId(0);

        userService.save(user);
        return user;
    }
}
