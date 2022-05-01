package org.justinhoang.service;

import java.util.List;

import org.justinhoang.entity.User;
import org.justinhoang.exception.ResourceNotFoundException;
import org.justinhoang.persistence.UserRepo;
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
    private UserRepo userRepo;

    @Override
    @Transactional
    public void createUser(User user)
    {
        userRepo.save(user);
    }

    @Override
    @Transactional
    public User readUser(Long id) throws ResourceNotFoundException
    {
        return userRepo.findById(id)
                       .orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public List<User> readUsers()
    {
        return userRepo.findAll();
    }

    @Override
    @Transactional
    public void updateUser(User user)
    {
        userRepo.save(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id)
    {
        userRepo.deleteById(id);
    }

}
