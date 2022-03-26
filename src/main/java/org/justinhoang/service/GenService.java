package org.justinhoang.service;

import java.util.List;

/**
 * The interface Gen service.
 *
 * @param <T>
 *         the type parameter
 */
public interface GenService<T>
{

    /**
     * Create.
     *
     * @param t
     *         the t
     */
    void create(T t);

    /**
     * Read id t.
     *
     * @param id
     *         the id
     *
     * @return the t
     */
    T readId(Long id);

    /**
     * Read all list.
     *
     * @return the list
     */
    List<T> readAll();

    /**
     * Update.
     *
     * @param t
     *         the t
     */
    void update(T t);

    /**
     * Delete.
     *
     * @param id
     *         the id
     */
    void delete(Long id);
}
