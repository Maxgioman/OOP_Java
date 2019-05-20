package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class Functional {
    public String path = "C:\\Users\\ACER\\IdeaProjects\\";

    protected LinkLis<Bureau> data = new LinkLis<>();
    Bureau bureau = new Bureau();
    Patterns match = new Patterns();

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

        String s = "";
        while(0!=1){
            System.out.print("Sex (man or woman):");
            s = scanner.nextLine()+"\n";
            bureau.setSex(s);
            if(match.confirmed(s,bureau.getSex())) {
                break;
            }
            else
                System.out.println("Wrong format");
        }

        s = "";
        while(0!=1){
            System.out.print("Number");
            s = scanner.nextLine()+"\n";
            bureau.setNumber(s);
            if(match.confirmed(s,bureau.getNumber())) {
                break;
            }
            else
                System.out.println("Wrong format");
        }

        s = "";
        while(0!=1){
            System.out.print("Date of registration:");
            s = scanner.nextLine()+"\n";
            bureau.setDate(s);
            if(match.confirmed(s,bureau.getDate())) {
                break;
            }
            else
                System.out.println("Wrong format");
        }
        System.out.println("Add some info about yourself:");
        Info info = new Info();
        String n = "";
        while(!n.equals("end")){
            n = scanner.nextLine();
            switch (n) {
                case "name":
                    while (0!=1) {
                        System.out.println("Enter name:");
                        String name = scanner.nextLine() + "\n";
                        info.setName(name);
                        if(match.confirmed(s,info.getName())) {
                            break;
                        }
                        else
                            System.out.println("Wrong format");
                    }
                    break;
                case "height":
                    while (0!=1) {
                        System.out.println("Enter height:");
                        String height = scanner.nextLine() + "\n";
                        info.setHeight(height);
                        if (match.confirmed(height, info.getHeight())) {
                            break;
                        } else
                            System.out.println("Wrong format");
                    }
                    break;
                case "eyecolor":
                    while (0!=1) {
                        System.out.println("Enter eye color:");
                        String eyecolor = scanner.nextLine() + "\n";
                        info.setEyecolor(eyecolor);
                        if (match.confirmed(eyecolor, info.getEyecolor())) {
                            break;
                        } else
                            System.out.println("Wrong format");
                    }
                    break;
                case "dateofbirth":
                    while (0!=1) {
                        System.out.println("Enter name:");
                        String dateofbirth = scanner.nextLine() + "\n";
                        info.setDateofbirth(dateofbirth);
                        if (match.confirmed(dateofbirth, info.getDateofbirth())) {
                            break;
                        } else
                            System.out.println("Wrong format");
                        break;
                    }
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
}
