package xin.qust.platform.model.vo;

import xin.qust.platform.domain.kbqa.KbqaQuestionIntent;
import xin.qust.platform.domain.kbqa.KbqaQuestionType;

import java.util.Date;
import java.util.List;

public class KbqaQuestionTextVo {

    private Long id;

    private String text;

    private Date createTime;

    private Date createTimeStr;

    private Long createdByUserId;

    private String createdByUserName;

    private List<KbqaQuestionIntent> kbqaQuestionIntents;

    private List<KbqaQuestionType> kbqaQuestionTypes;

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

    public Date getCreateTimeStr() {
        return createTimeStr;
    }

    public void setCreateTimeStr(Date createTimeStr) {
        this.createTimeStr = createTimeStr;
    }

    public Long getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(Long createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public String getCreatedByUserName() {
        return createdByUserName;
    }

    public void setCreatedByUserName(String createdByUserName) {
        this.createdByUserName = createdByUserName;
    }

    public List<KbqaQuestionIntent> getKbqaQuestionIntents() {
        return kbqaQuestionIntents;
    }

    public void setKbqaQuestionIntents(List<KbqaQuestionIntent> kbqaQuestionIntents) {
        this.kbqaQuestionIntents = kbqaQuestionIntents;
    }

    public List<KbqaQuestionType> getKbqaQuestionTypes() {
        return kbqaQuestionTypes;
    }

    public void setKbqaQuestionTypes(List<KbqaQuestionType> kbqaQuestionTypes) {
        this.kbqaQuestionTypes = kbqaQuestionTypes;
    }
}
