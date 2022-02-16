package org.justinhoang.persistence;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.sql.ast.tree.predicate.Predicate;
import org.justinhoang.entity.User;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The type Generic dao.
 *
 * @param <T> the type parameter
 */
public class GenericDao<T> {

    private final Class<T> type;
    private final Logger logger = LogManager.getLogger(this.getClass());

  /**
   * Instantiates a new Generic dao.
   *
   * @param type the type
   */
  public GenericDao(Class<T> type) {
        this.type = type;
    }

    /**
     * Return and open session from the SessionFactory
     * @return session
     */
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
        id = (int)session.save(entity);
        transaction.commit();
        session.close();
        return id;
    }

  /**
   * Read id t.
   *
   * @param <T> the type parameter
   * @param id the id
   * @return the t
   */
  public <T> T readId(int id) {
        Session session = getSession();
        T entity = (T)session.get(type, id);
        session.close();
        return entity;
    }

  /**
   * Read all list.
   *
   * @return the list
   */
  public List<T> readAll() {
        Session session = getSession();

        CriteriaBuilder builder = (CriteriaBuilder) session.getCriteriaBuilder();

        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<T> list = session.createQuery(query).getResultList();
        session.close();
        return list;

    }

  /**
   * Update user.
   *
   * @param entity the entity
   * @return the user
   */
  public User update(T entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.update(entity);
        transaction.commit();
        session.close();

      return null;
  }

  /**
   * Delete.
   *
   * @param entity the entity
   */
  public void delete(Integer entity) {
        Session session = getSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();
        session.close();
    }

  /**
   * Get entity by property (like) sample usage: getByPropertyLike("lastname", "C")
   *
   * @param propertyName the property name
   * @param value the value
   * @return the by property like
   */
  public List<T> getByPropertyLike(String propertyName, String value) {
        Session session = getSession();

        logger.debug("Searching for user with {} = {}",  propertyName, value);

        CriteriaBuilder builder = (CriteriaBuilder) session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        Expression<String> propertyPath = root.get(propertyName);

        query.where(builder.like(propertyPath, "%" + value + "%"));

        List<T> entities = session.createQuery(String.valueOf(query)).getResultList();
        session.close();
        return entities;
    }

  /**
   * Finds entities by multiple properties. Inspired by
   * https://stackoverflow.com/questions/11138118/really-dynamic-jpa-criteriabuilder
   *
   * @param propertyMap property and value pairs
   * @return entities with properties equal to those passed in the map
   */
  public List<T> findByPropertyEqual(Map<String, Object> propertyMap) {
        Session session = getSession();
        CriteriaBuilder builder = (CriteriaBuilder) session.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(type);
        Root<T> root = query.from(type);
        List<Predicate> predicates = new ArrayList<Predicate>();
        for (Map.Entry<String, Object> entry: propertyMap.entrySet()) {
            predicates.add((Predicate) builder.equal(root.get(entry.getKey()), entry.getValue()));
        }
        query.select(root).where(builder.and((Predicate) predicates.toArray(new Predicate[0])));

        return session.createQuery(String.valueOf(query)).getResultList();
    }
}
