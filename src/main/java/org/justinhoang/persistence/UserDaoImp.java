package org.justinhoang.persistence;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.justinhoang.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao
{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void createUser(User user)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(user);
    }

    @Override
    public User readUser(Long id)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        User    user        = currentSession.get(User.class, id);
        return user;
    }

    @Override
    public List<User> readUsers()
    {
        Session session = sessionFactory.getCurrentSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<User> cq   = cb.createQuery(User.class);
        Root<User>          root = cq.from(User.class);
        cq.select(root);
        Query query = session.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public void deleteUser(Long id)
    {
        Session session = sessionFactory.getCurrentSession();
        User    user    = session.byId(User.class).load(id);
        session.delete(user);
    }


}
