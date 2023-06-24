package com.umc.umcspring.member.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberRegisterDTO {
    private String memberEmail;
    private String memberPassword;
    private String memberName;
}
