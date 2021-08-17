package com.nyller.springmcclean.controller.model;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class CityRequest implements Serializable {

    private Integer id;
    private String name;

    private StateRequest stateRequest;

    public CityRequest() {
    }

    public CityRequest(Integer id, String name, StateRequest stateRequest) {
        this.id = id;
        this.name = name;
        this.stateRequest = stateRequest;
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

    public StateRequest getStateRequest() {
        return stateRequest;
    }

    public void setStateRequest(StateRequest stateRequest) {
        this.stateRequest = stateRequest;
    }
}