package org.justinhoang.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPath;
import org.hibernate.query.criteria.JpaRoot;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * The type Generic dao.
 *
 * @param <T> the type parameter
 */
public class GenericDao<T> {

    private Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());


    /**
     * Instantiates a new Generic dao.
     *
     * @param type the type
     */
    public GenericDao(Class<T> type) {
        this.type = type;
    }


    private Session getSession() {
        return SessionFactoryProvider.getSessionFactory().openSession();
    }


    /**
     * Create int.
     *
     * @param entity the entity
     * @return the int
     */
    public int create(T entity) {
        int id = 0;
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        id = (int) session.merge(entity);
        transaction.commit();
        session.close();
        return id;
    }

    /**
     * Gets by id.
     *
     * @param <T> the type parameter
     * @param id  the id
     * @return the by id
     */
    public <T> T getById(int id) {
        Session session = getSession();
        T entity = (T) session.get(type, id);
        session.close();
        return entity;
    }

    /**
     * Gets all.
     *
     * @return the all
     */
    public List<T> getAll() {
        Session session = getSession();
        HibernateCriteriaBuilder HCB = session.getCriteriaBuilder();
        JpaCriteriaQuery<T> query = HCB.createQuery(type);
        JpaRoot<T> root = query.from(type);
        List<T> myList = session.createQuery((query)).getResultList();
        session.close();
        return myList;
    }


    /**
     * Update.
     *
     * @param entity the entity
     */
    public void update(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        transaction.commit();
        session.close();

    }

    /**
     * Delete.
     *
     * @param entity the entity
     */
    public void delete(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.remove(entity);
        transaction.commit();
        session.close();
    }

    /**
     * Gets by property equal.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property equal
     */
    public List<T> getByPropertyEqual(String propertyName, String value) {
        Session session = getSession();
        logger.debug("Searching for user with " + propertyName + " = " + value);

        HibernateCriteriaBuilder HCB = session.getCriteriaBuilder();
        JpaCriteriaQuery<T> query = HCB.createQuery(type);
        JpaRoot<T> root = query.from(type);
        query.select(root).where(HCB.equal(root.get(propertyName), value));
        List<T> entities = session.createQuery((query)).getResultList();

        session.close();
        return entities;
    }


    /**
     * Gets by property like.
     *
     * @param propertyName the property name
     * @param value        the value
     * @return the by property like
     */
    public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for user with {} = {}", propertyName, value);

        HibernateCriteriaBuilder HCB = session.getCriteriaBuilder();
        JpaCriteriaQuery<T> query = HCB.createQuery(type);
        JpaRoot<T> root = query.from(type);
        JpaPath<Object> propertyPath = root.get(propertyName);

//        query.where(HCB.like(propertyPath, "%" + value + "%"));

        List<T> entities = session.createQuery(query).getResultList();
        session.close();
        return entities;
    }


    /**
     * Find by property equal list.
     *
     * @param propertyMap the property map
     * @return the list
     */
    public List<T> findByPropertyEqual(Map<String, Object> propertyMap) {
        Session session = getSession();
        HibernateCriteriaBuilder HCB = session.getCriteriaBuilder();
        JpaCriteriaQuery<T> query = HCB.createQuery(type);
        JpaRoot<T> root = query.from(type);
        List<Predicate> predicates = new ArrayList<Predicate>();
        for (Map.Entry<String, Object> entry : propertyMap.entrySet()) {
            predicates.add((Predicate) HCB.equal(root.get(entry.getKey()), entry.getValue()));
        }
        //query.select(root).where(HCB.and(predicates.toArray(new Predicate[0])));
        //query.select(root).where(HCB.and(predicates.toArray(new Predicate[predicates.size()])));

        return session.createQuery(query).getResultList();
    }


}
