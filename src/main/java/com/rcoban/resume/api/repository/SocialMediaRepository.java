package com.rcoban.resume.api.repository;

import com.rcoban.resume.api.model.entity.SocialMediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SocialMediaRepository extends JpaRepository<SocialMediaEntity, Long> {

    List<SocialMediaEntity> findAllByUserId(Long userId);

}
