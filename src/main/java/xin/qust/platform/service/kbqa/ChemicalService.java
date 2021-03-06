package xin.qust.platform.service.kbqa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.kbqa.KbqaSdsChemical;
import xin.qust.platform.model.vo.KbqaChemicalPageVo;
import xin.qust.platform.repository.kbqa.KbqaSdsChemicalRepo;

@Service
public class ChemicalService {

    @Autowired
    private KbqaSdsChemicalRepo kbqaSdsChemicalRepo;

    public Page<KbqaSdsChemical> findByPage(KbqaChemicalPageVo kbqaChemicalPageVo) {
        return kbqaSdsChemicalRepo.findAll(kbqaChemicalPageVo);
    }
}
