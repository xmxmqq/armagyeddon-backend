package com.blockchain.armagyeddon.controller;

import com.blockchain.armagyeddon.service.GyeUserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/gye/{gyeId}/user")

public class GyeUserController {

    private final GyeUserService gyeUserService;

    // gye-user db 생성
    @PostMapping
    public String createGyeUser(@PathVariable Long gyeId, @RequestParam Long userId) {
        gyeUserService.saveGyeUser(gyeId, userId);
        return "redirect:/gye/{gyeId}";
    }

    // gye-user db 삭제
    @DeleteMapping("{userId}")
    public String deleteGyeUser(@PathVariable Long gyeId, @PathVariable Long userId) {
        gyeUserService.deleteGyeUser(gyeId, userId);
        return "redirect:/groups/{groupsId}";
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already exists")
    public static class AlreadyExistsException extends RuntimeException {
        public AlreadyExistsException(String message) {
            super(message);
        }
    }
}
