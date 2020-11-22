package xin.qust.platform.repository.kbqa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.KbqaSdsChemical;
import xin.qust.platform.model.vo.ChemicalPageVo;

public interface KbqaSdsChemicalRepo extends JpaRepository<KbqaSdsChemical, Long> {

    Page<KbqaSdsChemical> findByCas(String cas, Pageable chemicalPageVo);

}
