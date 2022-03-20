package org.justinhoang.persistence;

import java.io.Serializable;
import java.util.List;

public interface GenDaoInt<T extends Serializable>
{
    void setClassx(Class<T> classx);

    T create(final T entity);

    T readId(final long id);

    List<T> readAll();

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);
}