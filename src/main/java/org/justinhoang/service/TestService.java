package org.justinhoang.service;

import org.justinhoang.entity.Test;
import org.justinhoang.persistence.GenDaoInt;
import org.springframework.beans.factory.annotation.Autowired;

public class TestService
{
    GenDaoInt<Test> dao;

    @Autowired
    public void setDao(GenDaoInt<Test> dao) {
        dao = dao;
        dao.setClassx(Test.class);
    }
}
