package org.justinhoang.persistence;

import java.io.Serializable;
import java.util.List;

public interface GenDao<T extends Serializable>
{
    void create(final T entity);

    T readId(final Long id);

    List<T> readAll();

    void update(final T entity);

    void delete(final T entity);

    void deleteId(final Long id);
}
