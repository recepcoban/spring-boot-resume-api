package com.rcoban.resume.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Data not found!")
public class NotFoundException extends RuntimeException {

}
