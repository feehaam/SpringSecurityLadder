package com.feeham.security2.config;

import com.feeham.security2.entity.User;
import com.feeham.security2.service.UserService;
import com.feeham.security2.utility.CustomUserDetails;
import com.feeham.security2.utility.CustomUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfig {

    @Bean
    UserDetails userDetails(User user) {
        System.out.println("[-] Providing custom UserDetails. [UserConfig-userDetails]");
        return new CustomUserDetails(user);
    }

    @Bean
    UserDetailsService userDetailsService() {
        System.out.println("[-] Providing custom UserDetailsService. [UserConfig-userDetailsService]");
        return new CustomUserDetailsService();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        System.out.println("[-] Providing custom PasswordEncoder. [UserConfig-passwordEncoder]");
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }
}
