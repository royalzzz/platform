package xin.qust.platform.domain.kbqa;

import javax.persistence.*;

@Entity
@Table(name = "kbqa_question_intent_tag")
public class KbqaQuestionIntentTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long kbqaQuestionTextId;

    private Long kbqaQuestionIntentId;

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

    public Long getKbqaQuestionIntentId() {
        return kbqaQuestionIntentId;
    }

    public void setKbqaQuestionIntentId(Long kbqaQuestionIntentId) {
        this.kbqaQuestionIntentId = kbqaQuestionIntentId;
    }
}
