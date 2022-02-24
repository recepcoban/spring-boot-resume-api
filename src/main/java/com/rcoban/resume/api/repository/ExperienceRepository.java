package com.rcoban.resume.api.repository;

import com.rcoban.resume.api.model.entity.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Long> {

    List<ExperienceEntity> findAllByUserIdOrderByStartDateDesc(Long userId);

}
