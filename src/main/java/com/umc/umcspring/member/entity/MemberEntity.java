package com.umc.umcspring.member.entity;

import com.umc.umcspring.member.dto.MemberRegisterDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "member")
@Getter
@Setter
public class MemberEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long id;

    @Column(unique = true) // unique 제약조건 추가
    private String email;

    @Column
    private String password;

    @Column
    private String name;

    public static MemberEntity toMemberEntity(MemberRegisterDTO memberRegisterDTO) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setEmail(memberRegisterDTO.getMemberEmail());
        memberEntity.setPassword(memberRegisterDTO.getMemberPassword());
        memberEntity.setName(memberRegisterDTO.getMemberName());
        return memberEntity;
    }

//    public static MemberEntity update(MemberDTO memberDTO) {
//        // https://gom20.tistory.com/115 여기 참고해보기
//        return memberEntity;
//    }
}
