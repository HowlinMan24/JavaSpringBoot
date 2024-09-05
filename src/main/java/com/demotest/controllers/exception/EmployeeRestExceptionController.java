package com.demotest.controllers.exception;

import com.demotest.util.exceptions.EmployeeNotFoundException;
import com.demotest.util.responses.EmployeeErrorResponse;
import com.demotest.util.responses.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionController {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException e) {
        EmployeeErrorResponse response = new EmployeeErrorResponse();
        response.setStatus(HttpStatus.NOT_FOUND.value());
        response.setMessage(e.getMessage());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception e) {
        StudentErrorResponse response = new StudentErrorResponse();
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        response.setMessage(e.getMessage());
        response.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
