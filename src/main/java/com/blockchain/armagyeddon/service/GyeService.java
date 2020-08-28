
package com.blockchain.armagyeddon.service;


import com.blockchain.armagyeddon.domain.dto.GyeDto;
import com.blockchain.armagyeddon.domain.entity.Gye;
import com.blockchain.armagyeddon.domain.repository.GyeRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.web3j.crypto.CipherException;


import java.security.InvalidAlgorithmParameterException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GyeService {


    private final GyeRepository gyeRepository;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;


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

    //계 생성
    public Long save(GyeDto gyeDto) {


        String password = passwordEncoder.encode(gyeDto.getMaster());
        String publicKey = "";
        try {
            publicKey = tokenService.createAccount(password);
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (CipherException e) {
            e.printStackTrace();
        }
        return gyeRepository.save(Gye.builder()
                .type(gyeDto.getType())
                .title(gyeDto.getTitle())
                .targetMoney(gyeDto.getTargetMoney())
                .period(gyeDto.getPeriod())
                .totalMember(gyeDto.getTotalMember())
                .state(gyeDto.getState())
                .master(gyeDto.getMaster())
                .publicKey(publicKey).build()).getId();


    }


}