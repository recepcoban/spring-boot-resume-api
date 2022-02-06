package com.rcoban.resume.api.service;

import com.rcoban.resume.api.model.response.ResumeResponse;

public interface ResumeService {

    ResumeResponse getResumeByUserEmail(String email);

    ResumeResponse getDefaultResume();

}
