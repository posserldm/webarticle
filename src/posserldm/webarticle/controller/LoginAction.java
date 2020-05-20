package posserldm.webarticle.controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import posserldm.webarticle.dao.ArticleDao;
import posserldm.webarticle.dao.ArticleDaoImpl;
import posserldm.webarticle.dao.UserDao;
import posserldm.webarticle.dao.UserDaoImpl;
import posserldm.webarticle.model.Article;
import posserldm.webarticle.model.User;

import java.util.List;
import java.util.Map;

public class LoginAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();

    @Override
    public String execute() throws Exception {
        ActionContext context = ActionContext.getContext();
        Map<String, Object> session = context.getSession();
        session.put("user", user);
        ArticleDao dao = new ArticleDaoImpl();
        List<Article> articles = dao.findAll();
        session.put("articles", articles);
        return SUCCESS;
    }

    @Override
    public void validate() {
        UserDao dao = new UserDaoImpl();
        User DBUser = dao.findByName(user.getUsername());
        if (user.getUsername().isEmpty() && !user.getPasswd().isEmpty()) {
            addFieldError("nameEmpty", "用户名不能为空!");
        } else if (!user.getUsername().isEmpty() && DBUser == null) {
            addFieldError("existError", "用户名不存在！");
        } else if (!user.getPasswd().isEmpty() && DBUser.getPasswd().equals(user.getPasswd()) == false) {
            addFieldError("passwdError","密码不正确！");
        }
    }

    @Override
    public User getModel() {
        return user;
    }
}
