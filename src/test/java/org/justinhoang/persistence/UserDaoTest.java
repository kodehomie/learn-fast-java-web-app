//package org.justinhoang.persistence;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.justinhoang.entity.User;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Transactional
//@Test
//public class UserDaoTest {
//
//    private SessionFactory sessionFactory;
//    private final Logger logger = LogManager.getLogger(this.getClass());
//    Transaction transaction = null;
//
//    GenericDAO genericDAO;
//
//    @BeforeEach
//    protected void setUp() throws Exception {
//        // A SessionFactory is set up once for an application!
//        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//                .configure() // configures settings from hibernate.cfg.xml
//                .build();
//        try {
//            sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
//        }
//        catch (Exception e) {
//            // The registry would be destroyed by the SessionFactory, but
//            // there was trouble building the SessionFactory
//            // so destroy it manually.
//            StandardServiceRegistryBuilder.destroy( registry );
//        }
//    }
//
//    @AfterEach
//    protected void tearDown() throws Exception {
//        if ( sessionFactory != null ) {
//            sessionFactory.close();
//        }
//    }
//
//    @SuppressWarnings("unchecked")
//    public void testBasicUsage() {
//        // create a couple of users...
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        session.save( new User( "test0", "test0", "test0@gmail.com", "test0",
//                "test0") );
//        session.save( new User( "test1", "test1", "test1@gmail.com", "test1",
//                "test1") );
//        session.getTransaction().commit();
//        session.close();
//
//        // now lets pull events from the database and list them
//        session = sessionFactory.openSession();
//        session.beginTransaction();
//        List result = session.createQuery( "from User" ).list();
//        for ( User user : (List<User>) result ) {
//            logger.info( "User (" + user.getFirstName() + ") : " + user.getLastName());
//        }
//        session.getTransaction().commit();
//        session.close();
//    }
//}
