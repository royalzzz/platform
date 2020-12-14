package xin.qust.platform.domain.kbqa;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "kbqa_question_type_tag")
public class KbqaQuestionTypeTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long kbqaQuestionTextId;

    private Long kbqaQuestionTypeId;

    private Date createTime;

    private Long createdByUserId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getKbqaQuestionTextId() {
        return kbqaQuestionTextId;
    }

    public void setKbqaQuestionTextId(Long kbqaQuestionTextId) {
        this.kbqaQuestionTextId = kbqaQuestionTextId;
    }

    public Long getKbqaQuestionTypeId() {
        return kbqaQuestionTypeId;
    }

    public void setKbqaQuestionTypeId(Long kbqaQuestionTypeId) {
        this.kbqaQuestionTypeId = kbqaQuestionTypeId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }
}
