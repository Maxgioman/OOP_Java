package com.company;

import java.io.Serializable;

public class Bureau implements Serializable, Comparable<Bureau> {

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


    public Info getInfo() {return info;}
    public void setInfo(Info info) {
        this.info = info;
    }


    public String[] getRequirement() { return requirement; }
    public void setRequirement(String[] requirement) {
        this.requirement = requirement;
    }

    @Override
    public int compareTo(Bureau bureau) {
        if(this.getNumber().charAt(0) > bureau.getNumber().charAt(0))
        {
            return 0;
        }
        else
            return -1;
    }
}
