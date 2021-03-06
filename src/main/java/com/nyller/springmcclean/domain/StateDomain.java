package com.nyller.springmcclean.domain;

import lombok.Builder;

import java.io.Serializable;
import java.util.Objects;

@Builder
public class StateDomain implements Serializable {

    private Integer id;
    private String name;

    public StateDomain() {
    }

    public StateDomain(Integer id, String name) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateDomain that = (StateDomain) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}