package com.nyller.springmcclean.domain.exceptions;

public class DataIntgrityViolation extends RuntimeException {

    public DataIntgrityViolation(String msg) {
        super(msg);
    }

    public DataIntgrityViolation(String msg, Throwable cause) {
        super(msg, cause);
    }
}