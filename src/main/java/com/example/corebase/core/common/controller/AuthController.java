package com.example.corebase.core.common.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.core.common.service.AuthService;
import com.example.corebase.core.common.service.dto.LoginRequest;
import com.example.corebase.core.common.service.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login/admin")
    public ResponseObject adminLogin(@RequestBody LoginRequest request) {
        return new ResponseObject(authService.adminLogin(request));
    }

    @PostMapping("/login/client")
    public ResponseObject clientLogin(@RequestBody LoginRequest request) {
        return new ResponseObject(authService.clientLogin(request));
    }

    @PostMapping("/login/staff")
    public ResponseObject staffLogin(@RequestBody LoginRequest request) {
        return new ResponseObject(authService.staffLogin(request));
    }

    @PostMapping("/register/client")
    public ResponseObject registerStaff(@RequestBody RegisterRequest request) {
        return new ResponseObject(authService.registerRequest(request));
    }
}
