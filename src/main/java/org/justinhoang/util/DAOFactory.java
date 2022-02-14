package org.justinhoang.util;

import org.justinhoang.persistence.GenericDAO;

public class DAOFactory {

    private DAOFactory() {

    }

    public static GenericDAO createDAO(Class type) {
        return new GenericDAO(type);

    }
}
