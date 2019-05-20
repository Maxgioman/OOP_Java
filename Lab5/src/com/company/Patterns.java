package com.company;
import java.io.Serializable;
import java.util.regex.*;

public class Patterns implements Serializable {

    boolean matchData(String data, Pattern pattern){
        Matcher matcher = pattern.matcher(data);
        if(matcher.matches())
            return true;
        else
            return false;
    }

    boolean confirmed(String string, String input){
        if(string.equals(input))
            return true;
        else
            return false;
    }

    Pattern sex = Pattern.compile("(Male)|(Female)");
    Pattern number = Pattern.compile("[0-9]{1,}");
    Pattern date = Pattern.compile("([0][1-9]|[1-2][0-9]|[3][0-1])+\\.+((01)|(02)|(03)|(04)|(05)|(06)|(07)|(08)|(09)|(10)|(11)|(12))+\\.+[1-2][0-9]{3}");
    Pattern name = Pattern.compile("[A-Z]{1}[a-z]{1,}");
    Pattern height = Pattern.compile("[0-2]{1}[0-9]{2}");
    Pattern eyecolor = Pattern.compile("(blue)|(green)|(grey)|(brown)|(red)|(mixed)|(tired)");
}