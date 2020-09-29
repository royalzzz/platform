package xin.qust.platform.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "user_role")
public class UserRole implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roleId;

    private String role;

    private String roleName;

    @ManyToMany(targetEntity = UserAuthority.class, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_has_authority", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "authority_id")})
    private Set<UserAuthority> userAuthoritySet;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<UserAuthority> getUserAuthoritySet() {
        return userAuthoritySet;
    }

    public void setUserAuthoritySet(Set<UserAuthority> userAuthoritySet) {
        this.userAuthoritySet = userAuthoritySet;
    }
}
