package be.ss13security.entity;

import javax.persistence.*;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Long RoleId;
    @Column(name = "role_name", nullable = false)
    private String roleName;

    public Role() {
    }

    public Role(long roleId, String roleName) {
        RoleId = roleId;
        this.roleName = roleName;
    }

    public long getRoleId() {
        return RoleId;
    }

    public void setRoleId(long roleId) {
        RoleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
