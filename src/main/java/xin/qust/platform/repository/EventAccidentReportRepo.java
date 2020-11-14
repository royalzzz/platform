package xin.qust.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.EventAccidentReport;

public interface EventAccidentReportRepo extends JpaRepository<EventAccidentReport, Long> {
}
