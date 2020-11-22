package xin.qust.platform.repository.event;
import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.EventEdge;
public interface EventEdgeRepo extends JpaRepository<EventEdge, Long> {
}
