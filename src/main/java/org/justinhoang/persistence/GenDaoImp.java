package org.justinhoang.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.io.Serializable;
import java.util.List;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class GenDaoImp<T> implements GenDao
{

    private final Class<T> clazz;
    private final Logger   logger = LogManager.getLogger(this.getClass());

    public GenDaoImp(Class<T> clazz)
    {
        this.clazz = clazz;
    }

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void create(Object o)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(o);
    }

    @Override
    public Serializable readId(Long id)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        T       entity         = currentSession.get(clazz, id);
        return (Serializable) entity;
    }

    @Override
    public List readAll()
    {
        Session          session = sessionFactory.getCurrentSession();
        CriteriaBuilder  cb      = session.getCriteriaBuilder();
        CriteriaQuery<T> cq      = cb.createQuery(clazz);
        Root<T>          root    = cq.from(clazz);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void update(Object o)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(o);
    }

    @Override
    public void delete(Object o)
    {
        Session session = sessionFactory.getCurrentSession();
        session.delete(o);
    }

    @Override
    public void deleteId(Long id)
    {
        Session session = sessionFactory.getCurrentSession();
        T    t    = session.byId(clazz).load(id);
        session.delete(clazz);
    }

}