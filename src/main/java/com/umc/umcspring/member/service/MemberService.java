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

    // 회원 가입
    public long save(MemberRegisterDTO memberRegisterDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberName(memberRegisterDTO.getMemberName());
        memberEntity.setMemberEmail(memberRegisterDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberRegisterDTO.getMemberPassword());

        memberRepository.save(memberEntity);
        return memberEntity.getId();
    }

    // 회원 정보 조회
    public MemberEntity getMemberInfo(Long id) {
        return memberRepository.findById(id).get();
    }

    // 회원 로그인
    public Long login(String email, String password) {
        MemberEntity findMember = memberRepository.findOneByMemberEmailAndMemberPassword(email, password);

        if (findMember != null) {
            return findMember.getId();
        } else {
            return null;
        }
    }

    // 회원 정보 수정
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

    // 회원 정보 삭제
    public Integer deleteMemberInfo(Long id) {
        Optional<MemberEntity> member = memberRepository.findById(id); // id값에 해당하는 회원이 없다면 예외처리
        if (member.isEmpty()) {
            return -1;
        }
        memberRepository.delete(member.get());
        return 1;
    }

//    public Long update(Long id, MemberDTO memberDTO) throws SQLException {
//        MemberEntity memberEntity = memberRepository.findById(id)
//                .orElseThrow(() -> new NullPointerException("해당 회원이 존재하지 않습니다."));
//        memberEntity.update(memberDTO);
//        return id;
//    }
}
