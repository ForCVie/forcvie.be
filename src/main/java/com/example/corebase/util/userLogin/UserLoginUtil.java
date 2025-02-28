package com.example.corebase.util.userLogin;

import org.springframework.stereotype.Service;

@Service
public class UserLoginUtil {

    public UserLoginDto getUserLogin() {
        return new UserLoginDto("admin", "admin", "admin");
    }
}
