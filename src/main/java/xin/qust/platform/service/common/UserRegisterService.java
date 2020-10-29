package xin.qust.platform.service.common;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import xin.qust.platform.domain.*;
import xin.qust.platform.repository.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserRegisterService {

    @Autowired
    private UserBasicInfoRepo userBasicInfoRepo;

    @Autowired
    private UserEmailLoginRepo userEmailLoginRepo;

    @Autowired
    private UserNameLoginRepo userNameLoginRepo;

    @Autowired
    private UserRoleRepo userRoleRepo;

    @Autowired
    private UserAuthorityRepo userAuthorityRepo;

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
            userBasicInfo.setNickName("sjf");
            userBasicInfo.setProvince("山东省");
            userBasicInfo.setRealName("隋建飞");

            UserAuthority all = new UserAuthority();
            all.setAuthority("ALL");
            all.setAuthorityName("所有权限");
            userAuthorityRepo.save(all);
            

            UserAuthority reader = new UserAuthority();
            reader.setAuthority("READ_ONLY");
            reader.setAuthorityName("只读权限");
            userAuthorityRepo.save(reader);

            UserAuthority writer = new UserAuthority();
            writer.setAuthority("WRITE");
            writer.setAuthorityName("写入权限");
            userAuthorityRepo.save(writer);

            Set<UserAuthority> adminAuthorities = new HashSet<>();
            adminAuthorities.add(all);
            adminAuthorities.add(reader);
            adminAuthorities.add(writer);

            Set<UserAuthority> userAuthorities = new HashSet<>();
            userAuthorities.add(reader);

            UserRole admin = new UserRole();
            admin.setRole("ADMIN");
            admin.setRoleName("管理员");
            admin.setUserAuthoritySet(adminAuthorities);
            userRoleRepo.save(admin);

            UserRole userRole = new UserRole();
            userRole.setRole("USER");
            userRole.setRoleName("普通用户");
            userRole.setUserAuthoritySet(userAuthorities);
            userRoleRepo.save(userRole);

            Set<UserRole> adminRoles = new HashSet<>();
            adminRoles.add(admin);
            adminRoles.add(userRole);

            userBasicInfo.setUserRoles(adminRoles);
//            System.out.println(userBasicInfo);
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
