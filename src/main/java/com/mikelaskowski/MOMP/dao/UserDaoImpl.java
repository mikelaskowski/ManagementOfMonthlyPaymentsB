package com.mikelaskowski.MOMP.dao;

import com.mikelaskowski.MOMP.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(user);

        return user;
    }
}
