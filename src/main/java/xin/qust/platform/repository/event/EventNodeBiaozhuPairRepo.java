package xin.qust.platform.repository.event;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.event.EventNodeBiaozhuPair;

import java.util.List;

public interface EventNodeBiaozhuPairRepo extends JpaRepository<EventNodeBiaozhuPair, Long> {
    List<EventNodeBiaozhuPair> findByNodeid(Long nodeid);
}
