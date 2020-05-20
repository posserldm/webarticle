package posserldm.webarticle.dao;

import posserldm.webarticle.model.Article;

import java.util.List;

public interface ArticleDao {
    /**
     *找到所有的评论
     * @return 一个List对象
     */
    List<Article> findAll();

    /**
     * 删除一条评论
     * @param id 评论的对象
     * @return 成功true,失败false
     */
    void deleteById(Integer id);

    /**
     * 删除指定用户的所有评论
     * @param name 用户名
     * @return 成功true,失败false
     */
    void deleteByName(String name);

    /**
     * 更新一条评论
     * @param article 要更改的评论对象
     * @return 成功true,失败false
     */
    void update(Article article);

    /**
     * 添加一条评论
     * @param article
     */
    void add(Article article);

    /**
     * 通过id找评论
     * @param id
     * @return
     */
    Article findById(Integer id);

}
