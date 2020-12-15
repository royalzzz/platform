package xin.qust.platform.repository.yuqing;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.yuqing.YuqingOriginnews;

import java.util.List;


public interface YuqingOriginnewsRepo extends JpaRepository<YuqingOriginnews, Long> {
    Page<YuqingOriginnews> findByClasetIsNull(Pageable pageable);

    Page<YuqingOriginnews> findByClasetIsNotNull(Pageable pageable);

    List<YuqingOriginnews> findByClasetIsNotNull();

    List<YuqingOriginnews> findByClasetIsNull();
}
