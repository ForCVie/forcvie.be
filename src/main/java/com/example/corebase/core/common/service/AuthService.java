package com.example.corebase.core.common.service;

import com.example.corebase.core.common.service.dto.LoginRequest;
import com.example.corebase.core.common.service.dto.RegisterRequest;
import com.example.corebase.infrastructure.constant.KeyModule;
import com.example.corebase.infrastructure.exception.BadRequestCustomException;
import com.example.corebase.infrastructure.tokenCustom.ObjectsDto;
import com.example.corebase.infrastructure.tokenCustom.TokenDto;
import com.example.corebase.infrastructure.tokenCustom.TokenUtils;
import com.example.corebase.repository.auth.StaffRepository;
import com.example.corebase.repository.auth.UserRepository;
import com.example.corebase.util.languageCommon.LanguageCommon;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenUtils tokenUtils;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private LanguageCommon languageCommon;

    @Autowired
    @Qualifier(UserRepository.USER_REPOSITORY_NAME)
    private UserRepository usersRepository;

    @Autowired
    @Qualifier(StaffRepository.STAFF_REPOSITORY)
    private StaffRepository staffEntityRepository;

    public String adminLogin(LoginRequest request) {
        request.setUsername(request.getUsername() + KeyModule.MODULE_ADMIN);
        return authLogin(request);
    }

    public String clientLogin(LoginRequest request) {
        request.setUsername(request.getUsername() + KeyModule.MODULE_CLIENT);
        return authLogin(request);
    }

    public String staffLogin(LoginRequest request) {
        request.setUsername(request.getUsername() + KeyModule.MODULE_STAFF);
        return authLogin(request);
    }

    public String authLogin(LoginRequest request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));

            SecurityContextHolder.getContext().setAuthentication(authentication);

            String token = tokenUtils.generateToken(getAuthConvertToken(authentication));

            return token;
        } catch (Exception e) {
            // Xử lý lỗi đăng nhập không thành công
            e.printStackTrace();
            throw new BadRequestCustomException(languageCommon.getMessageProperties("message.login.error"));
        }
    }

    public TokenDto getAuthConvertToken(Authentication authentication) {
        // Trả về token với dữ liệu cứng
        String username = authentication.getName();
        ObjectsDto objectsDto = new ObjectsDto();

        if (username.endsWith(KeyModule.MODULE_ADMIN)) {
            // Giả sử admin có ID là 1
            return new TokenDto();
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
//        TokenDto tokenDto = new TokenDto();
//
//        String username = authentication.getName();
//
//        if (username.endsWith(KeyModule.MODULE_CLIENT)) {
//            String trimmedUsername = username.substring(0, username.length() - KeyModule.MODULE_CLIENT.length());
//            Optional<UsersEntity> userInfo = usersRepository.getClientByUserName(trimmedUsername.trim());
//
//            PremiumDto premium = new PremiumDto();
//
//            return userInfo.map(userEntity -> new TokenDto(userEntity, premium))
//                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
//        }
//
//        if (username.endsWith(KeyModule.MODULE_ADMIN)) {
//            String trimmedUsername = username.substring(0, username.length() - KeyModule.MODULE_ADMIN.length());
//            Optional<StaffEntity> userInfo = staffEntityRepository.getClientByUserName(trimmedUsername.trim());
//
//            ObjectsDto objectsDto = new ObjectsDto();
//
//            return userInfo.map(userEntity -> new TokenDto(userEntity, objectsDto))
//                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
//        }
//
//        if (username.endsWith(KeyModule.MODULE_STAFF)) {
//            String trimmedUsername = username.substring(0, username.length() - KeyModule.MODULE_STAFF.length());
//            Optional<StaffEntity> userInfo = staffEntityRepository.getClientByUserName(trimmedUsername.trim());
//
//            ObjectsDto objectsDto = new ObjectsDto();
//
//            return userInfo.map(userEntity -> new TokenDto(userEntity, objectsDto))
//                    .orElseThrow(() -> new UsernameNotFoundException("user not found " + username));
//        }
//        return tokenDto;
    }

    @Transactional
    public Boolean registerRequest(RegisterRequest request) {
//        UsersEntity entity = new UsersEntity();
//        entity.setFullName(request.getFullName());
//        entity.setEmail(request.getEmail());
//        entity.setPassword(passwordEncoder.encode(request.getPassword()));
//        entity.setPhone(request.getPhone());
//        entity.setUserName(request.getUsername());
//
//        return usersRepository.save(entity);
        return null;
    }
}
