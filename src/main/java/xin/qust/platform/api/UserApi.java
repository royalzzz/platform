package xin.qust.platform.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.config.login.plugins.jwt.JwtTokenManager;
import xin.qust.platform.domain.UserBasicInfo;
import xin.qust.platform.domain.UserNameLogin;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.constant.ResponseCode;
import xin.qust.platform.repository.user.UserBasicInfoRepo;
import xin.qust.platform.repository.user.UserNameLoginRepo;
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

    @Autowired
    private JwtTokenManager jwtTokenManager;

    @RequestMapping("test")
    public void register () {
        System.out.println("success hello test");
    }

    @RequestMapping("info")
    public Message info () {
        Object object =  SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Optional<UserNameLogin> userNameLogin = userNameLoginRepo.findByUserName(object.toString());
        if (userNameLogin.isPresent()) {
            Optional<UserBasicInfo> userBasicInfo = userBasicInfoRepo.findById(userNameLogin.get().getUserId());
            if (userBasicInfo.isPresent()) {
                Message message = new Message(ResponseCode.SUCCESS);
                message.setData(userBasicInfo.get());
                String new_token = jwtTokenManager.createToken(object.toString());
//                System.out.println(new_token);
                message.setToken(new_token);
//                Message message = new Message();
//                message.setCode(1);
//                message.setData(new UserInfoVo(userBasicInfo.get()));
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
