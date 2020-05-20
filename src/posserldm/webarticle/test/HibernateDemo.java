package posserldm.webarticle.test;

import org.junit.Test;
import posserldm.webarticle.dao.UserDao;
import posserldm.webarticle.dao.UserDaoImpl;
import posserldm.webarticle.model.User;

import java.util.List;

/**
 * 测试UserDao
 */
public class HibernateDemo {

    @Test
    public void tFindAll() {
        UserDao dao = new UserDaoImpl();
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void tFindByName() {
        UserDao dao = new UserDaoImpl();
        User user = dao.findByName("root");
        System.out.println(user);
    }

    @Test
    public void tUpdatePassword() {
        UserDao dao = new UserDaoImpl();
        dao.updatePasswordByName("ldm", "456789");
        User user = dao.findByName("ldm");
        System.out.println(user);
    }

    @Test
    public void tAdd() {
        User user = new User();
        user.setUsername("username");
        user.setPasswd("123456");
        UserDao dao = new UserDaoImpl();
        dao.add(user);
    }

    @Test
    public void tDelete() {
        UserDao dao = new UserDaoImpl();
        dao.deleteByName("ldm");
        List<User> list = dao.findAll();
        for (User user : list) {
            System.out.println(user);
        }
    }
}
