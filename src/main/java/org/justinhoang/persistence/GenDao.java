package org.justinhoang.persistence;

import java.io.Serializable;
import java.util.List;

public interface GenDao<T extends Serializable>
{
    void create(Object o);

    Object readId(Long id);

    List<Object> readAll();

    void update(Object o);

    void delete(Object o);

    void deleteId(Long id);
}
