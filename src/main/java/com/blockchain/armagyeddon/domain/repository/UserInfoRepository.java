package com.blockchain.armagyeddon.domain.repository;

import com.blockchain.armagyeddon.domain.entity.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long>{
    UserInfo findByEmail(String email);
}