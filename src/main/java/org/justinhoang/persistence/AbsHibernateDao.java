package org.justinhoang.persistence;

import com.google.common.base.Preconditions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

public abstract class AbsHibernateDao<T extends Serializable>
{
    private Class<T> clazz;

    @Autowired
    protected SessionFactory sessionFactory;

    public void setClazz(Class<T> clazz)
    {
        clazz = Preconditions.checkNotNull(clazz);
    }

    public T create(final T entity)
    {
        Preconditions.checkNotNull(entity);
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    public T readId(final long id)
    {
        return (T) getCurrentSession().get(clazz, id);
    }

    public List<T> readAll()
    {
        return getCurrentSession().createQuery("from " + clazz.getName())
                                  .list();
    }

    public T update(final T entity)
    {
        Preconditions.checkNotNull(entity);
        return (T) getCurrentSession().merge(entity);
    }

    public void delete(final T entity)
    {
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    public void deleteById(final long id)
    {
        final T entity = readId(id);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

    protected Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }
}
