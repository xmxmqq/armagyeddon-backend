package com.blockchain.armagyeddon.domain.model;

import java.util.List;

import com.blockchain.armagyeddon.domain.entity.UserInfo;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import lombok.Getter;

@Getter
public class UserInfoDetails extends User{
    private final UserInfo userInfo;
    // 스프링 시큐리티가 다루는 유저 정보를 우리가 가지고 있는 도메인의 유저 정보와 연동
    public UserInfoDetails(UserInfo userInfo) {
        super(userInfo.getEmail(), userInfo.getPassword(), List.of(new SimpleGrantedAuthority("USER")));
        this.userInfo = userInfo;
    }
}