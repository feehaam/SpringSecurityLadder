package com.feeham.security2.entity;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    private String password;
    private String fullName;
    @Enumerated(EnumType.STRING)
    private List<Role> roles;
    @Column(name = "account_active")
    private boolean isAccountNonExpired;
    @Column(name = "account_unlocked")
    private boolean isAccountNonLocked;
    @Column(name = "account_credentials_active")
    private boolean isCredentialsNonExpired;
    @Column(name = "account_enabled")
    private boolean isEnabled;

    public User() {

    }
    public User(String email, String password, String fullName, List<Role> roles) {
        this(email, password, fullName, roles, true, true, true, true);
    }
    public User(String email, String password, String fullName, List<Role> roles, boolean isAccountNonExpired, boolean isAccountNonLocked, boolean isCredentialsNonExpired, boolean isEnabled) {
        this.email = email;
        this.password = password;
        this.fullName = fullName;
        this.roles = roles;
        this.isAccountNonExpired = isAccountNonExpired;
        this.isAccountNonLocked = isAccountNonLocked;
        this.isCredentialsNonExpired = isCredentialsNonExpired;
        this.isEnabled = isEnabled;
    }
    public User(User user) {
        this.roles = user.roles;
        this.id = user.id;
        this.email = user.email;
        this.fullName = user.fullName;
        this.password = user.password;
        this.isAccountNonExpired = user.isAccountNonExpired;
        this.isAccountNonLocked = user.isAccountNonLocked;
        this.isCredentialsNonExpired = user.isCredentialsNonExpired;
        this.isEnabled = user.isEnabled;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        isAccountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        isAccountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        isCredentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return isEnabled;
    }

    public void setEnabled(boolean enabled) {
        isEnabled = enabled;
    }
}
