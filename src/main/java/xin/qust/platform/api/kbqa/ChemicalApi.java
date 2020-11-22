package xin.qust.platform.api.kbqa;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.vo.ChemicalPageVo;
import xin.qust.platform.service.kbqa.ChemicalService;

@RequestMapping("kbqa/chemical")
@RestController
public class ChemicalApi {
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ChemicalService chemicalService;

    @RequestMapping("findByPage")
    public Message findByPage(@RequestBody ChemicalPageVo chemicalPageVo) {
        return Message.createSuccessMessage(chemicalService.findByPage(chemicalPageVo));
    }
}
