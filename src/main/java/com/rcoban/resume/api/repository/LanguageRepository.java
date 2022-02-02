package com.rcoban.resume.api.repository;

import com.rcoban.resume.api.model.entity.LanguageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {

    List<LanguageEntity> findAllByUserId(Long userId);

}
