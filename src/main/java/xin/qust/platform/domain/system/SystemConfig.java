package xin.qust.platform.domain.system;

import javax.persistence.*;

@Entity
@Table(name = "system_config")
public class SystemConfig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String yuqing_crawler_time_split;
    private String yuqing_crawler_start_time;
    private String yuqing_crawler_keywords;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getYuqing_crawler_time_split() {
        return yuqing_crawler_time_split;
    }

    public void setYuqing_crawler_time_split(String yuqing_crawler_time_split) {
        this.yuqing_crawler_time_split = yuqing_crawler_time_split;
    }

    public String getYuqing_crawler_start_time() {
        return yuqing_crawler_start_time;
    }

    public void setYuqing_crawler_start_time(String yuqing_crawler_start_time) {
        this.yuqing_crawler_start_time = yuqing_crawler_start_time;
    }

    public String getYuqing_crawler_keywords() {
        return yuqing_crawler_keywords;
    }

    public void setYuqing_crawler_keywords(String yuqing_crawler_keywords) {
        this.yuqing_crawler_keywords = yuqing_crawler_keywords;
    }
}
