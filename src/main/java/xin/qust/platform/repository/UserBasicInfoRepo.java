package xin.qust.platform.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import xin.qust.platform.domain.UserBasicInfo;
import xin.qust.platform.framework.WMRepository;

import java.util.List;

public interface UserBasicInfoRepo extends WMRepository<UserBasicInfo, Long> {

    List<UserBasicInfo> findAllByNickNameAndCity(String nickName, String city, Pageable pageable);
}
