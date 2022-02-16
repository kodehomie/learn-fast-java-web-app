package org.justinhoang.util;

import org.justinhoang.persistence.GenericDao;

public class DaoFactory {

    private DaoFactory() {

    }

    public static GenericDao createDAO(Class type) {
        return new GenericDao(type);

    }
}
