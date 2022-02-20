package org.justinhoang.persistence;

import org.hibernate.Criteria;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.criterion.Example;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * The type Generic hibernate dao.
 *
 * @param <T> the type parameter
 * @param <ID> the type parameter
 */
public abstract class GenericHibernateDAO<T, ID extends Serializable> implements GenericDAO<T, ID> {

    private Class<T> persistentClass;
    private Session session;

  /** Instantiates a new Generic hibernate dao. */
  public GenericHibernateDAO() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

  /**
   * Sets session.
   *
   * @param s the s
   */
  @SuppressWarnings("unchecked")
  public void setSession(Session s) {
        this.session = s;
    }

  /**
   * Gets session.
   *
   * @return the session
   */
  protected Session getSession() {
        if (session == null)
            throw new IllegalStateException("Session has not been set on DAO before usage");
        return session;
    }

  /**
   * Gets persistent class.
   *
   * @return the persistent class
   */
  public Class<T> getPersistentClass() {
        return persistentClass;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T findById(ID id, boolean lock) {
        T entity;
        if (lock)
            //entity = (T) getSession().load(getPersistentClass(), id, LockMode.UPGRADE);
            entity = (T) getSession().get(getPersistentClass(), id, LockMode.UPGRADE);
        else
            //entity = (T) getSession().load(getPersistentClass(), id);
            entity = (T) getSession().get(getPersistentClass(), id);
        return entity;
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll() {
        return findByCriteria();
    }

  /**
   * Find by criteria list.
   *
   * @return the list
   */
  protected abstract List<T> findByCriteria();

    @SuppressWarnings("unchecked")
    public List<T> findByExample(T exampleInstance, String[] excludeProperty) {
        Criteria crit = getSession().createCriteria(getPersistentClass());
        Example example =  Example.create(exampleInstance);
        for (String exclude : excludeProperty) {
            example.excludeProperty(exclude);
        }
        crit.add(example);
        return crit.list();
    }

    @SuppressWarnings("unchecked")
    public T makePersistent(T entity) {
        getSession().saveOrUpdate(entity);
        return entity;
    }

    public void makeTransient(T entity) {
        getSession().delete(entity);
    }

  /** Flush. */
  public void flush() {
        getSession().flush();
    }

  /** Clear. */
  public void clear() {
        getSession().clear();
    }

}
