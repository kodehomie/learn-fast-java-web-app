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
import org.justinhoang.entity.Order;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class OrderDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();


    public int create(Order order) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        id = (int) session.save(order);
        transaction.commit();
        session.close();
        return id;
    }

    public Order getById(int id) {
        Session session = sessionFactory.openSession();
        Order order = session.get(Order.class, id);
        session.close();
        return order;
    }

    public List<Order> getAllOrders() {

        Session session = sessionFactory.openSession();
        HibernateCriteriaBuilder HCB = session.getCriteriaBuilder();
        JpaCriteriaQuery<Order> query = HCB.createQuery(Order.class);
        JpaRoot<Order> root = query.from(Order.class);
        List<Order> orders = session.createQuery(query).getResultList();
        session.close();
        return orders;
    }

    public void update(Order order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(order);
        transaction.commit();
        session.close();
    }


    public void delete(Order order) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.remove(order);
        transaction.commit();
        session.close();
    }


    public List<Order> getByPropertyEqual(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for order with " + propertyName + " = " + value);

        HibernateCriteriaBuilder HCB = session.getCriteriaBuilder();
        JpaCriteriaQuery<Order> query = HCB.createQuery(Order.class);
        JpaRoot<Order> root = query.from(Order.class);
        query.select(root).where(HCB.equal(root.get(propertyName), value));
        List<Order> orders = session.createQuery((query)).getResultList();

        session.close();
        return orders;
    }

    public List<Order> getByPropertyLike(String propertyName, String value) {
        Session session = sessionFactory.openSession();

        logger.debug("Searching for order with {} = {}", propertyName, value);

        HibernateCriteriaBuilder HCB = session.getCriteriaBuilder();
        JpaCriteriaQuery<Order> query = HCB.createQuery(Order.class);
        JpaRoot<Order> root = query.from(Order.class);
        JpaPath<Object> propertyPath = root.get(propertyName);

        //query.where(HCB.like(propertyPath, "%" + value + "%"));

        List<Order> orders = session.createQuery(query).getResultList();
        session.close();
        return orders;
    }


}
