package posserldm.webarticle.model;

import javax.persistence.Entity;
import java.util.Date;
import java.util.Objects;

@Entity
public class Article {
    private Integer id;
    private String username;
    private String article;
    private Date publicTime;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getPublicTime() {
        return publicTime;
    }

    public void setPublicTime(Date publicTime) {
        this.publicTime = publicTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article1 = (Article) o;
        return id == article1.id &&
                Objects.equals(article, article1.article);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, article);
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", article='" + article + '\'' +
                ", publicTime=" + publicTime +
                '}';
    }
}
