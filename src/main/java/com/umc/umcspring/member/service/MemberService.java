package com.umc.umcspring.member.service;

import com.umc.umcspring.member.dto.MemberDTO;
import com.umc.umcspring.member.entity.MemberEntity;
import com.umc.umcspring.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberDTO memberDTO) {
        // repository의 save 메서드 호출 (조건 : entity객체를 넘겨줘야 함)
        // 1. dto -> entity 변환
        // 2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
        memberRepository.save(memberEntity);
    }
}
