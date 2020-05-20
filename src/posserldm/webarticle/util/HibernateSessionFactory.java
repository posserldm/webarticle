package posserldm.webarticle.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {

    private static SessionFactory factory = null;
    private static ThreadLocal<Session> local = null;

    static {
        Configuration cfg = new Configuration().configure();
        factory = cfg.buildSessionFactory();
        local = new ThreadLocal<>();
    }

    /**
     * 得到一个Session对象
     * @return session
     */
    public static Session getSession() {
        if (local.get() == null) {
            Session session = factory.openSession();
            local.set(session);
        }
        return local.get();
    }

    /**
     * 关闭Session对象
     */
    public static void closeSession() {
        if (local != null) {
            Session session = local.get();
            session.close();
            local.remove();
        }
    }
}
