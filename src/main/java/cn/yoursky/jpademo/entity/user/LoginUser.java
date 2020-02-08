package cn.yoursky.jpademo.entity.user;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "login_user")
public class LoginUser implements Serializable/*, UserDetails*/ {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "test_validator")
    private String testValidator;

  /*  @ManyToMany
    @JoinTable(name = "user_roles",
            joinColumns = {
                @JoinColumn(name = "user_id")
            },
            inverseJoinColumns = {
                @JoinColumn(name = "roles_id")
    })
    private List<Roles> list;*/

   /* @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<> ();
        List<Roles> roles = getList();
        for (Roles role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getRName()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }*/
}
