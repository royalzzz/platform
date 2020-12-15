package xin.qust.platform.service.yuqing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.yuqing.YuqingOriginnews;
import xin.qust.platform.repository.yuqing.NewsClaRepo;
import xin.qust.platform.repository.yuqing.YuqingOriginnewsRepo;

@Service
public class YuqingOriginnewsService {
    @Autowired
    private YuqingOriginnewsRepo yuqingOriginnewsRepo;
    @Autowired
    private NewsClaRepo newsClaRepo;

    public Object getAllYuqingOriginnewsPageable(Pageable pageable) {
        return yuqingOriginnewsRepo.findAll(pageable);
    }

    public Page<YuqingOriginnews> getYuqingOriginnewsWithoutClaPageable(Pageable pageable) {
        return yuqingOriginnewsRepo.findByClasetIsNull(pageable);
    }

    public Page<YuqingOriginnews> getYuqingOriginnewsWithClaPageable(Pageable pageable) {
        return yuqingOriginnewsRepo.findByClasetIsNotNull(pageable);
    }

    public YuqingOriginnews updateOriginNews(YuqingOriginnews news) {
        return yuqingOriginnewsRepo.save(news);
    }

    public int chargeClass() {

        return 2;
    }
}
