package xin.qust.platform.domain.kbqa;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "kbqa_question_intent")
public class KbqaQuestionIntent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "kbqa_question_tag_intent", joinColumns = @JoinColumn(name = "question_intent_id"), inverseJoinColumns =  @JoinColumn(name = "question_text_id"))
    private Set<KbqaQuestionText> kbqaQuestionTexts;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<KbqaQuestionText> getKbqaQuestionTexts() {
        return kbqaQuestionTexts;
    }

    public void setKbqaQuestionTexts(Set<KbqaQuestionText> kbqaQuestionTexts) {
        this.kbqaQuestionTexts = kbqaQuestionTexts;
    }
}
