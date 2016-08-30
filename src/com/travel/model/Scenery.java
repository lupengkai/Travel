package com.travel.model;

import javax.persistence.*;

/**
 * Created by tage on 8/30/16.
 */

@Entity
public class Scenery {
    private int id;
    private String name;
    private String prov;
    private String city;
    private String coun;
    private SceneryLevel level;
    private SceneryType type;
    private double price;
    private String introduction;
    private String photo;

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

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCoun() {
        return coun;
    }

    public void setCoun(String coun) {
        this.coun = coun;
    }


    @OneToOne
    @JoinColumn(name = "levelId")
    public SceneryLevel getLevel() {
        return level;
    }

    public void setLevel(SceneryLevel level) {
        this.level = level;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    @OneToOne
    @JoinColumn(name="typeId")
    public SceneryType getType() {
        return type;
    }

    public void setType(SceneryType type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
