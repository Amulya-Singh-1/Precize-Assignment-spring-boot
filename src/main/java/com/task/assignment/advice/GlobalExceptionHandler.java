package com.task.assignment.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.task.assignment.customException.StudentExistsException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentExistsException.class)
    public ResponseEntity<String> handleStudentExistsException(StudentExistsException ex) {
        // Customize the response based on your requirements
        return new ResponseEntity<>("Student already exists: " + ex.getMessage(), HttpStatus.CONFLICT);
    }

    // Add more @ExceptionHandler methods for other exceptions if needed

//    // Generic exception handler for other unhandled exceptions
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<String> handleException(Exception ex) {
//        // Customize the response based on your requirements
//        return new ResponseEntity<>("An unexpected error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
