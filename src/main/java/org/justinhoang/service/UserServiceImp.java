//package org.justinhoang.service;
//import java.util.List;
//
//import org.justinhoang.persistence.GenericDao;
//import org.springframework.stereotype.Service;
//
//import org.justinhoang.entity.User;
//
//import javax.transaction.Transactional;
//
//@Service
//@Transactional
//public class UserServiceImp implements UserService {
//
//    private final GenericDao<User> userGenericDao;
//
//    public UserServiceImp(GenericDao<User> userGenericDao) {
//        this.userGenericDao = userGenericDao;
//    }
//
//
//    @Transactional
//    public User createUser(User user) {
//        userGenericDao.create(user);
//        return user;
//    }
//
//
//    @Transactional
//    public User readUser(int id) {
//        return userGenericDao.readId(id);
//    }
//
//
//    @Transactional
//    public List<User> readAllUsers() {
//        return userGenericDao.readAll();
//    }
//
//
//    @Transactional
//    public void updateUser(User user) {
//        userGenericDao.update(user);
//    }
//
//
//    @Transactional
//    public void deleteUser(Integer id) {
//
//        userGenericDao.delete(id);
//
//    }
//
//
//
//
//}
