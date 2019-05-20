package com.company;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Info implements Serializable {

    Patterns matcher = new Patterns();

    private String name;
    private String height;
    private String eyecolor;
    private String dateofbirth;
    private String[] hobby;

    public String getName() { return name; }

    public void setName(String name) {
        Pattern pattern = matcher.name;
        if(matcher.matchData(name,pattern))
            this.name = name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        Pattern pattern = matcher.height;
        if(matcher.matchData(height,pattern))
            this.height = height;
    }

    public String getEyecolor() {
        return eyecolor;
    }

    public void setEyecolor(String eyecolor) {
        Pattern pattern = matcher.eyecolor;
        if(matcher.matchData(eyecolor,pattern))
            this.eyecolor = eyecolor;
    }

    public String getDateofbirth() {
        return dateofbirth;
    }

    public void setDateofbirth(String dateofbirth) {
        Pattern pattern = matcher.date;
        if(matcher.matchData(dateofbirth,pattern))
            this.dateofbirth = dateofbirth;
    }

    public String[] getHobby() {
        return hobby;
    }

    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }
}
