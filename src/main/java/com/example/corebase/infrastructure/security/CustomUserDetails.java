package com.example.corebase.infrastructure.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomUserDetails implements UserDetails {

    private String username;
    private String password; // Mật khẩu, có thể được sử dụng hoặc không tùy thuộc vào việc sử dụng mật khẩu ở phía frontend
    private Collection<? extends GrantedAuthority> authorities;

    public CustomUserDetails(String username, String password, Collection<GrantedAuthority> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

//    public CustomUserDetails(UsersEntity usersEntity) {
//        this.username = usersEntity.getUserName() + KeyModule.MODULE_CLIENT;
//        this.password = usersEntity.getPassword();
//        this.authorities = Arrays.stream((usersEntity.getRoleId() !=null ? usersEntity.getRoleId().getRoleCode() : "USER").split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }
//
//    public CustomUserDetails(StaffEntity staffEntity) {
//        this.username = staffEntity.getUsername() + KeyModule.MODULE_STAFF;
//        this.password = staffEntity.getPassword();
//        this.authorities = Arrays.stream((staffEntity.getRoleId() !=null ? staffEntity.getRoleId().getRoleCode() : "USER").split(","))
//                .map(SimpleGrantedAuthority::new)
//                .collect(Collectors.toList());
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
