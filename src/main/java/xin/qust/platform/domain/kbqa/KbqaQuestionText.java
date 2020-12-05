package xin.qust.platform.domain.kbqa;

import javax.persistence.*;

@Entity
@Table(name = "kbqa_question_text")
public class KbqaQuestionText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

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
}
