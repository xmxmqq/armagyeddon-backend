
package com.blockchain.armagyeddon.service;


import com.blockchain.armagyeddon.domain.entity.Gye;
import com.blockchain.armagyeddon.domain.repository.GyeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class GyeService {

    @Autowired
    private GyeRepository gyeRepository;



    public List<Gye> findAll() {

        return gyeRepository.findAll();
    }

    public Gye findById(Long id) {
        
        return gyeRepository.findById(id).get();
    }

    //계 삭제
    public void deleteById(Long id) {
        gyeRepository.deleteById(id);
    }

    //계 입력
    public Long save(Gye gye) {
        if (!gyeRepository.existsByTitle(gye.getTitle())) {
            return gyeRepository.save(gye).getId();
        } else {
            System.out.println("Already exists!");
            return 0L;
        }

    }


}