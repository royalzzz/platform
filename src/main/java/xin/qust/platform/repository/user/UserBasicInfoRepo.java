package xin.qust.platform.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.user.UserBasicInfo;

import java.util.Optional;

public interface UserBasicInfoRepo extends JpaRepository<UserBasicInfo, Long> {


}
