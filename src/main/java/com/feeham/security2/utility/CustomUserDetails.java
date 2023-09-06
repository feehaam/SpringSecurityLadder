package com.feeham.security2.utility;

import com.feeham.security2.entity.Role;
import com.feeham.security2.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(user.getRoles() == null) return authorities;
        for(Role role: user.getRoles()){
            authorities.add(new SimpleGrantedAuthority(role.toString()));
        }
        return authorities;
    }

    @Override
    public String getPassword() {
        System.out.println("[-] Returning user password: " + user.getPassword());
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        System.out.println("[-] Returning username: " + user.getEmail());
        return user.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }
}
