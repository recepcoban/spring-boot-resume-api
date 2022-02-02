package com.rcoban.resume.api.repository;

import com.rcoban.resume.api.model.entity.CertificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CertificationRepository extends JpaRepository<CertificationEntity, Long> {

    List<CertificationEntity> findAllByUserId(Long userId);

}
