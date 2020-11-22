package xin.qust.platform.model.vo;

import org.springframework.data.domain.AbstractPageRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public class ChemicalPageVo extends PageVo{

    ChemicalPageVo(int pageNumber, int pageSize) {
        super(pageNumber, pageSize);
    }
}
