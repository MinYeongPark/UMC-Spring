package com.umc.umcspring.post.service;

import com.umc.umcspring.post.dto.PostRegisterDTO;
import com.umc.umcspring.post.entity.PostEntity;
import com.umc.umcspring.post.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
}
