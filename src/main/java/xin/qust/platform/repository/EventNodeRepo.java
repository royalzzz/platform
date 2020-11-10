package xin.qust.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.EventNode;

public interface EventNodeRepo extends JpaRepository<EventNode, Long> {
}
