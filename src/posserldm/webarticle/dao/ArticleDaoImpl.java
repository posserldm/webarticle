package posserldm.webarticle.dao;


import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import posserldm.webarticle.model.Article;
import posserldm.webarticle.util.HibernateSessionFactory;

import java.util.List;

public class ArticleDaoImpl implements ArticleDao {

    private static boolean DELETE = true;
    private static boolean UPDATE = false;

    private List<Article> find(String HQL) {
        Session session = HibernateSessionFactory.getSession();
        Query query = session.createQuery(HQL);
        List<Article> list = query.list();
        HibernateSessionFactory.closeSession();
        return list;
    }

    private void updateOrDelete(Article article, boolean option) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            if (option == UPDATE) {
                session.update(article);
            } else {
                session.delete(article);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            throw new RuntimeException("更新或删除失败!");
        } finally {
            HibernateSessionFactory.closeSession();
        }

    }

    @Override
    public List<Article> findAll() {
        String HQL = "from Article order by publicTime desc";
        return find(HQL);
    }

    @Override
    public void deleteById(Integer id) {
        if (id == null) {
            throw new RuntimeException("删除失败！");
        }
        Article article = findById(id);
        updateOrDelete(article, DELETE);
    }

    @Override
    public void deleteByName(String name) {
        if (name == null) {
            throw new RuntimeException("删除失败！");
        }
        String HQL = "from Article where username = \'" + name + '\'';
        List<Article> articles = find(HQL);
        for (Article article : articles) {
            updateOrDelete(article, DELETE);
        }
    }

    @Override
    public void update(Article article) {
        if (article == null) {
            throw new RuntimeException("更新失败!");
        }
        updateOrDelete(article, UPDATE);
    }

    @Override
    public void add(Article article) {
        Session session = HibernateSessionFactory.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(article);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            throw new RuntimeException("添加失败！");
        } finally {
            HibernateSessionFactory.closeSession();
        }
    }

    @Override
    public Article findById(Integer id) {
        String HQL = "from Article where id = " + id;
        return find(HQL).get(0);
    }
}
