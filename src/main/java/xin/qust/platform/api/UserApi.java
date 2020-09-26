package xin.qust.platform.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xin.qust.platform.repository.UserBasicInfoRepo;
import xin.qust.platform.service.common.UserRegisterService;

import java.lang.reflect.Method;

@RequestMapping("user")
@RestController
public class UserApi {

    @Autowired
    private UserRegisterService userRegisterService;
    @Autowired
    private UserBasicInfoRepo userBasicInfoRepo;

    @RequestMapping("register")
    public void register () {

        System.out.println(userBasicInfoRepo);
        Class c = userBasicInfoRepo.getClass();
        Method[] ms = c.getDeclaredMethods();
        for(Method m : ms){
            System.out.println(m.getName());
        }

        userBasicInfoRepo.findAllByNickNameAndCity("","", PageRequest.of(1,1));
//        userRegisterService.addNewUser();
    }
}
