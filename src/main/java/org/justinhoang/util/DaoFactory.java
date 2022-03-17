package org.justinhoang.util;

import org.justinhoang.persistence.GenericDao;

public class DaoFactory
{

    private DaoFactory()
    {

    }

    public static GenericDao<?> createDao(Class<?
            extends Object> type)
    {
        return new GenericDao<>(type);

    }
}
