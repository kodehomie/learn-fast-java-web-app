package org.justinhoang.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPath;
import org.hibernate.query.criteria.JpaRoot;
import org.justinhoang.entity.User;

import java.util.List;

public class UserDao {


    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    public int create(User user) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int) session.save(user);
        transaction.commit();
        session.close();
        return id;
    }

    public User getById(int id) {
        Session session = sessionFactory.openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public List<User> getAllUsers() {

        Session session = sessionFactory.openSession();
        HibernateCriteriaBuilder HCB = session.getCriteriaBuilder();
        JpaCriteriaQuery<User> query = HCB.createQuery(User.class);
        JpaRoot<User> root = query.from(User.class);
        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }

    public void update(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(user);
        transaction.commit();
        session.close();
    }


    public void delete(User user) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(user);
        transaction.commit();
        session.close();
    }


    public List<User> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with " + propertyName + " = " + value);

        HibernateCriteriaBuilder HCB = session.getCriteriaBuilder();
        JpaCriteriaQuery<User> query = HCB.createQuery(User.class);
        JpaRoot<User> root = query.from(User.class);
        query.select(root).where(HCB.equal(root.get(propertyName), value));
        List<User> users = session.createQuery((query)).getResultList();

        session.close();
        return users;
    }

    public List<User> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for user with {} = {}", propertyName, value);

        HibernateCriteriaBuilder HCB = session.getCriteriaBuilder();
        JpaCriteriaQuery<User> query = HCB.createQuery(User.class);
        JpaRoot<User> root = query.from(User.class);
        JpaPath<Object> propertyPath = root.get(propertyName);

        //query.where(HCB.like(propertyPath, "%" + value + "%"));

        List<User> users = session.createQuery(query).getResultList();
        session.close();
        return users;
    }


}
