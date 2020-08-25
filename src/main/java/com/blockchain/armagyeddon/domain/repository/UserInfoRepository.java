package com.blockchain.armagyeddon.domain.repository;

import com.blockchain.armagyeddon.domain.entity.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByName(String name);

    UserInfo findByEmail(String email);

    boolean existsByEmail(String email);

//    Optional<UserInfo> findById(Long id);
//
//    List<UserInfo> findAll();
//
//    User deleteByNumberContaining(Long number);
//
//    User updateById(Long number, User user);
}