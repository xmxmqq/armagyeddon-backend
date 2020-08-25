package com.blockchain.armagyeddon.service;

import com.blockchain.armagyeddon.controller.GyeUserController;
import com.blockchain.armagyeddon.domain.entity.Gye;
import com.blockchain.armagyeddon.domain.entity.GyeUser;
import com.blockchain.armagyeddon.domain.entity.UserInfo;
import com.blockchain.armagyeddon.domain.repository.GyeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GyeUserService {

    private final GyeUserRepository gyeUserRepository;
    private final UserInfoService userInfoService;
    private final GyeService gyeService;

    // gyeId와 userId로 db 조회
    public Optional<GyeUser> findGyeUser(Long gyeId, Long userId) {
        return gyeUserRepository.findByUserIdAndGyeId(userId, gyeId);
    }

    // 저장
    @Transactional
    public Long saveGyeUser(Long userId, Long gyeId) {
        Optional<Gye> findGye = gyeService.findById(gyeId);
        Optional<UserInfo> findUserInfo = userInfoService.findById(userId);

        // 중복 검사
        findGyeUser(gyeId, userId)
                .ifPresent(gyeUser -> {
                    throw new GyeUserController.AlreadyExistsException("Already exists!");
                });

        GyeUser gyeUser = new GyeUser(findGye, findUserInfo);
        GyeUser savedGyeUser = gyeUserRepository.save(gyeUser);
        return savedGyeUser.getId();
    }

    // 삭제
    @Transactional
    public void deleteGyeUser(Long gyeId, Long userId) {
        Optional<GyeUser> findGyeUser = findGyeUser(gyeId, userId);
        gyeUserRepository.delete(findGyeUser);
    }
}
