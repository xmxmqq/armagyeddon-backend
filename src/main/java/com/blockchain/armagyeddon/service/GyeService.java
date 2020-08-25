package com.blockchain.armagyeddon.service;

<<<<<<< HEAD
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GyeService {
=======
import com.blockchain.armagyeddon.domain.dto.GyeDto;
import com.blockchain.armagyeddon.domain.entity.Gye;
import com.blockchain.armagyeddon.domain.repository.GyeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GyeService {

    @Autowired
    private GyeRepository gyeRepository;


    //계 정보 조회
    public List<Gye> findAll(){
        List<Gye> gyes = new ArrayList<>();
        gyeRepository.findAll().forEach(e -> gyes.add(e));
        return gyes;
    }

    public Optional<Gye> findById(Long id){
        Optional<Gye> gye = gyeRepository.findById(id);
        return gye;
    }

    public Gye findByName(String name){
        Gye gye = gyeRepository.findByName(name);
        return gye;
    }


    //계 삭제
    public void deleteById(Long id){
        gyeRepository.deleteById(id);
    }

    //계 입력
    public void save(Gye gye){
        if(!gyeRepository.existsByName(gye.getName())){
            gyeRepository.save(gye);
        } else {
            System.out.println("exitsewfwegefwekj");
        }

    }


>>>>>>> ead80efd8c804ff56a50b7596c1daf68c2eed0c6
}
