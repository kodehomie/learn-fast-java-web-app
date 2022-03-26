package org.justinhoang.service;

import org.justinhoang.entity.User;
import org.justinhoang.persistence.GenDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

@Service
public class GenServiceImp<T> implements GenService
{
    @Autowired
    private GenDao genDao;

    @Override
    @Transactional
    public void create(Object o)
    {
        genDao.create(o);
    }

    @Override
    @Transactional
    public T readId(Long id)
    {
        return (T) genDao.readId(id);
    }

    @Override
    @Transactional
    public List<T> readAll()
    {
        return genDao.readAll();
    }

    @Override
    @Transactional
    public void update(Object o)
    {
        genDao.update((Serializable) o);
    }

    @Override
    @Transactional
    public void delete(Long id)
    {
        genDao.delete(id);
    }
}
