package xin.qust.platform.api;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.domain.UserBasicInfo;
import xin.qust.platform.domain.UserNameLogin;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.ResponseCode;
import xin.qust.platform.repository.UserBasicInfoRepo;
import xin.qust.platform.repository.UserNameLoginRepo;
import xin.qust.platform.service.common.UserRegisterService;

import javax.management.ObjectName;
import java.util.Optional;

@RequestMapping("user")
@RestController
public class UserApi {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private UserBasicInfoRepo userBasicInfoRepo;
    @Autowired
    private UserNameLoginRepo userNameLoginRepo;

    @RequestMapping("register")
    public void register () {
        logger.info("新建用户");
        userRegisterService.addNewUser();
    }

    @RequestMapping("info")
    public UserBasicInfo info () {
        Object object =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<UserNameLogin> userNameLogin = userNameLoginRepo.findByUserName(object.toString());
        if (userNameLogin.isPresent()) {
            Optional<UserBasicInfo> userBasicInfo = userBasicInfoRepo.findById(userNameLogin.get().getUserId());
            if (userBasicInfo.isPresent()) {
//                Message message = new Message(ResponseCode.SUCCESS);
//                message.setData(userBasicInfo.get());
                return userBasicInfo.get();
            } else {
                return null;
            }
        }
        else {
            return null;
        }
    }
}
