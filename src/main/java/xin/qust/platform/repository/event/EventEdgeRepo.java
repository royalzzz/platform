package xin.qust.platform.repository.event;
import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.event.EventEdge;
public interface EventEdgeRepo extends JpaRepository<EventEdge, Long> {
}
