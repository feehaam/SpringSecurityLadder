package com.feeham.security2.utility;

import com.feeham.security2.entity.User;
import com.feeham.security2.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("[-] Loading user " + username);
        User user = userService.readByEmail(username);
        UserDetails userDetails = new CustomUserDetails(user);
        System.out.println("[-] Result: " + userDetails);
        return userDetails;
    }
}
