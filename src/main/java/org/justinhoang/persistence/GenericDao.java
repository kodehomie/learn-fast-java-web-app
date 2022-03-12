package org.justinhoang.persistence;

import jakarta.persistence.criteria.CriteriaUpdate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
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
        T entity;
        try (Session session = getSession())
        {
            entity = (T) session.get(type, id);
        }
        return entity;
    }

    public List<T> readAll()
    {
        List<T> list;
        try (Session session = getSession())
        {

            CriteriaBuilder builder =
                    (CriteriaBuilder) session.getCriteriaBuilder();

            CriteriaQuery<T> query = builder.createQuery(type);
            Root<T>          root  = query.from(type);
            list = session.createQuery((CriteriaUpdate) query).getResultList();
        }
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

    public List<T> findByPropertyEqual(String propertyName, String value)
    {
        try (Session session = getSession())
        {
            CriteriaBuilder  builder =
                    (CriteriaBuilder) session.getCriteriaBuilder();
            CriteriaQuery<T> query   = builder.createQuery(type);
            Root<T>          root    = query.from(type);
            query.select(root)
                 .where(builder.equal(root.get(propertyName), value));

            return session.createQuery((CriteriaUpdate) query).getResultList();
        }
    }

    public List<T> findByPropertyEqual(Map<String, Object> propertyMap)
    {
        try (Session session = getSession())
        {
            CriteriaBuilder  builder    =
                    (CriteriaBuilder) session.getCriteriaBuilder();
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

            return session.createQuery((CriteriaUpdate) query).getResultList();
        }
    }

    private Session getSession()
    {
        return SessionFactoryProvider.getSessionFactory().openSession();

    }

}