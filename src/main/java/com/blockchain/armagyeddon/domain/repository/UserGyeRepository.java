package com.blockchain.armagyeddon.domain.repository;

import com.blockchain.armagyeddon.domain.entity.UserGye;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserGyeRepository extends JpaRepository<UserGye, Long> {
    Optional<UserGye> findByUserIdAndGyeId(Long UserId, Long GyeId);

}
