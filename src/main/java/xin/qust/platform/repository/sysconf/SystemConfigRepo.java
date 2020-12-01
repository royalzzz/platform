package xin.qust.platform.repository.sysconf;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.SystemConfig;

import java.util.Optional;

public interface SystemConfigRepo extends JpaRepository<SystemConfig, Long> {
    Optional<SystemConfig> findTopByOrderByIdDesc();        //查找现在的系统参数
}
