package xin.qust.platform.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.model.ResponseCode;
import xin.qust.platform.domain.User;
import xin.qust.platform.model.Message;
import xin.qust.platform.repository.UserRepo;

import java.util.Optional;

@RequestMapping("user")
@RestController
public class UserApi {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private UserRepo userRepo;
    @RequestMapping("login")
    public Message login (String username, String password) {
        logger.info("通过用户名登录:" + username + "|" + password);
        Optional<User> user = userRepo.findByNickName(username);

        if (user.isPresent()){
            Message message = new Message();
//            user.get().setPassword(DigestUtils.md5DigestAsHex("123456".toString().getBytes()));
//            userRepo.save(user.get());
            String md5password = user.get().getPassword();
            if (md5password.equals(DigestUtils.md5DigestAsHex(password.getBytes()))){
                message.setData(user.get());
            }else {
                message.setData(ResponseCode.USER_LOGIN_ERROR);
            }
            return message;
        }else {
            return new Message(ResponseCode.USER_NOT_EXIST);
        }
    }
}
