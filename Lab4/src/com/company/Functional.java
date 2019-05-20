package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Functional {
    public String path = "C:\\Users\\ACER\\IdeaProjects\\";

    protected LinkLis<Bureau> data = new LinkLis<>();
    Bureau bureau = new Bureau();

    public void MoveForward(String filepath){
        path += filepath + "\\";
        File directory = new File(path);
        File[] contents = directory.listFiles();
        if (directory.exists()) {
            for (File i : contents)
                System.out.println(i);
        }
        else
            System.out.println("Your directory does not exist");
    }

    public void MoveBack(){
        File directory = new File(path);
        String parent = directory.getParent();
        path = parent;
        File parentdirectory = new File(path);
        if(parentdirectory.exists()) {
            File[] inside = parentdirectory.listFiles();
            for (File i : inside)
                System.out.println(i);
        }else{
            System.out.println("You're in the root, please stand by");
        }
    }

    public void Show() {
        File dir = new File(path);
        if (dir.exists()) {
            File[] inside = dir.listFiles();
            for (File i : inside)
                System.out.println(i);
        }
    }

    public void Add (Bureau bureau){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Sex (man or woman):");
        String sex = scanner.nextLine() + "\n";
        bureau.setSex(sex);
        System.out.println("Registration number:");
        String registrationnumber = scanner.nextLine() + "\n";
        bureau.setNumber(registrationnumber);
        System.out.println("Date of registration:");
        String date = scanner.nextLine() + "\n";
        bureau.setDate(date);
        System.out.println("Add some info about yourself:");
        Info info = new Info();
        String n = "";
        while(!n.equals("end")){
            n = scanner.nextLine();
            switch (n) {
                case "name":
                    System.out.println("Enter name:");
                    String name = scanner.nextLine() + "\n";
                    info.setName(name);
                    break;
                case "height":
                    System.out.println("Enter name:");
                    String height = scanner.nextLine() + "\n";
                    info.setHeight(height);
                    break;
                case "eyecolor":
                    System.out.println("Enter name:");
                    String eyecolor = scanner.nextLine() + "\n";
                    info.setEyecolor(eyecolor);
                    break;
                case "dateofbirth":
                    System.out.println("Enter name:");
                    String dateofbirth = scanner.nextLine() + "\n";
                    info.setDateofbirth(dateofbirth);
                    break;
                case "hobby":
                    System.out.println("Enter name:");
                    String j = "";
                    String[] hobby = new String[0];
                    while (!j.equals("-")) {
                        j = scanner.nextLine();
                        switch (j) {
                            case "+":
                                hobby = Arrays.copyOf(hobby, hobby.length+1);
                                hobby[hobby.length-1] = scanner.nextLine()+"\n";
                                System.out.println("To add requirement enter '+', if you want to end enter '-'");
                                break;
                        }
                    }
                    info.setHobby(hobby);
                    break;
            }
        }
        bureau.setInfo(info);
        System.out.println("Add some Demands to your partner:");
        String m = "";
        String[] requirement = new String[0];
        while (!m.equals("-")) {
            m = scanner.nextLine();
            switch (m) {
                case "+":
                    requirement = Arrays.copyOf(requirement, requirement.length+1);
                    requirement[requirement.length-1] = scanner.nextLine()+"\n";
                    System.out.println("To add requirement enter '+', if you want to end - enter '-'");
                    break;
            }
        }
        bureau.setRequirement(requirement);

        data.add(bureau);
    }

    /*public void ShowData(){
        if (data.size()>1){
            for (Bureau b : data) {
                System.out.println(b);
            }
        }
        else System.out.println("Your data is empty");
    }*/


}
