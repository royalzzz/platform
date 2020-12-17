package xin.qust.platform.domain.event;
import javax.persistence.*;
import java.util.Date;

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

    private String adduser;

    private Date addtime;

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
    public Long getSource(int i) {
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

    public Long getSource() {
        return source;
    }

    public String getAdduser() {
        return adduser;
    }

    public void setAdduser(String adduser) {
        this.adduser = adduser;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }
}
