package org.justinhoang.persistence;

import org.hibernate.Session;

/** The type Dao hibernate factory. */
public class DAOHibernateFactory extends DAOFactory {

    private Session SessionUtil;

    private GenericHibernateDAO instantiateDAO(Class daoClass) {
        try {
            GenericHibernateDAO dao = (GenericHibernateDAO)daoClass.newInstance();
            dao.setSession(getCurrentSession());
            return dao;
        } catch (Exception ex) {
            throw new RuntimeException("Can not instantiate DAO: " + daoClass, ex);
        }
    }

  /**
   * Gets current session.
   *
   * @return the current session
   */
  // You could override this if you don't want HibernateUtil for lookup
  protected Session getCurrentSession() {
        return SessionUtil.getSessionFactory().getCurrentSession();
    }

}
