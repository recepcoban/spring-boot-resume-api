package com.rcoban.resume.api.repository;

import com.rcoban.resume.api.model.entity.HobbyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HobbyRepository extends JpaRepository<HobbyEntity, Long> {

    List<HobbyEntity> findAllByUserId(Long userId);

}
