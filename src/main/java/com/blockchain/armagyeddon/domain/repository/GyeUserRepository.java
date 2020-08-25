package com.blockchain.armagyeddon.domain.repository;

import com.blockchain.armagyeddon.domain.entity.GyeUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GyeUserRepository extends JpaRepository<GyeUser, Long> {
    Optional<GyeUser> findByUserIdAndGyeId(Long UserId, Long GyeId);

    void delete(Optional<GyeUser> findGyeUser);
}