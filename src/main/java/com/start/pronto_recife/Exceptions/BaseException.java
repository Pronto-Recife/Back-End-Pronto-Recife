package com.start.pronto_recife.Exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

@RequiredArgsConstructor
public class BaseException extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String title;
    private final String detail;

    public ProblemDetail problemDetail(){
        ProblemDetail probD = ProblemDetail.forStatus(httpStatus);
        probD.setTitle(title);
        probD.setDetail(detail);
        return probD;
    }
}
