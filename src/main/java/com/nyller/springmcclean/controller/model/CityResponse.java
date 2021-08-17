package com.nyller.springmcclean.controller.model;

import lombok.Builder;

import java.io.Serializable;

@Builder
public class CityResponse implements Serializable {

    private Integer id;
    private String name;
    private StateResponse stateResponse;

    public CityResponse() {
    }

    public CityResponse(Integer id, String name, StateResponse stateResponse) {
        this.id = id;
        this.name = name;
        this.stateResponse = stateResponse;
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

    public StateResponse getStateResponse() {
        return stateResponse;
    }

    public void setStateResponse(StateResponse stateResponse) {
        this.stateResponse = stateResponse;
    }
}