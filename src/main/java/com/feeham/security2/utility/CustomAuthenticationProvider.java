package com.feeham.security2.utility;

import com.feeham.security2.entity.Role;
import com.feeham.security2.entity.User;
import com.feeham.security2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private IUserService userService;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userService.readByEmail(userName);
        if(user == null){
            throw new UsernameNotFoundException("User " + userName + " not found");
        }
        if(!passwordEncoder.matches(password, user.getPassword())){
            throw new RuntimeException("Password " + password + " is wrong");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        if(user.getRoles() != null)
            for(Role role : user.getRoles())
                authorities.add(new SimpleGrantedAuthority(role.toString()));
        return new UsernamePasswordAuthenticationToken(user, password, authorities);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
