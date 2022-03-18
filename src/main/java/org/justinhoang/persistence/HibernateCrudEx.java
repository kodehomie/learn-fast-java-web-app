//package org.justinhoang.persistence;
//
//import org.hibernate.Session;
//import org.justinhoang.entity.User;
//import org.justinhoang.util.HibernateUtil;
//
//public class HibernateCrudEx
//{
//    public static void main(String[] args)
//    {
//        HibernateCrudEx.createRecord();
//        HibernateCrudEx.readRecord();
//        HibernateCrudEx.updateRecord();
//        HibernateCrudEx.deleteRecord();
//    }
//
//    public static void createRecord()
//    {
//        Session sess = HibernateUtil.beginTransaction();
//        User    user = new User();
//        user.setPassword("password");
//        sess.persist(user);
//        HibernateUtil.commitTransaction(sess);
//    }
//
//    public static void readRecord()
//    {
//        Session sess = HibernateUtil.beginTransaction();
//        User    user = sess.find(User.class, Long.valueOf(2));
//        HibernateUtil.commitTransaction(sess);
//    }
//
//    public static void updateRecord()
//    {
//        Session sess = HibernateUtil.beginTransaction();
//        User    user = sess.find(User.class, Long.valueOf(2));
//        user.setPassword("updated-password");
//        HibernateUtil.commitTransaction(sess);
//    }
//
//    public static void deleteRecord()
//    {
//        Session sess = HibernateUtil.beginTransaction();
//        User    user = sess.find(User.class, Long.valueOf(2));
//        sess.remove(user);  //record deletion
//        HibernateUtil.commitTransaction(sess);
//    }
//}
