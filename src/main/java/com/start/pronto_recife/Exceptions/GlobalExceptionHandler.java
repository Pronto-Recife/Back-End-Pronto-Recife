package com.start.pronto_recife.Exceptions;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ProblemDetail> handleUnauthorizedInSecurity(BaseException exception){
        ProblemDetail probD = exception.problemDetail();
        return ResponseEntity.status(probD.getStatus()).body(probD);
    }
}
