package xin.qust.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.UserEmailLogin;

public interface UserEmailLoginRepo extends JpaRepository<UserEmailLogin, Long> {
}
