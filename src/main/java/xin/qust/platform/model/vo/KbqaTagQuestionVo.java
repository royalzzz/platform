package xin.qust.platform.model.vo;

import java.util.List;

public class KbqaTagQuestionVo {

    private String text;

    private Long []questionTypes;

    private Long []questionIntents;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Long[] getQuestionTypes() {
        return questionTypes;
    }

    public void setQuestionTypes(Long[] questionTypes) {
        this.questionTypes = questionTypes;
    }

    public Long[] getQuestionIntents() {
        return questionIntents;
    }

    public void setQuestionIntents(Long[] questionIntents) {
        this.questionIntents = questionIntents;
    }
}
