package com.blockchain.armagyeddon.controller;

import com.blockchain.armagyeddon.domain.dto.GyeDto;
import com.blockchain.armagyeddon.domain.entity.Gye;
import com.blockchain.armagyeddon.service.GyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

public class GyeController {

    @Autowired
    GyeService gyeService;

    // 계 정보 입력
    @PostMapping("/gye")
    public String saveGye(@RequestBody GyeDto gyeDto) {
        System.out.println("Controller response : " + gyeDto.getTitle());
        gyeService.save(gyeDto.toEntity());
        return "ok!";
    }

    // 계 정보 전체 조회
    @GetMapping("/gye")
    public String findGyes(Gye gye) {
        gyeService.findAll();
        return "ok!";
    }

    // 계 이름으로 조회
    @GetMapping("/gye/{id}")
    public ResponseEntity<Gye> findGye(@PathVariable Long id) {
        return ResponseEntity.ok(gyeService.findById(id).get());
    }
//    //계 정보 삭제
//    @DeleteMapping("gyeDelete")


}
