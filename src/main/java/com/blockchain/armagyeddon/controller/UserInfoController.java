package com.blockchain.armagyeddon.controller;

import com.blockchain.armagyeddon.domain.dto.UserInfoDto;
import com.blockchain.armagyeddon.service.UserInfoService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping
public class UserInfoController {

    private final UserInfoService userInfoService;

    // 회원 가입
    @PostMapping("/user-info")
    public String saveUserInfo(@RequestBody UserInfoDto userInfoDto) {
        userInfoService.saveUserInfo(userInfoDto);
        return "save user " + userInfoDto.getName();
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already exists")
    public static class AlreadyExistsException extends RuntimeException {
        public AlreadyExistsException(String message) {
            super(message);
        }
    }


}

