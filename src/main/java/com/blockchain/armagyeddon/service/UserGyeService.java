package com.blockchain.armagyeddon.service;

import com.blockchain.armagyeddon.domain.entity.Gye;
import com.blockchain.armagyeddon.domain.entity.UserGye;
import com.blockchain.armagyeddon.domain.entity.UserInfo;
import com.blockchain.armagyeddon.domain.repository.UserGyeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserGyeService {
    private UserGyeRepository userGyeRepository;
    private UserInfoService userInfoService;
    private GyeService gyeService;

    public Optional<UserGye> findUserGye(Long userId, Long gyeId) {
        return userGyeRepository.findByUserIdAndGyeId(userId, gyeId);
    }

//    // 등록
//    @Transactional
//    public Long saveGroupTeacher(Long groupId, Long teacherId) {
//        UserInfo findUserInfo = UserInfoService.findUserInfo(userId);
//        Gye findGye = GyeService.findGye(GyeId);
//
//        findGroupTeacher(groupId, teacherId)
//                .ifPresent(groupTeacher -> {
//                    throw new DuplicateGroupTeacherException("이미 지정된 담임 선생님 입니다.");
//                });
//
//        GroupTeacher groupTeacher = new GroupTeacher(findGroups, findTeacher);
//        GroupTeacher savedGroupTeacher = groupTeacherRepository.save(groupTeacher);
//        return savedGroupTeacher.getId();
//    }
}
