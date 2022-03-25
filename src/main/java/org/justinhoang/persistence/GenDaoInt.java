package org.justinhoang.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * The interface Gen dao int.
 *
 * @param <T>
 *         the type parameter
 */
public interface GenDaoInt<T extends Serializable>
{

    /**
     * Create t.
     *
     * @param entity
     *         the entity
     *
     * @return the t
     */
    T create(final T entity);

    /**
     * Read id t.
     *
     * @param id
     *         the id
     *
     * @return the t
     */
    T readId(final long id);

    /**
     * Read all list.
     *
     * @return the list
     */
    List<T> readAll();

    /**
     * Update t.
     *
     * @param entity
     *         the entity
     *
     * @return the t
     */
    T update(final T entity);

    /**
     * Delete.
     *
     * @param entity
     *         the entity
     */
    void delete(final T entity);

    /**
     * Delete by id.
     *
     * @param entityId
     *         the entity id
     */
    void deleteById(final long entityId);
}
