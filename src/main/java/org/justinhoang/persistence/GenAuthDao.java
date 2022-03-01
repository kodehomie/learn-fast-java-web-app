/*
 * Author:Justin Hoang
 * Date:2022-March-01-Tuesday
 * Time:1:58AM
 */
package org.justinhoang.persistence;

import org.justinhoang.entity.User;

public interface GenAuthDao {

    public int signUp(User user);

    public String signIn(User user);

}
