package by.powerline.repzone.security.model;

import by.powerline.repzone.model.db.ServiceModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * @author v.tarasevich
 * @version 1.0
 * @since 20.02.2018 21:00
 */
@NoArgsConstructor
public class JwtUserDetails implements UserDetails {

    @Getter
    private Long id;
    private String username;
    private String password;
    private Set<GrantedAuthority> grantedAuthorities;

    public JwtUserDetails(ServiceModel serviceModel) {
        this.id = serviceModel.getId();
        this.username = serviceModel.getServiceName();
        this.password = serviceModel.getPassword();
        this.grantedAuthorities = new HashSet<>();
        this.grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_SERVICE"));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
