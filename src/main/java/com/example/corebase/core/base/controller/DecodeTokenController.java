package com.example.corebase.core.base.controller;

import com.example.corebase.core.base.model.ResponseObject;
import com.example.corebase.infrastructure.tokenCustom.TokenDto;
import com.example.corebase.infrastructure.tokenCustom.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/developer/json-token")
public class DecodeTokenController {

    @Autowired
    private TokenUtils tokenUtils;

    @PostMapping("/decode-token")
    public ResponseObject decodeToken(@RequestBody Map<String, String> token) {
        return new ResponseObject(tokenUtils.decodeToken(token.get("token")));
    }

    @PostMapping("/gen-token")
    public ResponseObject genToken(@RequestBody TokenDto payload) {
        return new ResponseObject(tokenUtils.generateToken(payload));
    }
}
