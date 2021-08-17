package com.nyller.springmcclean.domain;

import lombok.Builder;

import java.io.Serializable;
import java.util.Objects;

@Builder
public class CityDomain implements Serializable {

    private Integer id;
    private String name;
    private StateDomain stateDomain;

    public CityDomain() {
    }

    public CityDomain(Integer id, String name, StateDomain stateDomain) {
        this.id = id;
        this.name = name;
        this.stateDomain = stateDomain;
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

    public StateDomain getStateDomain() {
        return stateDomain;
    }

    public void setStateDomain(StateDomain stateDomain) {
        this.stateDomain = stateDomain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDomain that = (CityDomain) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}