package com.travel.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tage on 8/30/16.
 */
@Entity
public class Retailer {
    private int id;
    private String name;
    private String location;
    private Timestamp joinTime;
    private Set<Holiday> holidays = new HashSet();


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Timestamp getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Timestamp joinTime) {
        this.joinTime = joinTime;
    }



    @ManyToMany
    @JoinTable(name = "Retailer_Holiday",
            joinColumns = {@JoinColumn(name = "retailer_id")},
            inverseJoinColumns = {@JoinColumn(name = "holiday_id")}
    )
    public Set<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(Set<Holiday> holidays) {
        this.holidays = holidays;
    }
}
