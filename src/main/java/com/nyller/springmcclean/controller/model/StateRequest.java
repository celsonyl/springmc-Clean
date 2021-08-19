package com.nyller.springmcclean.controller.model;

import lombok.Builder;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Builder
public class StateRequest implements Serializable {

    private Integer id;

    @NotBlank(message = "Campo nome não pode ser vazio ou nulo")
    private String name;

    public StateRequest() {
    }

    public StateRequest(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}