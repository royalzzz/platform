package xin.qust.platform.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.UserNameLogin;

import java.util.Optional;

public interface UserNameLoginRepo extends JpaRepository<UserNameLogin, Long> {

    public Optional<UserNameLogin> findByUserName(String userName);
}
