package xin.qust.platform.config.login.provider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import xin.qust.platform.model.Message;
import xin.qust.platform.model.constant.ResponseCode;
import xin.qust.platform.service.login.UserLoginService;

import java.util.ArrayList;

@Component
public class UserNamePasswordLoginProvider implements AuthenticationProvider {

    @Autowired
    private UserLoginService userLoginService;
    @Autowired
    private PasswordEncoder passwordEncoder;
//    @Autowired
//    private ApplicationEventPublisher publisher;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        if(username == null || username.equals("")){
            throw new UsernameNotFoundException(new Message(ResponseCode.USER_NOT_EXIST).toJsonString());
        }
        if(password == null || password.equals("")){
            throw new UsernameNotFoundException(new Message(ResponseCode.USER_LOGIN_ERROR).toJsonString());
        }
        //获取用户信息
        UserDetails user = userLoginService.loadUserByUsername(username);
        //比较前端传入的密码明文和数据库中加密的密码是否匹配
        if (!passwordEncoder.matches(password, user.getPassword())) {
            //发布密码不正确事件
            // publisher.publishEvent(new UserLoginFailedEvent(authentication));
            throw new BadCredentialsException(new Message(ResponseCode.USER_LOGIN_ERROR).toJsonString());
        }
        //获取用户权限信息
        // Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        // return new UsernamePasswordAuthenticationToken(user, password, authorities);
        return new UsernamePasswordAuthenticationToken(user, password, new ArrayList<>());
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
