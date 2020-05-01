package com.mikelaskowski.MOMP.restControllers;

import com.mikelaskowski.MOMP.entity.User;
import com.mikelaskowski.MOMP.service.UserService;
import com.mikelaskowski.MOMP.tools.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping(value = "/api")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordService passwordService;

    @GetMapping(value = "/users")
    public List<User> findUsers() {
        List<User> users = userService.findUsers();

        return users;
    }

    @GetMapping(value = "/users/{userId}")
    public User getUser(@PathVariable int userId){
        User user = userService.getUserById(userId);

        return user;
    }

    @PostMapping(value = "/users")
    public User saveUser(@RequestBody User user) {

        // assign 0 to user's id because we use method saveOrUpdate() in UserDaoImpl
        // when we assing 0, we inform Hibernate that we create new object
        user.setId(0);

        String password = user.getPassword();

        String encodedPassword = passwordService.encodePassword(password);

        user.setPassword(encodedPassword);

        userService.save(user);

        return user;
    }

    @PutMapping(value = "/users")
    public User updateUser(@RequestBody User user){
        userService.updateUser(user);

        return user;
    }

    @DeleteMapping(value = "/users/{userId}")
    public void deleteUser(@PathVariable int userId){
        userService.deleteUser(userId);
    }

    @GetMapping(value ="/login/{email:.+}")
    public User loginUser(@PathVariable String email, @RequestParam ("password") String password){


      User user = userService.getUserByEmailAndPassword(email, password);

        return user;
    }

    /*@GetMapping(value ="/login/{email:.+}")
    public User loginUser(@PathVariable String email){
        User user = userService.getUserByEmail(email);

        return user;
    }*/
}
