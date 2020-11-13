package xin.qust.platform.domain;
import javax.persistence.*;

@Entity
@Table(name = "event_biaozhu_pair")
public class EventBiaozhuPair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String anli;

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

    private String biaozhun;

}
