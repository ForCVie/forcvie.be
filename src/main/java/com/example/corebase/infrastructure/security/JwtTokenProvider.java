package com.example.corebase.infrastructure.security;

import com.example.corebase.infrastructure.tokenCustom.TokenDto;
import com.example.corebase.infrastructure.tokenCustom.TokenUtils;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class JwtTokenProvider {

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private HttpSession httpSession;

    public String generateToken(TokenDto tokenDto) {
        return tokenUtils.generateToken(tokenDto);
    }

    public Authentication getAuthentication(String token) {
        Map<String, Object> claims = tokenUtils.decodeToken(token);

        String username = (String) claims.get("userName");
        // Trích xuất các thông tin khác từ claims (ví dụ: roles, permissions, ...)

        List<GrantedAuthority> authorities = new ArrayList<>();
        // Tạo đối tượng GrantedAuthority dựa trên vai trò và quyền hạn

        return new UsernamePasswordAuthenticationToken(username, null, authorities);
    }

    public boolean isTokenValid(String token) {
        return tokenUtils.validateToken(token);
    }

    public boolean isTokenExpired(String token) {
        return tokenUtils.checkExpirationToken(token);
    }
}
