//package org.justinhoang.persistence;
//
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.justinhoang.entity.User;
//
//import java.util.Date;
//import java.util.List;
//
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
//import javax.persistence.Persistence;
//import javax.persistence.Query;
//import javax.persistence.TypedQuery;
//import javax.persistence.criteria.CriteriaBuilder;
//import javax.persistence.criteria.CriteriaQuery;
//import javax.persistence.criteria.Expression;
//import javax.persistence.criteria.ParameterExpression;
//import javax.persistence.criteria.Predicate;
//import javax.persistence.criteria.Root;
//
//public class JpaCrudEx
//{
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    public static void main(String[] args) throws Exception
//    {
//
//        ///DbMachine.main(null);
//        JpaCrudEx.createRecord();
//        //JpaCrudEx.retrieveRecord();
//        //JpaCrudEx.updateRecord();
//        //JpaCrudEx.deleteRecord();
//
//        //JpaCrudEx.criteriaQuery();
//        //criteriaVerifiedUsersQuery();
//        //criteriaFuzzyEmail();
//        //criteriaBetweenDates();
//        //criteriaLoginNameAndPassword();
//        //criteriaFindByCommonPassword();
//        //criteriaCountQuery();
//        //findByFuzzyNamedQuery();
//        //persistMergeRecord();
//    }
//
//    public static void createRecord()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager entityManager = emf.createEntityManager();
//        entityManager.getTransaction().begin();
//        User p = new User();
//        p.setPassword("random-password");
//        entityManager.persist(p);
//        entityManager.getTransaction().commit();
//
//    }
//
//    public void persistMergeRecord()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        User user1 = new User();
//        user1.setPassword("password1");
//        em.persist(user1);
//        em.flush();
//        em.detach(user1);
//        em.flush();
//        logger.info(user1.getId());
//        User user2 = em.find(User.class, user1.getId());
//        user1.setVerified(true);
//        user2.setVerified(false);
//        logger.info("The instances are the same? ");
//        logger.info(user1.equals(user2));
//        try
//        {
//            em.persist(user1);
//        }
//        catch (Exception e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        try
//        {
//            em.refresh(user1);
//        }
//        catch (Exception e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//        try
//        {
//            em.merge(user1);
//        }
//        catch (Exception e)
//        {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//        em.getTransaction().commit();
//
//    }
//
//    public void retrieveRecord()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager entityManager = emf.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        Long key  = Long.valueOf(1);
//        User user = entityManager.find(User.class, key);
//        logger.info(user.getPassword());
//
//        entityManager.getTransaction().commit();
//    }
//
//    public void updateRecord()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager entityManager = emf.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        Long key = Long.valueOf(1);
//        User p   = entityManager.find(User.class, Long.valueOf(1));
//        p.setPassword("password");
//
//        entityManager.getTransaction().commit();
//    }
//
//    public void deleteRecord()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager entityManager = emf.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        Long key = Long.valueOf(1);
//        User p   = entityManager.find(User.class, key);
//        entityManager.remove(p); // record is deleted
//
//        entityManager.getTransaction().commit();
//    }
//
//    public void queryRecords()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager entityManager = emf.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        Query query = entityManager.createQuery(
//                "select distinct u from User " + "as u", User.class);
//
//        List<User> users = query.getResultList();
//
//        for (User user : users)
//        {
//            logger.info("The password is :" + user.getPassword());
//        }
//
//        for (int i = 0; i < users.size(); i++)
//        {
//            User user = users.get(i);
//            logger.info(user.getUsername());
//        }
//        entityManager.flush();
//        //entityManager.detach(arg0);h();
//        entityManager.getTransaction().commit();
//    }
//
//    public void findByNamedQuery()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager entityManager = emf.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        Query query = entityManager.createNamedQuery("user.findByEmail");
//        query.setParameter("email", "addy@host.com");
//        List<User> users = query.getResultList();
//
//        for (User user : users)
//        {
//            logger.info(user);
//        }
//
//        for (int i = 0; i < users.size(); i++)
//        {
//            User user = users.get(i);
//            logger.info(user.getUsername());
//        }
//
//        entityManager.getTransaction().commit();
//    }
//
//    public void findByFuzzyNamedQuery()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager entityManager = emf.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        Query query = entityManager.createNamedQuery("user.findByFuzzyEmail");
//        query.setParameter("email", "%scja%");
//        List<User> users = query.getResultList();
//
//        for (User user : users)
//        {
//            logger.info(user);
//        }
//
//        for (int i = 0; i < users.size(); i++)
//        {
//            User user = users.get(i);
//            logger.info(user.getUsername());
//        }
//        entityManager.getTransaction().commit();
//    }
//
//    public void criteriaQuery()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        CriteriaBuilder     builder = em.getCriteriaBuilder();
//        CriteriaQuery<User> cQuery  = builder.createQuery(User.class);
//
//        Root<User> from = cQuery.from(User.class);
//        cQuery.orderBy(builder.asc(from.get("loginName")));
//
//        TypedQuery<User> query = em.createQuery(cQuery);
//        List<User>       users = query.getResultList();
//        users.forEach(user -> logger.info(user));
//
//        em.getTransaction().commit();
//    }
//
//    public void criteriaCountQuery()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        CriteriaBuilder     builder = em.getCriteriaBuilder();
//        CriteriaQuery<Long> cQuery  = builder.createQuery(Long.class);
//        cQuery.select(builder.count(cQuery.from(User.class)));
//
//        TypedQuery<Long> query = em.createQuery(cQuery);
//        logger.info(query.getSingleResult());
//        em.getTransaction().commit();
//    }
//
//    public void criteriaVerifiedUsersQuery()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        CriteriaBuilder     builder = em.getCriteriaBuilder();
//        CriteriaQuery<User> cQuery  = builder.createQuery(User.class);
//
//        Root<User> root = cQuery.from(User.class);
//
//        ParameterExpression<Boolean> flag       =
//                builder.parameter(Boolean.class);
//        Predicate                    expression =
//                builder.equal(root.get("verified"), flag);
//
//        cQuery.select(root).where(expression);
//
//        TypedQuery<User> query = em.createQuery(cQuery);
//        query.setParameter(flag, true);
//        List<User> users = query.getResultList();
//        users.forEach(user -> logger.info(user.getVerified()));
//
//        em.getTransaction().commit();
//    }
//
//    public void criteriaLoginNameAndPassword()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        CriteriaBuilder     builder = em.getCriteriaBuilder();
//        CriteriaQuery<User> cQuery  = builder.createQuery(User.class);
//
//        Root<User> root = cQuery.from(User.class);
//
//        ParameterExpression<String> password = builder.parameter(String.class);
//        Expression<Boolean> passwordExpression =
//                builder.equal(root.get("password"), password);
//
//        ParameterExpression<String> loginName = builder.parameter(String.class);
//        Expression<Boolean> loginExpression =
//                builder.equal(root.get("loginName"), loginName);
//
//        Predicate loginAndPassword =
//                builder.and(loginExpression, passwordExpression);
//
//        cQuery.select(root).where(loginAndPassword);
//
//        TypedQuery<User> query = em.createQuery(cQuery);
//        query.setParameter(loginName, "loginName");
//        query.setParameter(password, "password");
//        User user = query.getSingleResult();
//        logger.info(user);
//
//        em.getTransaction().commit();
//    }
//
//    public void criteriaFindByCommonPassword()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        CriteriaBuilder     builder = em.getCriteriaBuilder();
//        CriteriaQuery<User> cQuery  = builder.createQuery(User.class);
//
//        Root<User> root = cQuery.from(User.class);
//
//        ParameterExpression<String> password = builder.parameter(String.class);
//        Expression<Boolean> passwordExpression =
//                builder.equal(root.get("password"), password);
//        cQuery.select(root).where(passwordExpression);
//
//        TypedQuery<User> query = em.createQuery(cQuery);
//        query.setParameter(password, "pwd");
//        List<User> users = query.getResultList();
//        users.forEach(user -> logger.info(user.getUsername()));
//
//        em.getTransaction().commit();
//    }
//
//    public void criteriaFuzzyEmail()
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        CriteriaBuilder     builder = em.getCriteriaBuilder();
//        CriteriaQuery<User> cQuery  = builder.createQuery(User.class);
//
//        Root<User> root      = cQuery.from(User.class);
//        Predicate  predicate = builder.like(root.get("emailAddress"), "%scja%");
//
//        cQuery.select(root).where(predicate);
//
//        TypedQuery<User> query = em.createQuery(cQuery);
//        //query.setParameter(email, true);
//        List<User> users = query.getResultList();
//        users.forEach(user -> logger.info(user.getEmail()));
//
//        em.getTransaction().commit();
//    }
//
//    public void criteriaBetweenDates() throws Exception
//    {
//        EntityManagerFactory emf =
//                Persistence.createEntityManagerFactory("persistenceUnitName");
//        EntityManager em = emf.createEntityManager();
//        em.getTransaction().begin();
//
//        CriteriaBuilder     builder = em.getCriteriaBuilder();
//        CriteriaQuery<User> cQuery  = builder.createQuery(User.class);
//
//        Root<User> root = cQuery.from(User.class);
//
//        ParameterExpression<String> email = builder.parameter(String.class);
//        //Predicate predicate = builder.like(root.get("emailAddress"),
//        // "%scja%");
//        java.text.SimpleDateFormat textFormat =
//                new java.text.SimpleDateFormat("yyyy-MM-dd");
//        Date startDate = new Date();
//        startDate = textFormat.parse("2022-1-1");
//
//        Date endDate = new Date();
//        startDate = textFormat.parse("2022-1-1");
//
//        Predicate predicate =
//                builder.between(root.get("lastAccessTime"), startDate, endDate);
//        //predicate.add(date);
//
//        cQuery.select(root).where(predicate);
//
//        TypedQuery<User> query = em.createQuery(cQuery);
//        //query.setParameter(email, true);
//        List<User> users = query.getResultList();
//        users.forEach(user -> logger.info(user.getLastAccessTime()));
//
//        users = new java.util.ArrayList();
//        //users.add(user);
//
//        em.getTransaction().commit();
//    }
//
//}
