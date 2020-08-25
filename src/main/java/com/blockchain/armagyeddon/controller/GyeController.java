package com.blockchain.armagyeddon.controller;
import com.blockchain.armagyeddon.domain.dto.GyeDto;
import com.blockchain.armagyeddon.domain.entity.Gye;
import com.blockchain.armagyeddon.service.GyeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class GyeController {

    @Autowired
    GyeService gyeService;

    //계 정보 입력
    @PostMapping("/gye")
    public String saveGye(@RequestBody GyeDto gye) {
        System.out.println("Controller response : " + gye.getName());
        gyeService.save(gye.toEntity());
        return "ok!";
    }

    @RequestMapping(value = "/saveGye2", method = RequestMethod.GET)
        public String save(Gye gye){
        return "ok!";
    }

    //계 정보 전체 조회
    @GetMapping("gyeLists")
    public String findGyes(Gye gye){
        gyeService.findAll();
        return "ok!";
    }

    //계 이름으로 조회
    @GetMapping("gyeList")
    public String findGye(Long id){
        gyeService.findById(id);
        return "ok!";
    }
    //계 정보 삭제
//    @DeleteMapping("gyeDelete")




}
