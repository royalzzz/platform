package xin.qust.platform.domain.event;

import javax.persistence.*;
import java.util.Date;

//事理图谱-标准图标注
@Entity
@Table(name = "event_node_biaozhupair")
public class EventNodeBiaozhuPair {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String node;
    private Long nodeid;
    private String biaozhutext;
    private String adduser;
    private Date addtime;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNode() {
        return node;
    }

    public void setNode(String node) {
        this.node = node;
    }

    public Long getNodeid() {
        return nodeid;
    }

    public void setNodeid(Long nodeid) {
        this.nodeid = nodeid;
    }

    public String getBiaozhutext() {
        return biaozhutext;
    }

    public void setBiaozhutext(String biaozhutext) {
        this.biaozhutext = biaozhutext;
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
