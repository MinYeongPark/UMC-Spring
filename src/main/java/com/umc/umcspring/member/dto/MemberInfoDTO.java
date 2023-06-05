package com.umc.umcspring.member.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberInfoDTO {
    private Long id;
    private String memberEmail;
    private String memberName;
}