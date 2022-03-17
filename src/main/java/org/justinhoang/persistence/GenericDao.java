package org.justinhoang.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericDao<T>
{

    private final Class<T> type;
    private final Logger   logger = LogManager.getLogger(this.getClass());


    public GenericDao(final Class<?> type)
    {
        this.type = (Class<T>) type;
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
        T       entity  = (T) session.get(String.valueOf(type), id);
        session.close();
        return entity;
    }

    public List<T> readAll()
    {
        Session session = getSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T>          root  = query.from(type);
        List<T>          list  = session.createQuery(query).getResultList();
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
        try (Session session = getSession())
        {
            Transaction transaction = session.beginTransaction();
            session.remove(entity);
            transaction.commit();
        }
    }

    public List<T> findByPropertyEqual(String propertyName, Object value)
    {
        Session          session = getSession();
        CriteriaBuilder  builder = session.getCriteriaBuilder();
        CriteriaQuery<T> query   = builder.createQuery(type);
        Root<T>          root    = query.from(type);
        query.select(root).where(builder.equal(root.get(propertyName), value));

        return session.createQuery(query).getResultList();
    }

    public List<T> findByPropertyEqual(Map<String, Object> propertyMap)
    {
        Session          session    = getSession();
        CriteriaBuilder  builder    = session.getCriteriaBuilder();
        CriteriaQuery<T> query      = builder.createQuery(type);
        Root<T>          root       = query.from(type);
        List<Predicate>  predicates = new ArrayList<Predicate>();
        for (Map.Entry<String, Object> entry : propertyMap.entrySet())
        {
            predicates.add(builder.equal(root.get(entry.getKey()),
                                         entry.getValue()));
        }
        query.select(root).where(builder.and(
                predicates.toArray(new Predicate[predicates.size()])));

        return session.createQuery(query).getResultList();
    }

    private Session getSession()
    {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }

}