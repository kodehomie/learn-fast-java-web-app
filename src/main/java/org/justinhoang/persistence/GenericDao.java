package org.justinhoang.persistence;

import java.util.List;

public interface GenericDao<T> {

    T create(T t);

    T readID(long id);

    List<T> readAll();

    void update(T t);

    void delete(long id);

}
