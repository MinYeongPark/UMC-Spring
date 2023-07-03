package com.umc.umcspring.member.repository;

import com.umc.umcspring.member.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {
    Optional<MemberEntity> findById(Long id);

    MemberEntity findOneByEmailAndPassword(String memberEmail, String memberPassword);

    @Override
    void delete(MemberEntity entity);
}
