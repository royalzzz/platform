package xin.qust.platform.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.user.UserNameLogin;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.constant.ResponseCode;
import xin.qust.platform.repository.user.UserBasicInfoRepo;
import xin.qust.platform.repository.user.UserEmailLoginRepo;
import xin.qust.platform.repository.user.UserNameLoginRepo;

import java.util.Optional;

@Service
public class UserLoginService implements UserDetailsService {

    @Autowired
    private UserEmailLoginRepo userEmailLoginRepo;

    @Autowired
    private UserBasicInfoRepo userBasicInfoRepo;

    @Autowired
    private UserNameLoginRepo userNameLoginRepo;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserNameLogin> userNameLogin = userNameLoginRepo.findByUserName(s);
        if (userNameLogin.isPresent()) {
            return userNameLogin.get();
        }
        else {
            throw new BadCredentialsException(new Message(ResponseCode.USER_NOT_EXIST).toJsonString());
        }
    }

}
