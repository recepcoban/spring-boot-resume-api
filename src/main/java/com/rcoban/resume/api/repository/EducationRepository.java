package com.rcoban.resume.api.repository;

import com.rcoban.resume.api.model.entity.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<EducationEntity, Long> {

    List<EducationEntity> findAllByUserIdOrderByStartDateDesc(Long userId);

}
