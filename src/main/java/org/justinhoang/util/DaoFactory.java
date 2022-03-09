package org.justinhoang.util;

import org.justinhoang.persistence.GenericDao;

public class DaoFactory {

    // Empty constructor is private - static class
    private DaoFactory() {

    }

    public static GenericDao createDao(Class type) {
        return new GenericDao(type);

    }
}
