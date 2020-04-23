package com.mikelaskowski.MOMP.service;

import com.mikelaskowski.MOMP.entity.User;

import java.util.List;

public interface UserService {

    List<User> findUsers();

    User save (User user);
}
