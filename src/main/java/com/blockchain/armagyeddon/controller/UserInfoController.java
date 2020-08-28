package com.blockchain.armagyeddon.controller;

import com.blockchain.armagyeddon.domain.dto.UserInfoDto;
import com.blockchain.armagyeddon.domain.entity.UserInfo;
import com.blockchain.armagyeddon.service.UserInfoService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping
public class UserInfoController {

    private UserInfoService userInfoService;

    // db에 저장
    @PostMapping("/user-info")
    public void saveUserInfo(@RequestBody UserInfoDto userInfoDto) {
        userInfoService.saveUserInfo(userInfoDto);
    }

    @ResponseStatus(value = HttpStatus.CONFLICT, reason = "Already exists")
    public static class AlreadyExistsException extends RuntimeException {
        public AlreadyExistsException(String message) {
            super(message);
        }
    }


//    // 모든 회원 조회
//    @GetMapping(produces = {MediaType.APPLICATION_JSON_VALUE})
//    public String getAllusers() {
//        List<User> user = userService.findAll();
//
//        return <List<User>>(user, HttpStatus.OK);
//    }

//    // email로 회원 id 조회
//    @GetMapping(value = "/{email}", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public Long getUser(@PathVariable("email")  String email) {
//        UserInfo userInfo = userInfoService.findByEmail(email);
//        return userInfo.getId();
//    }

    // 회원번호로 회원 삭제
//    @DeleteMapping(value = "/{number}", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<Void> deleteUser(@PathVariable("number") Long number) {
//        userService.deleteByNumberContaining(number);
//
//        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
//    }

//    // 회원번호로 회원 수정(mbrNo로 회원을 찾아 Member 객체의 id, name으로 수정함)
//    @PutMapping(value = "/{number}", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<UserInfo> updateUser(@PathVariable("number") String number, UserInfo userInfo) {
//        userInfoService.updateBy(number, user);
//
//        return new ResponseEntity<UserInfo>(userInfo, HttpStatus.OK);
//    }

//    // 회원 입력
//    @PostMapping(value = "/save", produces = {MediaType.APPLICATION_JSON_VALUE})
//    public ResponseEntity<UserInfo> save(UserInfo user) {
//        return new ResponseEntity<UserInfo>(userInfoService.save(user), HttpStatus.OK);
//    }

//    // 회원 입력
//    @RequestMapping(value = "/saveUserInfo", method = RequestMethod.GET)
//    public void save(HttpServletRequest request, UserInfo userInfo) {

}

