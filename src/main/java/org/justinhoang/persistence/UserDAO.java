package org.justinhoang.persistence;

import java.util.List;
import org.justinhoang.entity.User;


public interface UserDAO {

    public void addUser(User user);

    public List<User> getAllUsers();

    public void deleteUser(Integer userId);

    public User updateUser(User user);

    public User getUser(int userid);
}
