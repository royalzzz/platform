package xin.qust.platform.domain.yuqing;

import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "yuqing_originnews")
public class YuqingOriginnews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String news_title;
    private String news_link;
    private String news_author;
    private Long news_timeStamp;
    private String news_comments_link;
    private String news_comments;
    private String news_site;
    private String image_url;
    private String origin_weibo;
    private String news_content;
    private String exception;

    @ManyToMany(targetEntity = NewsCla.class, fetch = FetchType.EAGER)
    @JoinTable(name = "yuqing_news_has_cla", joinColumns = @JoinColumn(name = "news_id"), inverseJoinColumns = @JoinColumn(name = "claid"))
    private Set<NewsCla> claset;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNews_title() {
        return news_title;
    }

    public void setNews_title(String news_title) {
        this.news_title = news_title;
    }

    public String getNews_link() {
        return news_link;
    }

    public void setNews_link(String news_link) {
        this.news_link = news_link;
    }

    public String getNews_author() {
        return news_author;
    }

    public void setNews_author(String news_author) {
        this.news_author = news_author;
    }

    public Long getNews_timeStamp() {
        return news_timeStamp;
    }

    public void setNews_timeStamp(Long news_timeStamp) {
        this.news_timeStamp = news_timeStamp;
    }

    public String getNews_comments_link() {
        return news_comments_link;
    }

    public void setNews_comments_link(String news_comments_link) {
        this.news_comments_link = news_comments_link;
    }

    public String getNews_comments() {
        return news_comments;
    }

    public void setNews_comments(String news_comments) {
        this.news_comments = news_comments;
    }

    public String getNews_site() {
        return news_site;
    }

    public void setNews_site(String news_site) {
        this.news_site = news_site;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getOrigin_weibo() {
        return origin_weibo;
    }

    public void setOrigin_weibo(String origin_weibo) {
        this.origin_weibo = origin_weibo;
    }

    public String getNews_content() {
        return news_content;
    }

    public void setNews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public Set<NewsCla> getClaset() {
        return claset;
    }

    public void setClaset(Set<NewsCla> claset) {
        this.claset = claset;
    }
}
