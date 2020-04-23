package com.mikelaskowski.MOMP.service;

import com.mikelaskowski.MOMP.dao.UserDao;
import com.mikelaskowski.MOMP.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
   private UserDao userDao;

    @Transactional
    @Override
    public List<User> findUsers() {
        return userDao.findUsers();
    }

    @Transactional
    @Override
    public User save(User user) {
        return userDao.save(user);
    }
}
