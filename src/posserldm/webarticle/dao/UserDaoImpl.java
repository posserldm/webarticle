package posserldm.webarticle.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import posserldm.webarticle.model.User;
import posserldm.webarticle.util.HibernateSessionFactory;

import java.util.List;

public class UserDaoImpl implements UserDao {

    private static final boolean UPDATE = true;
    private static final boolean DELETE = false;

    private List<User> find(String HQL) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery(HQL);
        List<User> list = query.list();
        HibernateSessionFactory.closeSession();
        return list;
    }

    private void updateOrDelete(User user, boolean flag) {
        Session session = HibernateSessionFactory.getSession();
        Transaction tx = session.beginTransaction();
        try {
            if (flag == UPDATE) {
                session.update(user);
            } else {
                session.delete(user);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new RuntimeException("您要删除或修改的信息不存在！");
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    @Override
    public List<User> findAll() {
        String HQL = "from User";
        List<User> list = find(HQL);
        return list;
    }

    @Override
    public User findByName(String name) {
        String HQL = "from User where username = \'" + name + "\'";
        User user = null;
        List<User> list = find(HQL);
        if (list.isEmpty() == false) {
           user = list.get(0);
        }
        return user;
    }

    @Override
    public void deleteByName(String name) throws RuntimeException {
        User user = findByName(name);
        updateOrDelete(user, DELETE);
    }

    @Override
    public void updatePasswordByName(String name, String newPassword) throws RuntimeException {
        User user = findByName(name);
        user.setPasswd(newPassword);
        updateOrDelete(user, UPDATE);
    }

    @Override
    public void add(User user) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(user);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            throw new RuntimeException("注册失败！");
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }
}
