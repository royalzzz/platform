package xin.qust.platform.api.kbqa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.domain.kbqa.KbqaQuestionIntent;
import xin.qust.platform.domain.kbqa.KbqaQuestionIntentTag;
import xin.qust.platform.domain.kbqa.KbqaQuestionText;
import xin.qust.platform.domain.kbqa.KbqaQuestionTypeTag;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.vo.KbqaTagInformationVo;
import xin.qust.platform.model.vo.KbqaTagQuestionVo;
import xin.qust.platform.repository.kbqa.*;

@RestController
@RequestMapping("kbqa/question")
public class QuestionApi {

    @Autowired
    private KbqaQuestionTypeRepo kbqaQuestionTypeRepo;

    @Autowired
    private KbqaQuestionIntentRepo kbqaQuestionIntentRepo;

    @Autowired
    private KbqaQuestionTextRepo kbqaQuestionTextRepo;

    @Autowired
    private KbqaQuestionTypeTagRepo kbqaQuestionTypeTagRepo;

    @Autowired
    private KbqaQuestionIntentTagRepo kbqaQuestionIntentTagRepo;


    @RequestMapping("tagInformation")
    public Message tagInformation() {
        KbqaTagInformationVo tagInformationVo = new KbqaTagInformationVo();
        tagInformationVo.setNumberOfQuestionIntent(kbqaQuestionIntentRepo.count());
        tagInformationVo.setNumberOfQuestionIntentTag(kbqaQuestionIntentTagRepo.count());
        tagInformationVo.setNumberOfQuestionTypeTag(kbqaQuestionTypeTagRepo.count());
        tagInformationVo.setNumberOfQuestions(kbqaQuestionTextRepo.count());
        tagInformationVo.setNumberOfQuestionTypes(kbqaQuestionTypeRepo.count());
        return Message.createSuccessMessage(tagInformationVo);
    }

    @RequestMapping("findAllQuestionTypes")
    public Message findAllQuestionTypes() {
        return Message.createSuccessMessage(kbqaQuestionTypeRepo.findAll());
    }

    @RequestMapping("findAllQuestionIntents")
    public Message findAllQuestionIntents() {
        return Message.createSuccessMessage(kbqaQuestionIntentRepo.findAll());
    }

    @RequestMapping("findByTextLike")
    public Message findByTextLike(String text) {
        return Message.createSuccessMessage(kbqaQuestionTextRepo.findByTextContaining(text));
    }

    @RequestMapping("tagQuestion")
    public Message tagQuestion(@RequestBody KbqaTagQuestionVo kbqaTagQuestionVo) {
        KbqaQuestionText kbqaQuestionText = new KbqaQuestionText();
        kbqaQuestionText.setText(kbqaTagQuestionVo.getText());
        kbqaQuestionTextRepo.save(kbqaQuestionText);

        for (Long typeId: kbqaTagQuestionVo.getQuestionTypes()) {
            KbqaQuestionTypeTag kbqaQuestionTypeTag = new KbqaQuestionTypeTag();
            kbqaQuestionTypeTag.setKbqaQuestionTextId(kbqaQuestionText.getId());
            kbqaQuestionTypeTag.setKbqaQuestionTypeId(typeId);
            kbqaQuestionTypeTagRepo.save(kbqaQuestionTypeTag);
        }

        for (Long intentId: kbqaTagQuestionVo.getQuestionIntents()) {
            KbqaQuestionIntentTag kbqaQuestionIntentTag = new KbqaQuestionIntentTag();
            kbqaQuestionIntentTag.setKbqaQuestionTextId(kbqaQuestionText.getId());
            kbqaQuestionIntentTag.setKbqaQuestionIntentId(intentId);
            kbqaQuestionIntentTagRepo.save(kbqaQuestionIntentTag);
        }

        return Message.createSuccessMessage();
    }
}
