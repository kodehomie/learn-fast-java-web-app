package org.justinhoang.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * The interface Generic dao.
 *
 * @param <T> the type parameter
 * @param <ID> the type parameter
 */
public interface GenericDAO<T, ID extends Serializable> {

  /**
   * Find by id t.
   *
   * @param id the id
   * @param lock the lock
   * @return the t
   */
  T findById(ID id, boolean lock);

  /**
   * Find all list.
   *
   * @return the list
   */
  List<T> findAll();

  /**
   * Find by example list.
   *
   * @param exampleInstance the example instance
   * @param excludeProperty the exclude property
   * @return the list
   */
  List<T> findByExample(T exampleInstance, String[] excludeProperty);

  /**
   * Make persistent t.
   *
   * @param entity the entity
   * @return the t
   */
  T makePersistent(T entity);

  /**
   * Make transient.
   *
   * @param entity the entity
   */
  void makeTransient(T entity);
}
