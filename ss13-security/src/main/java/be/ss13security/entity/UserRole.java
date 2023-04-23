package be.ss13security.entity;

import javax.persistence.*;
@Entity
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long no;
    @ManyToOne
    @Column(name = "user_id")
    private UserApp userApp;
    @ManyToOne
    @Column(name = "role_id")
    private Role role;

    public UserRole() {
    }

    public UserRole(long no, UserApp userApp, Role role) {
        this.no = no;
        this.userApp = userApp;
        this.role = role;
    }

    public long getNo() {
        return no;
    }

    public void setNo(long no) {
        this.no = no;
    }

    public UserApp getUserApp() {
        return userApp;
    }

    public void setUserApp(UserApp userApp) {
        this.userApp = userApp;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
