package com.example.corebase.infrastructure.security;

import com.example.corebase.infrastructure.constant.KeyModule;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

@Component
public class UserInfoUserDetailsService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String fixedUsername = "admin";
        String fixedPassword = "1234";
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(KeyModule.MODULE_ADMIN));

        if (username.equals(fixedUsername)) {
            return new org.springframework.security.core.userdetails.User(fixedUsername, fixedPassword, authorities);
        } else {
            throw new UsernameNotFoundException("User not found");
        }
    }
//
//    @Autowired
//    private UsersRepository usersRepository;
//
//    @Autowired
//    private StaffEntityRepository staffEntityRepository;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        if (username.endsWith(KeyModule.MODULE_CLIENT)) {
//            String trimmedUsername = username.substring(0, username.length() - KeyModule.MODULE_CLIENT.length());
//            Optional<UsersEntity> userInfo = usersRepository.getClientByUserName(trimmedUsername.trim());
//            return userInfo.map(CustomUserDetails::new)
//                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + trimmedUsername));
//        }
//
//        if (username.endsWith(KeyModule.MODULE_ADMIN)) {
//            String trimmedUsername = username.substring(0, username.length() - KeyModule.MODULE_ADMIN.length());
//            Optional<StaffEntity> userInfo = staffEntityRepository.getClientByUserName(trimmedUsername.trim());
//            return userInfo.map(CustomUserDetails::new)
//                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + trimmedUsername));
//        }
//
//        if (username.endsWith(KeyModule.MODULE_STAFF)) {
//            String trimmedUsername = username.substring(0, username.length() - KeyModule.MODULE_STAFF.length());
//            Optional<StaffEntity> userInfo = staffEntityRepository.getClientByUserName(trimmedUsername.trim());
//            return userInfo.map(CustomUserDetails::new)
//                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + trimmedUsername));
//        }
//        return null;
//    }

}