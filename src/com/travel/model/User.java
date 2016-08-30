package com.travel.model;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by tage on 8/30/16.
 */
@Entity
public class User {
    private int id ;
    private String name;
    private String password;
    private String phone;
    private int sex;
    private String birth_year;
    private String birth_month;
    private String birth_day;
    private String location_prov;
    private String location_city;
    private String location_coun;
    private DocumentType documentType;
    private String ID_number;
/*    private Set<Holiday> holidays = new HashSet<>();*/

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }

    public String getBirth_month() {
        return birth_month;
    }

    public void setBirth_month(String birth_month) {
        this.birth_month = birth_month;
    }

    public String getBirth_day() {
        return birth_day;
    }

    public void setBirth_day(String birth_day) {
        this.birth_day = birth_day;
    }

    public String getLocation_prov() {
        return location_prov;
    }

    public void setLocation_prov(String location_prov) {
        this.location_prov = location_prov;
    }

    public String getLocation_city() {
        return location_city;
    }

    public void setLocation_city(String location_city) {
        this.location_city = location_city;
    }

    public String getLocation_coun() {
        return location_coun;
    }

    public void setLocation_coun(String location_coun) {
        this.location_coun = location_coun;
    }

    public String getID_number() {
        return ID_number;
    }

    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }


    @OneToOne
    @JoinColumn(name="documentId")
    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }


  /*  @ManyToMany(mappedBy = "users")
    public Set<Holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(Set<Holiday> holidays) {
        this.holidays = holidays;
    }*/
}
