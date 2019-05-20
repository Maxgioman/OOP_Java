package com.company;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Bureau implements Serializable {

    Patterns matcher = new Patterns();

    Info information = new Info();

    private String sex;
    private String number;
    private String date;
    private Info info;
    private String[] requirement;

    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        Pattern pattern = matcher.sex;
        if(matcher.matchData(sex,pattern))
            this.sex = sex;
    }

    public String getNumber() {return number;}
    public void setNumber(String number) {
        Pattern pattern = matcher.number;
        if(matcher.matchData(number,pattern))
            this.number = number;
    }

    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        Pattern pattern = matcher.date;
        if(matcher.matchData(date,pattern))
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
