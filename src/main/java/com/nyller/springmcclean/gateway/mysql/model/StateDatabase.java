package com.nyller.springmcclean.gateway.mysql.model;

import lombok.Builder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "state")
@Builder
public class StateDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "stateDatabase")
    private List<CityDatabase> cityDatabases = new ArrayList<>();

    public StateDatabase() {
    }

    public StateDatabase(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public StateDatabase(Integer id, String name, List<CityDatabase> cityDatabases) {
        this.id = id;
        this.name = name;
        this.cityDatabases = cityDatabases;
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

    public List<CityDatabase> getCityDatabases() {
        return cityDatabases;
    }

    public void setCityDatabases(List<CityDatabase> cityDatabases) {
        this.cityDatabases = cityDatabases;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StateDatabase that = (StateDatabase) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}