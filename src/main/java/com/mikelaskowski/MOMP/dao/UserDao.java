package com.mikelaskowski.MOMP.dao;

import com.mikelaskowski.MOMP.entity.User;

import java.util.List;

public interface UserDao {

    List<User> findUsers();

    User getUserById(int userId);

    User save(User user);

    void deleteUser(int userId);
}
