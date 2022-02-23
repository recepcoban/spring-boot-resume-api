package com.rcoban.resume.api.service;

import com.rcoban.resume.api.model.dto.SkillDto;
import com.rcoban.resume.api.model.response.BaseResponse;
import com.rcoban.resume.api.model.response.SkillResponse;

import java.util.List;

public interface SkillService {

    SkillResponse getById(Long id);

    List<SkillDto> getAllByUserId(Long userId);

    SkillResponse createNewSkill(SkillDto skillDto);

    SkillResponse updateById(SkillDto skillDto);

    BaseResponse deleteById(Long id);

    List<SkillDto> getDefaultSkills();

}
