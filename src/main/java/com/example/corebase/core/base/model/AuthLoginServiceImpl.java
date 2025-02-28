package com.example.corebase.core.base.model;

import com.example.corebase.infrastructure.constant.SessionConstant;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AuthLoginServiceImpl implements AuthLoginService {

    @Autowired
    private HttpSession httpSession;

//    @Autowired
//    private UsersRepository usersRepository;

    @Override
    public Long getIdUser() {
        return (Long) httpSession.getAttribute(SessionConstant.ID_USER);
    }

    @Override
    public String getName() {
        return (String) httpSession.getAttribute(SessionConstant.NAME);
    }

    @Override
    public String getEmail() {
        return (String) httpSession.getAttribute(SessionConstant.EMAIL);
    }

    @Override
    public String getUserName() {
        return (String) httpSession.getAttribute(SessionConstant.USER_NAME);
    }

    @Override
    public String getPicture() {
        return (String) httpSession.getAttribute(SessionConstant.PICTURE);
    }

//    @Override
//    public UsersEntity getAuth() {
//        return usersRepository.findAll().get(0);
//    }
}
