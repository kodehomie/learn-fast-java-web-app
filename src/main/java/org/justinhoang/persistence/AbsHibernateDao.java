package org.justinhoang.persistence;

import com.google.common.base.Preconditions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.List;

/**
 * The type Abs hibernate dao.
 *
 * @param <T>
 *         the type parameter
 */
public abstract class AbsHibernateDao<T extends Serializable>
{
    private Class<T> clazz;

    /**
     * The Session factory.
     */
    @Autowired
    protected SessionFactory sessionFactory;

    /**
     * Sets clazz.
     *
     * @param clazz
     *         the clazz
     */
    public void setClazz(Class<T> clazz)
    {
        clazz = Preconditions.checkNotNull(clazz);
    }

    /**
     * Create t.
     *
     * @param entity
     *         the entity
     *
     * @return the t
     */
    public T create(final T entity)
    {
        Preconditions.checkNotNull(entity);
        getCurrentSession().saveOrUpdate(entity);
        return entity;
    }

    /**
     * Read id t.
     *
     * @param id
     *         the id
     *
     * @return the t
     */
    public T readId(final long id)
    {
        return (T) getCurrentSession().get(clazz, id);
    }

    /**
     * Read all list.
     *
     * @return the list
     */
    public List<T> readAll()
    {
        return getCurrentSession().createQuery("from " + clazz.getName())
                                  .list();
    }

    /**
     * Update t.
     *
     * @param entity
     *         the entity
     *
     * @return the t
     */
    public T update(final T entity)
    {
        Preconditions.checkNotNull(entity);
        return (T) getCurrentSession().merge(entity);
    }

    /**
     * Delete.
     *
     * @param entity
     *         the entity
     */
    public void delete(final T entity)
    {
        Preconditions.checkNotNull(entity);
        getCurrentSession().delete(entity);
    }

    /**
     * Delete by id.
     *
     * @param id
     *         the id
     */
    public void deleteById(final long id)
    {
        final T entity = readId(id);
        Preconditions.checkState(entity != null);
        delete(entity);
    }

    /**
     * Gets current session.
     *
     * @return the current session
     */
    protected Session getCurrentSession()
    {
        return sessionFactory.getCurrentSession();
    }
}
