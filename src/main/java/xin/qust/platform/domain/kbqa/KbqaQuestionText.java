package xin.qust.platform.domain.kbqa;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "kbqa_question_text")
public class KbqaQuestionText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Date createTime;

    private Long createdByUserId;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "kbqa_question_tag_type", joinColumns = @JoinColumn(name = "question_text_id"), inverseJoinColumns =  @JoinColumn(name = "question_type_id"))
    private Set<KbqaQuestionType> kbqaQuestionTypes;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "kbqa_question_tag_intent", joinColumns = @JoinColumn(name = "question_text_id"), inverseJoinColumns =  @JoinColumn(name = "question_intent_id"))
    private Set<KbqaQuestionIntent> kbqaQuestionIntents;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public Set<KbqaQuestionType> getKbqaQuestionTypes() {
        return kbqaQuestionTypes;
    }

    public void setKbqaQuestionTypes(Set<KbqaQuestionType> kbqaQuestionTypes) {
        this.kbqaQuestionTypes = kbqaQuestionTypes;
    }

    public Set<KbqaQuestionIntent> getKbqaQuestionIntents() {
        return kbqaQuestionIntents;
    }

    public void setKbqaQuestionIntents(Set<KbqaQuestionIntent> kbqaQuestionIntents) {
        this.kbqaQuestionIntents = kbqaQuestionIntents;
    }
}
