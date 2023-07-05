package com.umc.umcspring.post.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.sql.Timestamp;

@Entity
@Table(name = "post")
@Getter
@Setter
public class PostEntity {
    @Id // pk 지정
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Long post_id;

    @Size(min=2)
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Timestamp register_time;

    @Column(nullable = false) // 연관관계 매핑 필요
    private Long writer_id;

//    public static MemberEntity toMemberEntity(MemberRegisterDTO memberRegisterDTO) {
//        MemberEntity memberEntity = new MemberEntity();
//        memberEntity.setEmail(memberRegisterDTO.getMemberEmail());
//        memberEntity.setPassword(memberRegisterDTO.getMemberPassword());
//        memberEntity.setName(memberRegisterDTO.getMemberName());
//        return memberEntity;
//    }

//    public static MemberEntity update(MemberDTO memberDTO) {
//        // https://gom20.tistory.com/115 여기 참고해보기
//        return memberEntity;
//    }
}
