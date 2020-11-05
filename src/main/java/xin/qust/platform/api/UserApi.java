package xin.qust.platform.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.model.UserInfoVo;
import xin.qust.platform.domain.UserBasicInfo;
import xin.qust.platform.domain.UserNameLogin;
import xin.qust.platform.model.Message;
import xin.qust.platform.repository.UserBasicInfoRepo;
import xin.qust.platform.repository.UserNameLoginRepo;
import xin.qust.platform.service.common.UserRegisterService;

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

    @RequestMapping("logout")
    public void logout () {
        userRegisterService.addNewUser();
    }

    @RequestMapping("register")
    public void register () {
        userRegisterService.addNewUser();
    }

    @RequestMapping("info")
    public Message info () {
        Object object =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<UserNameLogin> userNameLogin = userNameLoginRepo.findByUserName(object.toString());
        if (userNameLogin.isPresent()) {
            Optional<UserBasicInfo> userBasicInfo = userBasicInfoRepo.findById(userNameLogin.get().getUserId());
            if (userBasicInfo.isPresent()) {
                Message message = new Message();
                message.setCode(1);
                message.setData(new UserInfoVo(userBasicInfo.get()));
                return message;
            } else {
                return null;
            }
        }
        else {
            return null;
        }
    }
}
