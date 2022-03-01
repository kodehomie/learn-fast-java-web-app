/*
 * Author:Justin Hoang
 * Date:2022-March-01-Tuesday
 * Time:1:58AM
 */
package org.justinhoang.persistence;

import java.util.List;

public interface GenCrudDao<T> {

    T create(T t);

    T readID(long id);

    List<T> readAll();

    void update(T t);

    void delete(long id);

}
