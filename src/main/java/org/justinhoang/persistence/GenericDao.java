package org.justinhoang.persistence;

import jakarta.persistence.criteria.Expression;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;
import org.hibernate.query.criteria.JpaCriteriaQuery;
import org.hibernate.query.criteria.JpaPredicate;
import org.hibernate.query.criteria.JpaRoot;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenericDao<T>
{

    private final Class<T> type;
    private final Logger   logger = LogManager.getLogger(this.getClass());

    public GenericDao(Class<T> type)
    {
        this.type = type;
    }

    public int create(T entity)
    {
        int id = 0;
        try (Session session = getSession())
        {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
        }
        return id;
    }

    public <T> T readById(int id)
    {
        Session session = getSession();
        T       entity  = (T) session.get(type, id);
        session.close();
        return entity;
    }

    public List<T> readAll()
    {
        Session session = getSession();

        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();

        JpaCriteriaQuery<T> query = builder.createQuery(type);
        JpaRoot<T>          root  = query.from(type);
        List<T>             list  = session.createQuery(query).getResultList();
        session.close();
        return list;

    }

    public void update(T entity)
    {
        try (Session session = getSession())
        {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
        }
    }

    public void delete(T entity)
    {
        Session     session     = getSession();
        Transaction transaction = session.beginTransaction();
        session.remove(entity);
        transaction.commit();
        session.close();
    }

    public List<T> findByPropertyEqual(String propertyName, String value)
    {
        Session                  session = getSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        JpaCriteriaQuery<T>      query   = builder.createQuery(type);
        JpaRoot<T>               root    = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));

        return session.createQuery(query).getResultList();
    }

    public List<T> findByPropertyEqual(Map<String, Object> propertyMap)
    {
        Session                  session    = getSession();
        HibernateCriteriaBuilder builder    = session.getCriteriaBuilder();
        JpaCriteriaQuery<T>      query      = builder.createQuery(type);
        JpaRoot<T>               root       = query.from(type);
        List<JpaPredicate>       predicates = new ArrayList<>();
        for (Map.Entry entry : propertyMap.entrySet())
        {
            predicates.add(builder.equal(root.get((String) entry.getKey()),
                                         entry.getValue()));
        }
        query.select(root)
             .where(builder.and(predicates.toArray(new JpaPredicate[0])));

        return session.createQuery(query).getResultList();
    }

    public List<T> findByPropertyLike(String propertyName, String value)
    {
        Session session = getSession();

        logger.debug("Searching for user with {} = {}", propertyName, value);

        HibernateCriteriaBuilder builder      = session.getCriteriaBuilder();
        JpaCriteriaQuery<T>      query        = builder.createQuery(type);
        JpaRoot<T>               root         = query.from(type);
        Expression<String>       propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> results = session.createQuery(query).getResultList();
        session.close();
        return results;
    }

    private Session getSession()
    {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }

}