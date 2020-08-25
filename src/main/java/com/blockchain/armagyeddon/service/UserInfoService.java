package com.blockchain.armagyeddon.service;

import com.blockchain.armagyeddon.controller.UserInfoController;
import com.blockchain.armagyeddon.domain.dto.UserInfoDto;
import com.blockchain.armagyeddon.domain.entity.UserInfo;
import com.blockchain.armagyeddon.domain.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final PasswordEncoder passwordEncoder;

    public Long saveUserInfo(UserInfoDto userInfoDto) {

        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        boolean isExist = userInfoRepository.existsByEmail(userInfoDto.getEmail());
        if (isExist) {
            throw new UserInfoController.AlreadyExistsException("change_email");
        }
        return userInfoRepository.save(userInfoDto.toEntity()).getId();
    }

    public UserInfo getUserInfo(String email) {

        return userInfoRepository.findByEmail(email);

    }
}