package com.blockchain.armagyeddon.domain.repository;

import com.blockchain.armagyeddon.domain.dto.GyeDto;
import com.blockchain.armagyeddon.domain.entity.Gye;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GyeRepository extends JpaRepository<Gye, Long>{

}