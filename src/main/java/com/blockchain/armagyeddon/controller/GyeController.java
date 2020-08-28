package com.blockchain.armagyeddon.controller;

import com.blockchain.armagyeddon.domain.dto.GyeDto;
import com.blockchain.armagyeddon.domain.dto.GyeDtoNoPublicKey;
import com.blockchain.armagyeddon.domain.entity.Gye;
import com.blockchain.armagyeddon.service.GyeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequiredArgsConstructor
@CrossOrigin
public class GyeController {


    private final GyeService gyeService;

    // 계 생성
    @PostMapping("/gye")
    public Long saveGye(@RequestBody GyeDto gyeDto, Principal userInfo) {
        System.out.println("Controller response : " + gyeDto.getTitle());
        gyeDto.setMaster(userInfo.getName());
        return gyeService.save(gyeDto);
    }

    // 계 정보 전체 조회
    @GetMapping("/gye")
    public ResponseEntity<List> findGye() {

        List<GyeDtoNoPublicKey> gyeDtoList = new ArrayList<>();

        for (Gye gye : gyeService.findAll()) {
            gyeDtoList.add(GyeDtoNoPublicKey.builder()
                    .id(gye.getId())
                    .type(gye.getType())
                    .title(gye.getTitle())
                    .targetMoney(gye.getTargetMoney())
                    .period(gye.getPeriod())
                    .totalMember(gye.getTotalMember())
                    .state(gye.getState())
                    .master(gye.getMaster()).build());
        }




        return ResponseEntity.ok(gyeDtoList);
    }

    // 계 id로 조회
    @GetMapping("/gye/{id}")
    public ResponseEntity<GyeDtoNoPublicKey> findGye(@PathVariable Long id) {
        Gye gye = gyeService.findById(id);


        return ResponseEntity.ok(GyeDtoNoPublicKey.builder()
                .id(gye.getId())
                .type(gye.getType())
                .title(gye.getTitle())
                .targetMoney(gye.getTargetMoney())
                .period(gye.getPeriod())
                .totalMember(gye.getTotalMember())
                .state(gye.getState())
                .master(gye.getMaster()).build());
    }


}
