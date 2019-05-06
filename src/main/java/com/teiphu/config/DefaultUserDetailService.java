package com.teiphu.config;

import com.teiphu.pojo.UserDo;
import com.teiphu.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DefaultUserDetailService implements UserDetailsService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultUserDetailService.class);

    @Autowired
    private UserService userService;

//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LOG.info("invoke DefaultUserDetailService loadUserByUsername()");
        UserDo user = userService.getUserByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not found.");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));
        User userDetails = new User(user.getUsername(), user.getPassword(), authorities);
        return userDetails;
    }
}
