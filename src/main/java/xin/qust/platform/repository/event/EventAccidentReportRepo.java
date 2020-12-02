package xin.qust.platform.repository.event;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.event.EventAccidentReport;

public interface EventAccidentReportRepo extends JpaRepository<EventAccidentReport, Long> {
}
