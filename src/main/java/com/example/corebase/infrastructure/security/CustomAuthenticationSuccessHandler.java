package com.example.corebase.infrastructure.security;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;

@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Value("${app.domain.main}")
    private String domainClientMain;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        if (authentication instanceof OAuth2AuthenticationToken) {
            OAuth2AuthenticationToken oauth2Token = (OAuth2AuthenticationToken) authentication;
            OAuth2User oauth2User = oauth2Token.getPrincipal();
            // Thực hiện xử lý tùy thuộc vào người dùng OAuth2
            // Sau đó, redirect đến trang mong muốn
            String providerId = oauth2Token.getAuthorizedClientRegistrationId();
            response.sendRedirect(domainClientMain);
        } else {
            // Xử lý đối với các loại authentication khác (nếu có)
            // Sau đó, redirect đến trang mong muốn
            response.sendRedirect("/error");
        }
    }
}
