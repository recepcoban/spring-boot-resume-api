package com.rcoban.resume.api.service.impl;

import com.rcoban.resume.api.exception.RequiredFieldException;
import com.rcoban.resume.api.model.dto.*;
import com.rcoban.resume.api.model.response.MessageResponse;
import com.rcoban.resume.api.model.response.ResumeResponse;
import com.rcoban.resume.api.model.response.UserResponse;
import com.rcoban.resume.api.service.*;
import com.rcoban.resume.api.utils.MessageUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResumeServiceImpl implements ResumeService {

    private final UserService userService;
    private final CertificationService certificationService;
    private final CourseService courseService;
    private final EducationService educationService;
    private final ExperienceService experienceService;
    private final HobbyService hobbyService;
    private final LanguageService languageService;
    private final ProjectService projectService;
    private final SkillService skillService;
    private final SocialMediaService socialMediaService;

    @Override
    public ResumeResponse getResumeByUserEmail(String email) {
        if (!StringUtils.hasText(email)) {
            throw RequiredFieldException.builder().messageResponse(MessageResponse.addErrorMessage(MessageUtil.EMAIL_IS_REQUIRED)).build();
        }

        UserResponse userResponse = userService.getByEmail(email);
        List<CertificationDto> certifications = certificationService.getAllByUserId(userResponse.getUser().getId());
        List<CourseDto> courses = courseService.getAllByUserId(userResponse.getUser().getId());
        List<EducationDto> educations = educationService.getAllByUserId(userResponse.getUser().getId());
        List<ExperienceDto> experiences = experienceService.getAllByUserId(userResponse.getUser().getId());
        List<HobbyDto> hobbies = hobbyService.getAllByUserId(userResponse.getUser().getId());
        List<LanguageDto> languages = languageService.getAllByUserId(userResponse.getUser().getId());
        List<ProjectDto> projects = projectService.getAllByUserId(userResponse.getUser().getId());
        List<SkillDto> skills = skillService.getAllByUserId(userResponse.getUser().getId());
        List<SocialMediaDto> socialMedias = socialMediaService.getAllByUserId(userResponse.getUser().getId());

        ResumeResponse resumeResponse = ResumeResponse.builder()
                .user(userResponse.getUser())
                .certifications(certifications)
                .courses(courses)
                .educations(educations)
                .experiences(experiences)
                .hobbies(hobbies)
                .languages(languages)
                .projects(projects)
                .skills(skills)
                .socialMedias(socialMedias)
                .build();
        resumeResponse.addSuccessMessage();
        return resumeResponse;
    }

}
