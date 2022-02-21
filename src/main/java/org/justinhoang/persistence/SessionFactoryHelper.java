package org.justinhoang.persistence;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/** The type Session factory. */
public class SessionFactoryHelper {

    private static SessionFactory sessionFactory;

  /** Instantiates a new Session factory helper. */
  private SessionFactoryHelper() {}

  /**
   * Sets up.
   *
   * @throws Exception the exception
   */
  protected static void setUp() throws Exception {
        // A SessionFactory is set up once for an application!
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        try {
            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
        }
        catch (Exception e) {
            // The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
            // so destroy it manually.
            StandardServiceRegistryBuilder.destroy( registry );
        }
    }

  /**
   * Gets session factory.
   *
   * @return the session factory
   * @throws Exception the exception
   */
  public static SessionFactory getSessionFactory() throws Exception {
        if (sessionFactory == null) {
            setUp();
        }
        return sessionFactory;
    }


}
