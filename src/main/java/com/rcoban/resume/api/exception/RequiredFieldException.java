package com.rcoban.resume.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Input is required!")
public class RequiredFieldException extends RuntimeException {

}
