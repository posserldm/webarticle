package posserldm.webarticle.controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import posserldm.webarticle.dao.UserDao;
import posserldm.webarticle.dao.UserDaoImpl;
import posserldm.webarticle.model.User;

public class RegisterAction extends ActionSupport implements ModelDriven<User> {

    private User user = new User();
    private String repasswd;

    @Override
    public String execute() throws Exception {
        UserDao dao = new UserDaoImpl();
        dao.add(user);
        return SUCCESS;
    }

    @Override
    public void validate() {
        UserDao dao = new UserDaoImpl();
        User DBUser = dao.findByName(user.getUsername());
        if (!user.getUsername().isEmpty() && DBUser != null) {
            addFieldError("nameError", "用户名已存在！");
        } else if (!user.getPasswd().isEmpty() && !user.getPasswd().equals(repasswd)) {
            addFieldError("passwdError", "两次输入密码的不一致！");
        }
    }

    @Override
    public User getModel() {
        return user;
    }

    public String getRepasswd() {
        return repasswd;
    }

    public void setRepasswd(String repasswd) {
        this.repasswd = repasswd;
    }

}
