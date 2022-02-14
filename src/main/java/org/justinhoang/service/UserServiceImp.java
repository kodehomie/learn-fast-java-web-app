package org.justinhoang.service;
import java.util.List;

import org.justinhoang.persistence.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.justinhoang.entity.User;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImp implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public void addUser(User user) {
        userDAO.addUser(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void deleteUser(Integer userId) {
        userDAO.deleteUser(userId);
    }

    public User getUser(int empid) {
        return userDAO.getUser(empid);
    }

    public User updateUser(User user) {

        return userDAO.updateUser(user);
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

}
