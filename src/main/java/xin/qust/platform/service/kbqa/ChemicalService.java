package xin.qust.platform.service.kbqa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.KbqaSdsChemical;
import xin.qust.platform.model.vo.ChemicalPageVo;
import xin.qust.platform.repository.kbqa.KbqaSdsChemicalRepo;

@Service
public class ChemicalService {

    @Autowired
    private KbqaSdsChemicalRepo kbqaSdsChemicalRepo;

    public Page<KbqaSdsChemical> findByPage(ChemicalPageVo chemicalPageVo) {
        return kbqaSdsChemicalRepo.findAll(chemicalPageVo);
//        return kbqaSdsChemicalRepo.findByCas(chemicalPageVo.getcas, chemicalPageVo);
    }
}
