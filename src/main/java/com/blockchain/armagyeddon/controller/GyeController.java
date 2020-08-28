package com.blockchain.armagyeddon.controller;

import com.blockchain.armagyeddon.domain.dto.GyeDto;
import com.blockchain.armagyeddon.domain.entity.Gye;
import com.blockchain.armagyeddon.service.GyeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class GyeController {


    private final GyeService gyeService;

    // 계 생성
    @PostMapping("/gye")
    public Long saveGye(@RequestBody GyeDto gyeDto) {
        System.out.println("Controller response : " + gyeDto.getTitle());

        return gyeService.save(gyeDto);
    }

    // 계 정보 전체 조회
    @GetMapping("/gye")
    public ResponseEntity<List> findGye() {

        return ResponseEntity.ok(gyeService.findAll());
    }

    // 계 id로 조회
    @GetMapping("/gye/{id}")
    public ResponseEntity<Gye> findGye(@PathVariable Long id) {
        return ResponseEntity.ok(gyeService.findById(id));
    }


}
