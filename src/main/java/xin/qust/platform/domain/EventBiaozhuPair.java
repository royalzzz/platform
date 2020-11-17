package xin.qust.platform.domain;
import javax.persistence.*;

@Entity
@Table(name = "event_biaozhu_pair")
public class EventBiaozhuPair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String anli;

    private String biaozhun;
//  source取值：0-案例树；1-事故报告
    private Long source;

    private Long sourceid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAnli() {
        return anli;
    }

    public void setAnli(String anli) {
        this.anli = anli;
    }

    public String getBiaozhun() {
        return biaozhun;
    }

    public void setBiaozhun(String biaozhun) {
        this.biaozhun = biaozhun;
    }
    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

    public Long getSourceid() {
        return sourceid;
    }

    public void setSourceid(Long sourceid) {
        this.sourceid = sourceid;
    }

}
