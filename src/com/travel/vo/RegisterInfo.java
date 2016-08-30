package com.travel.vo;

import com.travel.model.DocumentType;

/**
 * Created by tage on 8/30/16.
 */
public class RegisterInfo {
    private String name;
    private String password1;
    private String password2;
    private String phone;
    private int sex;
    private String birth_year;
    private String birth_month;
    private String birth_day;
    private String location_prov;
    private String location_city;
    private String location_coun;
    private int documentType;
    private String ID_number;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
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

    public int getDocumentType() {
        return documentType;
    }

    public void setDocumentType(int documentType) {
        this.documentType = documentType;
    }

    public String getID_number() {
        return ID_number;
    }

    public void setID_number(String ID_number) {
        this.ID_number = ID_number;
    }
}
