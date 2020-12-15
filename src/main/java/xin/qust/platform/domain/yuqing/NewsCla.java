package xin.qust.platform.domain.yuqing;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "yuqing_newscla")
@DynamicUpdate
public class NewsCla {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String claname;
    private int clacode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaname() {
        return claname;
    }

    public void setClaname(String claname) {
        this.claname = claname;
    }

    public int getClacode() {
        return clacode;
    }

    public void setClacode(int claCode) {
        this.clacode = claCode;
    }
}
