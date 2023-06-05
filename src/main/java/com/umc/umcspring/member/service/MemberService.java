package com.umc.umcspring.member.service;

import com.umc.umcspring.member.dto.MemberRegisterDTO;
import com.umc.umcspring.member.entity.MemberEntity;
import com.umc.umcspring.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void save(MemberRegisterDTO memberRegisterDTO) {
        // repository의 save 메서드 호출 (조건 : entity객체를 넘겨줘야 함)
        // 1. dto -> entity 변환
        // 2. repository의 save 메서드 호출
        MemberEntity memberEntity = MemberEntity.toMemberEntity(memberRegisterDTO);
        memberRepository.save(memberEntity);
    }

//    public MemberEntity findOneByEmail(String memberEmail) {
//        return memberRepository.findByMemberEmail(memberEmail);
//    }

    public MemberEntity getMemberInfo(Long id) {
        return memberRepository.findById(id).get();
    }

    public Long login(String email, String password) {
        MemberEntity findMember = memberRepository.findOneByMemberEmailAndMemberPassword(email, password);

        if (findMember != null) {
            return findMember.getId();
        } else {
            return null;
        }
    }

    @Transactional
    public Integer update(Long id, MemberRegisterDTO memberRegisterDTO) {
        Optional<MemberEntity> oMember = memberRepository.findById(id);
        if (!oMember.isPresent())
            return 0;

        MemberEntity memberEntity = oMember.get();
        memberEntity.setMemberName(memberRegisterDTO.getMemberName());
        memberEntity.setMemberEmail(memberRegisterDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberRegisterDTO.getMemberPassword());
        memberRepository.save(memberEntity);
        return 1;
    }

//    public Long update(Long id, MemberDTO memberDTO) throws SQLException {
//        MemberEntity memberEntity = memberRepository.findById(id)
//                .orElseThrow(() -> new NullPointerException("해당 회원이 존재하지 않습니다."));
//        memberEntity.update(memberDTO);
//        return id;
//    }
}
