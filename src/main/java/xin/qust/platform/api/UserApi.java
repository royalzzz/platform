package xin.qust.platform.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.service.common.UserRegisterService;

@RequestMapping("user")
@RestController
public class UserApi {

    @Autowired
    private UserRegisterService userRegisterService;

    @RequestMapping("register")
    public void register () {
        userRegisterService.addNewUser();
    }
}
