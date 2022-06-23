package com.lorenchess.demo.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    private String message;

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
