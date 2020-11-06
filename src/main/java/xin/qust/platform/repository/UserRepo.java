package xin.qust.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.User;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<User> findByNickName(String nickName);

}
