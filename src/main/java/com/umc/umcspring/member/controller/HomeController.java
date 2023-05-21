package com.umc.umcspring.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 기본주소 요청 시 index 페이지 출력
    @GetMapping("/")
    public String index() {
        return "index"; // -> templates 폴더의 index.html을 찾아감
    }

}
