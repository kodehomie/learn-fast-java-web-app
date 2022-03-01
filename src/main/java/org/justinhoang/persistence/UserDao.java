package org.justinhoang.persistence;

import org.justinhoang.entity.User;

public interface UserDao {

    public int signUpUser(User user);

    public String signInUser(User user);

}
