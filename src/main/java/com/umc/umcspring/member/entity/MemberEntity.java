package com.umc.umcspring.member.entity;

import com.umc.umcspring.member.dto.MemberRegisterDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member_table")
@Getter
@Setter
public class MemberEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true) // unique 제약조건 추가
    private String memberEmail;

    @Column
    private String memberPassword;

    @Column
    private String memberName;

    public static MemberEntity toMemberEntity(MemberRegisterDTO memberRegisterDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberRegisterDTO.getMemberEmail());
        memberEntity.setMemberPassword(memberRegisterDTO.getMemberPassword());
        memberEntity.setMemberName(memberRegisterDTO.getMemberName());
        return memberEntity;
    }

//    public static MemberEntity update(MemberDTO memberDTO) {
//        // https://gom20.tistory.com/115 여기 참고해보기
//        return memberEntity;
//    }
}
