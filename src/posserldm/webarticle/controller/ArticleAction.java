package posserldm.webarticle.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import posserldm.webarticle.dao.ArticleDao;
import posserldm.webarticle.dao.ArticleDaoImpl;
import posserldm.webarticle.model.Article;
import posserldm.webarticle.model.User;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class ArticleAction extends ActionSupport {

    private String text;
    private Integer id;

    @Override
    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = context.getSession();
        User user = (User)session.get("user");
        if (user == null) {
            return LOGIN;
        }
        Article article = new Article();
        article.setUsername(user.getUsername());
        article.setArticle(text);
        article.setPublicTime(new Date());
        ArticleDao dao = new ArticleDaoImpl();
        dao.add(article);
        List<Article> articles = (List<Article>)session.get("articles");
        articles.add(0,  article);
        return SUCCESS;
    }

    public String delete() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        if (id != null) {
            ArticleDao dao = new ArticleDaoImpl();
            dao.deleteById(id);
            List<Article> articles = (List<Article>)session.get("articles");
            for (Article article : articles) {
                if (article.getId() == id) {
                    articles.remove(article);
                    break;
                }
            }
        }
        return SUCCESS;
    }

    public String logout() throws Exception {
        Map<String, Object> session = ActionContext.getContext().getSession();
        session.clear();
        return SUCCESS;
    }

    public void validateExecute() {
        Map<String, Object> session = ActionContext.getContext().getSession();
        Object user = session.get("user");
        if (user != null && text.isEmpty()) {
            addFieldError("txtError", "请输入内容！");
        } else if (text.length() > 200) {
            addFieldError("txtError", "内容的长度太长！");
        }
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
