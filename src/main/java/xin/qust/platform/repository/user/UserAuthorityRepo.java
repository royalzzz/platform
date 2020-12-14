package xin.qust.platform.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.user.UserAuthority;

public interface UserAuthorityRepo extends JpaRepository<UserAuthority, Long> {
}
