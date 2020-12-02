package xin.qust.platform.service.yuqing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xin.qust.platform.repository.yuqing.YuqingOriginnewsRepo;


import java.util.List;

@Service
public class YuqingOriginnewsService {
    @Autowired
    private YuqingOriginnewsRepo yuqingOriginnewsRepo;

    public Object getAllYuqingOriginnewsPageable(Pageable pageable) {
        return yuqingOriginnewsRepo.findAll(pageable);
    }
}
