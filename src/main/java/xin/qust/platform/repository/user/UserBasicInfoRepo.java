package xin.qust.platform.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.UserBasicInfo;

public interface UserBasicInfoRepo extends JpaRepository<UserBasicInfo, Long> {
}
