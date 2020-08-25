package com.blockchain.armagyeddon.service;

import com.blockchain.armagyeddon.controller.UserInfoController;
import com.blockchain.armagyeddon.domain.dto.UserInfoDto;
import com.blockchain.armagyeddon.domain.entity.UserInfo;
import com.blockchain.armagyeddon.domain.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;

import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

@Service
@RequiredArgsConstructor
public class UserInfoService {
    private final UserInfoRepository userInfoRepository;
    private final PasswordEncoder passwordEncoder;
    private final TokenService tokenService;
    public Long saveUserInfo(UserInfoDto userInfoDto) {


        if ( userInfoRepository.existsByEmail(userInfoDto.getEmail())) {
            throw new UserInfoController.AlreadyExistsException("change_email");
        }
        userInfoDto.setPassword(passwordEncoder.encode(userInfoDto.getPassword()));
        try {
            userInfoDto.setPublic_key(tokenService.createAccount(userInfoDto.getPassword()));
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }
        return userInfoRepository.save(userInfoDto.toEntity()).getId();
    }

    public UserInfo getUserInfo(String email) {

        return userInfoRepository.findByEmail(email);
    }
}