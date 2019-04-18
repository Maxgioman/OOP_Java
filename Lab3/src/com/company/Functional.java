package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Functional {
    public String path = "C:\\";

    protected ArrayList<Bureau> data = new ArrayList<>();

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

        //Bureau bureau = new Bureau;
        System.out.println("Sex (man or woman):");
        String sex = scanner.nextLine() + "\n";
        bureau.setSex(sex);
        System.out.println("Registration number:");
        String registationnumber = scanner.nextLine() + "\n";
        bureau.setNumber(registationnumber);
        System.out.println("Date of registration:");
        String date = scanner.nextLine() + "\n";
        bureau.setDate(date);
        System.out.println("Add some info about yourself:");
        String info = scanner.nextLine() + "\n";
        bureau.setInfo(info);
        System.out.println("Add some Demands to your partner:");
        String requirement = scanner.nextLine() + "\n";
        bureau.setRequirement(requirement);

        data.add(bureau);
    }

    public void ShowData(){
        if (data.size()>1){
            for (Bureau b : data) {
                System.out.println(b);
            }
        }
        else System.out.println("Your data is empty");
    }

    public void WriteXML(String filename){
        try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename))))
        {
            encoder.writeObject(data);
        }
        catch (FileNotFoundException e){
            System.out.println("Your file does not exist");
        }
    }

    public void ReadXML(String filename){
        try(XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))){
            Object object = decoder.readObject();
            System.out.print(object);

        }catch (FileNotFoundException e){
            System.out.println("Your file does not exist");
        }
    }
}
