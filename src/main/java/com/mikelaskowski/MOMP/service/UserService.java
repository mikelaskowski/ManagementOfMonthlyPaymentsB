package com.mikelaskowski.MOMP.service;

import com.mikelaskowski.MOMP.entity.User;

import java.util.List;

public interface UserService {

    List<User> findUsers();

    User getUserById(int userId);

    User save (User user);

    void updateUser(User user);

    void deleteUser(int userId);
}
