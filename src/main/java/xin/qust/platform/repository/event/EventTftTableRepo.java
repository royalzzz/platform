package xin.qust.platform.repository.event;
import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.event.EventTftTable;

public interface EventTftTableRepo extends JpaRepository<EventTftTable, Long> {
}
