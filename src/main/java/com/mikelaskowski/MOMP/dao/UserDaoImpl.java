package com.mikelaskowski.MOMP.dao;

import com.mikelaskowski.MOMP.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public List<User> findUsers() {
        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session
                .createQuery("select u from User as u", User.class);

        Optional<List<User>> users = Optional.ofNullable(query.getResultList());

        return users.get();
    }

    @Override
    public User getUserById(int userId) {
        Session session = sessionFactory.getCurrentSession();

        Optional<User> user = Optional.ofNullable(session.get(User.class, userId));

        return user.get();
    }

    @Override
    public User save(User user) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(user);

        return user;
    }

    @Override
    public void deleteUser(int userId) {
        Session session = sessionFactory.getCurrentSession();

        // Query<User> query = session.createQuery("delete from User as u where u.id=:theId", User.class);
        Query query = session.createQuery("delete from User as u where u.id=:theId");
        query.setParameter("theId", userId);

        query.executeUpdate();

    }

    @Override
    public User getUserByEmailAndPassword(String email, String password) {

        Session session = sessionFactory.getCurrentSession();

        Query<User> query = session.createQuery("select u from User as u where u.email=:loginEmail " +
                "AND u.password=:loginPassword",User.class);
        System.out.println(email);
        System.out.println(password);

        query.setParameter("loginEmail", email);
        query.setParameter("loginPassword", password);

        Optional<User> user = Optional.ofNullable(query.getSingleResult());

        return user.get();
    }

    @Override
    public User getUserByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();

      Query<User> query = session
              .createQuery("select u from User as u where u.email=:email", User.class);
      query.setParameter("email", email);

       User user = query.getResultList().stream()
                .findFirst()
                .get();

        return user;
    }
}
