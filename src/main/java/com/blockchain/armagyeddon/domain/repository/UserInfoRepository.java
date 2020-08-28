package com.blockchain.armagyeddon.domain.repository;

import com.blockchain.armagyeddon.domain.entity.UserInfo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    UserInfo findByName(String name);

    UserInfo findByEmail(String email);

    boolean existsByEmail(String email);

//    List<UserInfo> findAll();
//
//    UserInfo findById(Long id);
//
//    Optional<User> findByNumber(Long number);
//
//    User deleteByNumberContaining(Long number);
//
//    User updateById(Long number, User user);
}