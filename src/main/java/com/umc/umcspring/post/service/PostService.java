package com.umc.umcspring.post.service;

import com.umc.umcspring.post.dto.PostRegisterDTO;
import com.umc.umcspring.post.entity.PostEntity;
import com.umc.umcspring.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    // 글 등록
    public long save(PostRegisterDTO postRegisterDTO, Long writer_id) {
        PostEntity postEntity = new PostEntity();
        postEntity.setTitle(postRegisterDTO.getTitle());
        postEntity.setContent(postRegisterDTO.getContent());
        postEntity.setWriter_id(writer_id);
        postEntity.setRegister_time(Timestamp.valueOf(LocalDateTime.now(ZoneId.of("Asia/Seoul"))));

        postRepository.save(postEntity);
        return postEntity.getPost_id();
    }

    // 글 상세 조회
    public PostEntity getPostDetail(Long post_id) {
        return postRepository.findById(post_id).get();
    }

    // 글 수정
    @Transactional
    public int update(Long post_id, PostRegisterDTO postRegisterDTO, Long writer_id) {
        Optional<PostEntity> oPost = postRepository.findById(post_id);
        if (!oPost.isPresent())
            return 0;

        PostEntity postEntity = oPost.get();
        postEntity.setTitle(postRegisterDTO.getTitle());
        postEntity.setContent(postRegisterDTO.getContent());
        // 등록 시간은 수정 안 하는 것으로 진행
        postRepository.save(postEntity);
        return 1;
    }

    // 글 제목 수정
    @Transactional
    public int updateTitle(Long post_id, String title, Long writer_id) {
        Optional<PostEntity> oPost = postRepository.findById(post_id);
        if (!oPost.isPresent())
            return 0;

        PostEntity postEntity = oPost.get();
        postEntity.setTitle(title);
        postRepository.save(postEntity);
        return 1;
    }

    // 글 삭제
    public Integer deletePost(Long post_id, Long writer_id) {
        Optional<PostEntity> post = postRepository.findById(post_id);
        if (post.isEmpty()) {
            return -1;
        }
        postRepository.delete(post.get());
        return 1;
    }
}
