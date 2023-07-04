package com.umc.umcspring.member.controller;

import com.umc.umcspring.member.dto.MemberRegisterDTO;
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
    public ResponseEntity save(@RequestBody MemberRegisterDTO memberRegisterDTO) {
        long responseId = memberService.save(memberRegisterDTO);
        return new ResponseEntity(ResponseFormat.responseFormat(StatusCode.SUCCESS, ResponseMessage.SUCCESS_REGISTER_MEMBER, responseId), HttpStatus.OK);
    }

    // 회원 로그인
    @PostMapping("/local")
    public ResponseEntity login(
            @RequestParam("Email") String email,
            @RequestParam("Password") String password
    ) {
        Long memberId;
        if ((memberId = memberService.login(email, password)) != null) {
            return new ResponseEntity(ResponseFormat.responseFormat(StatusCode.SUCCESS, ResponseMessage.SUCCESS_LOGIN_MEMBER, memberId), HttpStatus.OK);
        } else {
            return new ResponseEntity(ResponseFormat.responseFormat(StatusCode.FAIL, ResponseMessage.FAIL_LOGIN_MEMBER, null), HttpStatus.OK);
        }
    }

    // 회원 정보 조회
    @GetMapping("/info")
    public ResponseEntity getMemberInfo(
            @RequestHeader Long id
    ) throws IOException {
        MemberEntity memberEntity = memberService.getMemberInfo(id);
        MemberInfoDTO memberInfoDTO = new MemberInfoDTO(memberEntity.getId(), memberEntity.getEmail(), memberEntity.getName());
        return new ResponseEntity(ResponseFormat.responseFormat(StatusCode.SUCCESS, ResponseMessage.SUCCESS_CHECK_MEMBER_INFO, memberInfoDTO), HttpStatus.OK);
    }

    // 회원 정보 수정
    @PutMapping("/info")
    public ResponseEntity updateMemberInfo(
            @RequestBody MemberRegisterDTO memberRegisterDTO,
            @RequestHeader("Id") Long id
    ) throws IOException {
        int result = memberService.update(id, memberRegisterDTO);
        if (result > 0) {
            return new ResponseEntity(ResponseFormat.responseFormat(StatusCode.SUCCESS, ResponseMessage.SUCCESS_UPDATE_MEMBER_INFO, null), HttpStatus.OK);
        }
        return new ResponseEntity(ResponseFormat.responseFormat(StatusCode.FAIL, ResponseMessage.FAIL_UPDATE_MEMBER_INFO, null), HttpStatus.OK);
    }

    // 회원 정보 삭제
    @DeleteMapping("/out")
    public ResponseEntity deleteMemberInfo(
            @RequestHeader("Id") Long id
    ) throws IOException {
        Integer result = memberService.deleteMemberInfo(id);
        if (result > 0) {
            return new ResponseEntity(ResponseFormat.responseFormat(StatusCode.SUCCESS, ResponseMessage.SUCCESS_DELETE_MEMBER_INFO, null), HttpStatus.OK);
        }
        return new ResponseEntity(ResponseFormat.responseFormat(StatusCode.FAIL, ResponseMessage.FAIL_DELETE_MEMBER_INFO, null), HttpStatus.OK);
    }
}
