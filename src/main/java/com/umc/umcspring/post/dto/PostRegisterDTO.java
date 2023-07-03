package com.umc.umcspring.post.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostRegisterDTO {
    private String title;
    private String content;
}
