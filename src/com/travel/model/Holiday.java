package com.travel.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by tage on 8/30/16.
 */

@Entity
public class Holiday {
    private int id;
    private String theme;
    private String destination;
    private double retailPrice;
    private double childPrice;
    private double studentPrice;
    private Timestamp timestamp;
    private String traffic;
    private int days;
    private String explaination;
    private List<Scenery> secenery = new LinkedList<>();






    @ManyToMany
    @JoinTable(name = "Holiday_Scenery",
            joinColumns = {@JoinColumn(name = "holiday_id")},
            inverseJoinColumns = {@JoinColumn(name = "scenery_id")}
    )
    public List<Scenery> getSecenery() {
        return secenery;
    }

    public void setSecenery(List<Scenery> secenery) {
        this.secenery = secenery;
    }




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public double getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(double retailPrice) {
        this.retailPrice = retailPrice;
    }

    public double getChildPrice() {
        return childPrice;
    }

    public void setChildPrice(double childPrice) {
        this.childPrice = childPrice;
    }

    public double getStudentPrice() {
        return studentPrice;
    }

    public void setStudentPrice(double studentPrice) {
        this.studentPrice = studentPrice;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getTraffic() {
        return traffic;
    }

    public void setTraffic(String traffic) {
        this.traffic = traffic;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public String getExplaination() {
        return explaination;
    }

    public void setExplaination(String explaination) {
        this.explaination = explaination;
    }

/*    @ManyToMany
    @JoinTable(name = "participation",
            joinColumns = {@JoinColumn(name = "holiday_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }*/
}
