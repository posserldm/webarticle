package posserldm.webarticle.test;

import org.junit.Test;
import posserldm.webarticle.dao.ArticleDao;
import posserldm.webarticle.dao.ArticleDaoImpl;
import posserldm.webarticle.model.Article;

import java.util.Date;
import java.util.List;

/**
 * 测试ArticleDao
 */
public class HibernateDemo2 {

    @Test
    public void tFindAll() {
        ArticleDao dao = new ArticleDaoImpl();
        List<Article> list = dao.findAll();
        for (Article article : list) {
            System.out.println(article);
        }
    }

    @Test
    public void tAdd() {
        ArticleDao dao = new ArticleDaoImpl();
        Article article = new Article();
        article.setArticle("test");
        article.setPublicTime(new Date());
        article.setUsername("ldm");
        dao.add(article);
    }

    @Test
    public void tDeleteByName() {
        ArticleDao dao = new ArticleDaoImpl();
        dao.deleteByName("root");
    }

    @Test
    public void tDeleteById() {
        ArticleDao dao = new ArticleDaoImpl();
        dao.deleteById(10);
    }

    @Test
    public void tUpdate() {
        ArticleDao dao = new ArticleDaoImpl();
        Article article = dao.findById(5);
        article.setArticle("update");
        dao.update(article);
    }

}
