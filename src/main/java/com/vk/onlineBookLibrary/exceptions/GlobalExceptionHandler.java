package com.vk.onlineBookLibrary.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ProblemDetail handleBookAlreadyExistException(BookAlreadyExistsException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.CONFLICT, ex.getMessage());

    }

    @ExceptionHandler(NoSuchBookExistsException.class)
    public ProblemDetail handleNoSuchBookExistException(NoSuchBookExistsException ex) {
        return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());

    }

}
