package com.gt.basketballapp.exception;

import com.gt.basketballapp.model.ExceptionBody;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {
    @ExceptionHandler(CourtNotFoundException.class)
    public ResponseEntity<ExceptionBody> handleCourtNotFoundException(
            CourtNotFoundException exception,
            HttpServletRequest request) {

        ExceptionBody exceptionBody = new ExceptionBody();
        exceptionBody.setMessage(exception.getMessage());
        exceptionBody.setStatus(HttpStatus.NOT_FOUND.value());
        exceptionBody.setPath(request.getRequestURI());

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(exceptionBody);
    }
}
