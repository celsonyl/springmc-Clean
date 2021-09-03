package com.nyller.springmcclean.controller.handler.model;

import java.io.Serializable;

public class StandardError implements Serializable {

    private String message;
    private String path;

    public StandardError() {
    }

    public StandardError(String message, String path) {
        this.message = message;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}