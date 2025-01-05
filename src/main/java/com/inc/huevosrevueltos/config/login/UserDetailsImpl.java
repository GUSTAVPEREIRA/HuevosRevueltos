package com.inc.huevosrevueltos.config.login;


import com.inc.huevosrevueltos.model.login.FarmUser;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserDetailsImpl implements UserDetails {

    private FarmUser farmUser;

    public UserDetailsImpl(FarmUser farmUser) {
        this.farmUser = farmUser;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return farmUser.getRoles()
                .stream()
                .map(role -> new SimpleGrantedAuthority(role.getName().name()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return farmUser.getPassword();
    }

    @Override
    public String getUsername() {
        return farmUser.getEmail();
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