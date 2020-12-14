package xin.qust.platform.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.user.UserEmailLogin;

public interface UserEmailLoginRepo extends JpaRepository<UserEmailLogin, Long> {
}
