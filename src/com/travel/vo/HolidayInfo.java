package com.travel.vo;

import com.travel.model.Scenery;

import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by tage on 9/1/16.
 */
public class HolidayInfo {

    private int id;
    private String h_theme;
    private String destination;
    private double retailPrice;
    private double childPrice;
    private double studentPrice;
    private String timestamp;
    private String traffic;
    private int days;
    private String explanation;
    private List<Scenery> sceneries = new LinkedList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getH_theme() {
        return h_theme;
    }

    public void setH_theme(String h_theme) {
        this.h_theme = h_theme;
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

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
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

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public List<Scenery> getSceneries() {
        return sceneries;
    }

    public void setSceneries(List<Scenery> sceneries) {
        this.sceneries = sceneries;
    }
}
