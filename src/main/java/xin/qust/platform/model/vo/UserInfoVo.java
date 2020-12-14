package xin.qust.platform.model.vo;

import xin.qust.platform.domain.user.UserBasicInfo;
import xin.qust.platform.domain.user.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class UserInfoVo {

    private String name;
    private String avatar;
    private String introduction;
    private List<String> roles;
    private int code;

    public UserInfoVo(UserBasicInfo userBasicInfo) {
        this.setCode(1);
        this.setAvatar(userBasicInfo.getAvatar());
        this.setIntroduction(userBasicInfo.getIntroduction());
        this.setName(userBasicInfo.getNickName());
        List<String> roles = new ArrayList<>();
        Set<UserRole> userRoles = userBasicInfo.getUserRoles();
        for (UserRole role: userRoles) {
            roles.add(role.getRole());
        }
        this.setRoles(roles);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
