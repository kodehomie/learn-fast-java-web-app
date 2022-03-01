//package org.justinhoang.persistence;
//
//import javax.sql.DataSource;
//
//import jakarta.persistence.criteria.CriteriaBuilder;
//import jakarta.persistence.criteria.CriteriaQuery;
//import jakarta.persistence.criteria.Root;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.Transaction;
//import org.justinhoang.util.HibernateUtil;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.dao.DataAccessException;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.justinhoang.entity.User;
//
//import java.util.List;
//
//public class UserDaoImpl2 implements UserDao {
//
//
//    private final Logger logger = LogManager.getLogger(this.getClass());
//
//    SessionFactory sesFactory = HibernateUtil.getSessionFactory();
//
//    private JdbcTemplate jdbcTemplate;
//
//    public UserDaoImpl2(DataSource dataSource) {
//        jdbcTemplate = new JdbcTemplate(dataSource);
//    }
//
//    @Override
//    public User create(User user) {
//
//        String sql = "INSERT INTO 'user' VALUES(?,?,?,?,?,?,?,?,?,?)";
//
//        try {
//
//            int temp = (jdbcTemplate.update(sql, new Object[]{user.getId(), user.getBirthdate(), user.getFirstName(), user.getFirstName(), user.getEmail(), user.getPhone(), user.getUsername(), user.getPassword(), user.getCreateTime(), user.getUpdateTime()}));
//
//        } catch (DataAccessException e) {
//            e.printStackTrace();
//        }
//        return user;
//    }
//
////    public Long create(User user) {
////        String insertSql = "INSERT INTO `user` (birthdate, first_name, last_name, email, phone, password, create_time, update_time)"
////                + " VALUES(?,?,?,?,?,?)";
////
////        KeyHolder keyHolder = new GeneratedKeyHolder();
////
////        jdbcTemplate.update(connection -> {
////
////            PreparedStatement ps = connection.prepareStatement(insertSql, new String[]{"ID"});
////            ps.setDate(1, new java.sql.Date(user.getBirthdate().getTime()));
////            ps.setString(2, user.getFirstName());
////            ps.setString(3, user.getLastName());
////            ps.setString(4, user.getEmail());
////            ps.setString(5, user.getPhone());
////            ps.setString(6, user.getPassword());
////            ps.setDate(7, new java.sql.Date(user.getCreateTime().getTime()));
////            ps.setDate(8, user.getUpdateTime() == null ? null : new java.sql.Date(user.getUpdateTime().getTime()));
////            return ps;
////
////        }, keyHolder);
////
////        return keyHolder.getKey().longValue();
////    }
//
//    @Override
//    public User readID(long id) {
//        Session session = sesFactory.openSession();
//        User user = session.get(User.class, id);
//        session.close();
//        return user;
//    }
//
//    @Override
//    public List<User> readAll() {
//        Session session = sesFactory.openSession();
//        CriteriaBuilder builder = session.getCriteriaBuilder();
//        CriteriaQuery<User> query = builder.createQuery(User.class);
//        Root<User> root = query.from(User.class);
//        List<User> users = session.createQuery(query).getResultList();
//        session.close();
//        return users;
//    }
//
//    @Override
//    public void update(User user) {
//        Session session = sesFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        session.merge(user);
//        transaction.commit();
//        session.close();
//    }
//
//    @Override
//    public void delete(long id) {
//
//    }
//
//
//    @Override
//    public Long createUser(User user) {
//        return null;
//    }
//
//    @Override
//    public String signInUser(User user) {
//
//        String sql = "SELECT username FROM user WHERE username=? AND password=?";
//
//        try {
//
//            String username = jdbcTemplate.queryForObject(sql, new Object[]{
//                    user.getUsername(), user.getPassword()}, String.class);
//
//            return username;
//
//        } catch (Exception e) {
//            return null;
//        }
//    }
//
//}
