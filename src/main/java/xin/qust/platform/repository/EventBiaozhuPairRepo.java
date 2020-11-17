package xin.qust.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.EventBiaozhuPair;

import java.util.List;

public interface EventBiaozhuPairRepo extends JpaRepository<EventBiaozhuPair, Long> {
//    1. 通过 来源和来源id查询到案例树或者事故报告的 所有标注
    List<EventBiaozhuPair> findBySourceAndSourceid(Long source, Long sourceid);

}
