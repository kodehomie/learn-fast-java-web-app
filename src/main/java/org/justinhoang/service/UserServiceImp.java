package org.justinhoang.service;

import java.util.List;

import org.justinhoang.entity.User;
import org.justinhoang.persistence.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type User service imp.
 */
@Service
public class UserServiceImp implements UserService
{
    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void createUser(User user)
    {
        userDao.createUser(user);
    }

    @Override
    @Transactional
    public User readUser(Long id)
    {
        return userDao.readUser(id);
    }

    @Override
    @Transactional
    public List<User> readUsers()
    {
        return userDao.readUsers();
    }

    @Override
    @Transactional
    public void updateUser(User user)
    {
        userDao.updateUser(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id)
    {
        userDao.deleteUser(id);
    }
}
