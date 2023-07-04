package com.umc.umcspring.post.controller;

import com.umc.umcspring.post.dto.PostInfoDTO;
import com.umc.umcspring.post.dto.PostRegisterDTO;
import com.umc.umcspring.post.entity.PostEntity;
import com.umc.umcspring.post.service.PostService;
import com.umc.umcspring.response.ResponseFormat;
import com.umc.umcspring.response.ResponseMessage;
import com.umc.umcspring.response.StatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    // 글 등록
    @PostMapping("/new")
    public ResponseEntity save(
            @RequestBody PostRegisterDTO postRegisterDTO,
            @RequestHeader Long writer_id
    ) {
        long responseId = postService.save(postRegisterDTO, writer_id);
        return new ResponseEntity(ResponseFormat.responseFormat(StatusCode.SUCCESS, ResponseMessage.SUCCESS_REGISTER_POST, responseId), HttpStatus.OK);
    }

    // 글 상세 조회
    @GetMapping("/{post_id}")
    public ResponseEntity getPostDetail(
            @PathVariable("post_id") Long post_id
    ) {
        PostEntity postEntity = postService.getPostDetail(post_id);
        PostInfoDTO postInfoDTO = new PostInfoDTO(postEntity.getTitle(), postEntity.getContent(), postEntity.getRegister_time());
        return new ResponseEntity(ResponseFormat.responseFormat(StatusCode.SUCCESS, ResponseMessage.SUCCESS_CHECK_POST_INFO, postInfoDTO), HttpStatus.OK);
    }
}
