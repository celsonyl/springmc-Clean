package com.nyller.springmcclean.controller.handler.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError implements Serializable {

    private final List<FieldMessage> erros = new ArrayList<>();

    public ValidationError() {
    }

    public ValidationError(String message, String path) {
        super(message, path);
    }

    public void addError(String fieldName,String message){
        erros.add(new FieldMessage(fieldName,message));
    }

    public List<FieldMessage> getErros() {
        return erros;
    }
}