package xin.qust.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.UserAuthority;

public interface UserAuthorityRepo extends JpaRepository<UserAuthority, Long> {
}
