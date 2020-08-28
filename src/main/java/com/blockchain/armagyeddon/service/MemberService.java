package com.blockchain.armagyeddon.service;

import com.blockchain.armagyeddon.domain.entity.Gye;
import com.blockchain.armagyeddon.domain.entity.Member;
import com.blockchain.armagyeddon.domain.entity.UserInfo;
import com.blockchain.armagyeddon.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final GyeService gyeService;
    private final UserInfoService userInfoService;

    @Transactional
    public Long saveMember(Long gyeId, Long userId) {
        Gye gye = gyeService.findById(gyeId);
        UserInfo userInfo = userInfoService.getUserInfo(userId);

        Member member = Member.builder()
                .gye(gye)
                .userInfo(userInfo).build();
        Member savedMember = memberRepository.save(member);

        return savedMember.getId();
    }
}
