package com.rcoban.resume.api.repository;

import com.rcoban.resume.api.model.entity.SkillEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<SkillEntity, Long> {

    List<SkillEntity> findAllByUserId(Long userId);

}
