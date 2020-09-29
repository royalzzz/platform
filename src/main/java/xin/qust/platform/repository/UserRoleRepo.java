package xin.qust.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.UserRole;

public interface UserRoleRepo extends JpaRepository<UserRole, Long> {
}
