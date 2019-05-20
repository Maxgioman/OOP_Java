package com.company;

import java.io.Serializable;

public class Info implements Serializable {

    private String name;
    private String height;
    private String eyecolor;
    private String dateofbirth;
    private String[] hobby;
    public Info(){}

    public Info(String name,String height,String eyecolor,String dateofbirth,String[] hobby){
        this.name = name;
        this.height = height;
        this.eyecolor = eyecolor;
        this.dateofbirth = dateofbirth;
        this.hobby = hobby;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getHeight() {
        return height;
    }
    public void setHeight(String height) {
        this.height = height;
    }

    public String getEyecolor() {
        return eyecolor;
    }
    public void setEyecolor(String eyecolor) {
        this.eyecolor = eyecolor;
    }

    public String getDateofbirth() {return dateofbirth;}
    public void setDateofbirth(String dateofbirth) {
        this.dateofbirth = dateofbirth;
    }

    public String[] getHobby() {
        return hobby;
    }
    public void setHobby(String[] hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString(){
        String str = "\nName: " + name + "\nHeight: " + height + "\nEye color: " + eyecolor + "\nDate of birth: " + dateofbirth + "\nHobbys: ";
        for(String s : hobby)
        {
            str += s + " ";
        }
        return str;
    }
}
