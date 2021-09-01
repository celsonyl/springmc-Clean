package com.nyller.springmcclean.gateway.h2database.model;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "city")
@Builder
public class CityDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @SuppressWarnings("JpaDataSourceORMInspection")
    @ManyToOne
    @JoinColumn(name = "state_id")
    private StateDatabase stateDatabase;

    public CityDatabase() {
    }

    public CityDatabase(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CityDatabase(Integer id, String name, StateDatabase stateDatabase) {
        this.id = id;
        this.name = name;
        this.stateDatabase = stateDatabase;
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

    public StateDatabase getStateDatabase() {
        return stateDatabase;
    }

    public void setStateDatabase(StateDatabase stateDatabase) {
        this.stateDatabase = stateDatabase;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CityDatabase that = (CityDatabase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}