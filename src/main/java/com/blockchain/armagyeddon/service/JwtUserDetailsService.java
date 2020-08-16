package com.blockchain.armagyeddon.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.blockchain.armagyeddon.domain.entity.UserInfo;
import com.blockchain.armagyeddon.domain.model.UserInfoDetails;
import com.blockchain.armagyeddon.domain.repository.UserInfoRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {


    private final UserInfoRepository userInfoRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        UserInfo userInfo = userInfoRepository.findByEmail(email);

        if(userInfo == null){
            throw new UsernameNotFoundException("User not found with email: " + email);
        } else {
            return new UserInfoDetails(userInfo);
        }
    }
}