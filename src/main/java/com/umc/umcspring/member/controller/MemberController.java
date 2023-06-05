package com.umc.umcspring.member.controller;

import com.umc.umcspring.member.dto.MemberDTO;
import com.umc.umcspring.member.dto.MemberInfoDTO;
import com.umc.umcspring.member.entity.MemberEntity;
import com.umc.umcspring.member.service.MemberService;
import com.umc.umcspring.response.ResponseFormat;
import com.umc.umcspring.response.ResponseMessage;
import com.umc.umcspring.response.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    // 생성자 주입
    private final MemberService memberService;

    // 회원 가입
    @PostMapping("/new")
    public ResponseEntity save(@RequestBody MemberDTO memberDTO) {
        memberService.save(memberDTO);
        return new ResponseEntity(ResponseFormat.responseFormat(StatusCode.SUCCESS, ResponseMessage.SUCCESS_REGISTER_MEMBER, memberDTO.getId()), HttpStatus.OK);
    }

    // 회원 정보 조회
    @GetMapping("/info")
    public ResponseEntity getMemberInfo(
            @RequestHeader Long id
    ) throws IOException {
        MemberEntity memberEntity = memberService.getMemberInfo(id);
        MemberInfoDTO memberInfoDTO = new MemberInfoDTO(memberEntity.getId(), memberEntity.getMemberEmail(), memberEntity.getMemberName());
        return new ResponseEntity(ResponseFormat.responseFormat(StatusCode.SUCCESS, ResponseMessage.SUCCESS_CHECK_MEMBER_INFO, memberInfoDTO), HttpStatus.OK);
    }

//    @PutMapping("/info")
//    public String updateMemberInfo(
//            @RequestBody MemberDTO memberDTO,
//            @RequestHeader Long id
//    ) throws IOException {
//        memberService.update(id, memberDTO);
//    }
}
