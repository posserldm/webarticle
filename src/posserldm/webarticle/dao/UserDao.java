package posserldm.webarticle.dao;

import posserldm.webarticle.model.User;
import java.util.List;

public interface UserDao {
    /**
     * 找到所有的用户
     * @return 返回一个List对象
     */
    List<User> findAll();

    /**
     * 通过用户名来找到用户
     * @param name 用户名
     * @return 返回一个User对象
     */
    User findByName(String name);

    /**
     * 删除一个用户
     * @param name 用户名
     */
    void deleteByName(String name);

    /**
     * 通过用户名来修改密码
     * @param name 用户名
     * @param newPassword 新的密码
     */
    void updatePasswordByName(String name, String newPassword);

    /**
     * 添加一个用户
     * @param user 要包括用户名和密码
     */
    void add(User user);

}
