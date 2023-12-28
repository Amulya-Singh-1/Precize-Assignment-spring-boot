package com.task.assignment.customException;

public class StudentExistsException extends RuntimeException {

    public StudentExistsException(String message) {
        super(message);
    }
}
