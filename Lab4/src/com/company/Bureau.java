package com.company;

import java.io.Serializable;

public class Bureau implements Serializable {

    private String sex;
    private String number;
    private String date;
    private Info info;
    private String[] requirement;

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getNumber() {return number;}
    public void setNumber(String number) {
        this.number = number;
    }


    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }


    public Info getInfo() {
        return info;
    }
    public void setInfo(Info info) {
        this.info = info;
    }


    public String[] getRequirement() { return requirement; }
    public void setRequirement(String[] requirement) {
        this.requirement = requirement;
    }
}
