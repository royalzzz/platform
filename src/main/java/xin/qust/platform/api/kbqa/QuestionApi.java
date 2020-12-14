package xin.qust.platform.api.kbqa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.domain.kbqa.*;
import xin.qust.platform.domain.user.UserNameLogin;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.vo.KbqaTagInformationVo;
import xin.qust.platform.model.vo.KbqaTagQuestionVo;
import xin.qust.platform.model.vo.PageVo;
import xin.qust.platform.repository.kbqa.*;
import xin.qust.platform.repository.user.UserNameLoginRepo;

import java.security.Principal;
import java.util.*;

@RestController
@RequestMapping("kbqa/question")
public class QuestionApi {

    private final Logger logger = LoggerFactory.getLogger(getClass());

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

    @Autowired
    private UserNameLoginRepo userNameLoginRepo;

    @Autowired
    private KbqaSdsChemicalRepo kbqaSdsChemicalRepo;


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
    public Message tagQuestion(@RequestBody KbqaTagQuestionVo kbqaTagQuestionVo, Principal principal) {
        Optional<UserNameLogin> userNameLogin = userNameLoginRepo.findByUserName(principal.getName());
        if (userNameLogin.isPresent()) {
            KbqaQuestionText kbqaQuestionText = new KbqaQuestionText();
            kbqaQuestionText.setText(kbqaTagQuestionVo.getText());
            kbqaQuestionText.setCreateTime(new Date());
            kbqaQuestionText.setCreatedByUserId(userNameLogin.get().getUserId());
            kbqaQuestionText.setKbqaQuestionIntents(new HashSet<>());
            kbqaQuestionText.setKbqaQuestionTypes(new HashSet<>());

            for (Long typeId : kbqaTagQuestionVo.getQuestionTypes()) {
                Optional<KbqaQuestionType> kbqaQuestionType = kbqaQuestionTypeRepo.findById(typeId);
                kbqaQuestionType.ifPresent(questionType -> kbqaQuestionText.getKbqaQuestionTypes().add(questionType));
            }

            for (Long intentId : kbqaTagQuestionVo.getQuestionIntents()) {
                Optional<KbqaQuestionIntent> kbqaQuestionIntent = kbqaQuestionIntentRepo.findById(intentId);
                kbqaQuestionIntent.ifPresent(questionIntent -> kbqaQuestionText.getKbqaQuestionIntents().add(questionIntent));
            }
            kbqaQuestionTextRepo.save(kbqaQuestionText);
        }

        return Message.createSuccessMessage();
    }

    @RequestMapping("tagBatchQuestion")
    public Message tagBatchQuestion(@RequestBody KbqaTagQuestionVo kbqaTagQuestionVo, Principal principal) {
        Optional<UserNameLogin> userNameLogin = userNameLoginRepo.findByUserName(principal.getName());
        if (userNameLogin.isPresent()) {
            List<KbqaSdsChemical> chemicalList = kbqaSdsChemicalRepo.findAll();
            for (KbqaSdsChemical chemical: chemicalList) {
                List<String> chemicalNames = new ArrayList<>();
                chemicalNames.add(chemical.getChineseName());
                if (chemical.getOtherChineseName() != null) {
                    String[] names = chemical.getOtherChineseName().replaceAll("；", ";").split(";");
                    chemicalNames.addAll(Arrays.asList(names));
                }
                for (String chemicalName: chemicalNames) {
                    for (Long intentId : kbqaTagQuestionVo.getQuestionIntents()) {
                        Optional<KbqaQuestionIntent> kbqaQuestionIntent = kbqaQuestionIntentRepo.findById(intentId);
                        if (kbqaQuestionIntent.isPresent()) {

                            KbqaQuestionText kbqaQuestionText = new KbqaQuestionText();
                            kbqaQuestionText.setText(kbqaTagQuestionVo.getText().replaceAll("#CHEMICAL", chemicalName).replaceAll("#INTENT", kbqaQuestionIntent.get().getName()));
                            kbqaQuestionText.setCreateTime(new Date());
                            kbqaQuestionText.setCreatedByUserId(userNameLogin.get().getUserId());
                            kbqaQuestionTextRepo.save(kbqaQuestionText);

                            KbqaQuestionIntentTag kbqaQuestionIntentTag = new KbqaQuestionIntentTag();
                            kbqaQuestionIntentTag.setKbqaQuestionTextId(kbqaQuestionText.getId());
                            kbqaQuestionIntentTag.setKbqaQuestionIntentId(intentId);
                            kbqaQuestionIntentTag.setCreateTime(kbqaQuestionText.getCreateTime());
                            kbqaQuestionIntentTag.setCreatedByUserId(kbqaQuestionText.getCreatedByUserId());
                            kbqaQuestionIntentTagRepo.save(kbqaQuestionIntentTag);

                            for (Long typeId : kbqaTagQuestionVo.getQuestionTypes()) {
                                KbqaQuestionTypeTag kbqaQuestionTypeTag = new KbqaQuestionTypeTag();
                                kbqaQuestionTypeTag.setKbqaQuestionTextId(kbqaQuestionText.getId());
                                kbqaQuestionTypeTag.setKbqaQuestionTypeId(typeId);
                                kbqaQuestionTypeTag.setCreateTime(kbqaQuestionText.getCreateTime());
                                kbqaQuestionTypeTag.setCreatedByUserId(kbqaQuestionText.getCreatedByUserId());
                                kbqaQuestionTypeTagRepo.save(kbqaQuestionTypeTag);
                            }
                        }
                    }
                }
            }
        }

        return Message.createSuccessMessage();
    }

    @RequestMapping("findQuestionTextByPage")
    public Message generateQuestion(@RequestBody PageVo pageVo) {
        return Message.createSuccessMessage(kbqaQuestionTextRepo.findAll(pageVo));
    }
}
