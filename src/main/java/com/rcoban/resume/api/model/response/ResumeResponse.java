package com.rcoban.resume.api.model.response;

import com.rcoban.resume.api.model.dto.*;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class ResumeResponse extends BaseResponse {

    private UserDto user;
    private List<CertificationDto> certifications;
    private List<CourseDto> courses;
    private List<EducationDto> educations;
    private List<ExperienceDto> experiences;
    private List<HobbyDto> hobbies;
    private List<LanguageDto> languages;
    private List<ProjectDto> projects;
    private List<SkillDto> skills;
    private List<SocialMediaDto> socialMedias;

}
