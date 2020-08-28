package xin.qust.platform.service.common;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.UserBasicInfo;
import xin.qust.platform.domain.UserEmailLogin;
import xin.qust.platform.domain.UserNameLogin;
import xin.qust.platform.repository.UserBasicInfoRepo;
import xin.qust.platform.repository.UserEmailLoginRepo;
import xin.qust.platform.repository.UserNameLoginRepo;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class UserRegisterService {

    @Autowired
    private UserBasicInfoRepo userBasicInfoRepo;

    @Autowired
    private UserEmailLoginRepo userEmailLoginRepo;

    @Autowired
    private UserNameLoginRepo userNameLoginRepo;

    public void addNewUser() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        try {
            UserBasicInfo userBasicInfo = new UserBasicInfo();
            userBasicInfo.setAvatar("");
            userBasicInfo.setBirthday(simpleDateFormat.parse("1995-11-23"));
            userBasicInfo.setCity("青岛市");
            userBasicInfo.setCountry("中国");
            userBasicInfo.setCreateTime(new Date());
            userBasicInfo.setEmail("824259085@qq.com");
            userBasicInfo.setGender(1);
            userBasicInfo.setIntroduction("该人很懒...");
            userBasicInfo.setModifiedTime(new Date());
            userBasicInfo.setNickName("royal");
            userBasicInfo.setProvince("山东省");
            userBasicInfo.setRealName("朱孟帅");
            userBasicInfoRepo.save(userBasicInfo);

            if (userBasicInfo.getEmail() != null && !userBasicInfo.getEmail().equals("")) {
                UserEmailLogin userEmailLogin = new UserEmailLogin();
                userEmailLogin.setEmail(userBasicInfo.getEmail());
                userEmailLogin.setUserId(userBasicInfo.getId());
                userEmailLogin.setCreateTime(new Date());
                userEmailLogin.setModifiedTime(new Date());
                userEmailLogin.setPassword(encoder.encode("123456"));
                userEmailLoginRepo.save(userEmailLogin);
            }

            if (userBasicInfo.getNickName() != null && !userBasicInfo.getNickName().equals("")) {
                UserNameLogin userNameLogin = new UserNameLogin();
                userNameLogin.setUserId(userBasicInfo.getId());
                userNameLogin.setPassword(encoder.encode("123456"));
                userNameLogin.setAccountNonExpired(true);
                userNameLogin.setAccountNonLocked(true);
                userNameLogin.setCredentialsNonExpired(true);
                userNameLogin.setEnabled(true);
                userNameLogin.setUserName(userBasicInfo.getNickName());
                userNameLoginRepo.save(userNameLogin);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
