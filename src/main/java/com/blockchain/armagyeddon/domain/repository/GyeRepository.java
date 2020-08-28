package com.blockchain.armagyeddon.domain.repository;

import com.blockchain.armagyeddon.domain.dto.GyeDto;
import com.blockchain.armagyeddon.domain.entity.Gye;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GyeRepository extends JpaRepository<Gye, Long>{

    //계 검색

    Optional<Gye> findById(Long id);
    Gye findByName(String name);
    Gye findByNameLike(String keyword);
    Gye findByType(String type);
    Gye findByPeriod(String period);
    Gye findByTargetMoney(int targetmoney);
    boolean existsByName(String name);

}