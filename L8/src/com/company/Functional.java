package com.company;

import javax.swing.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;
import javax.swing.JTextArea;

public class Functional implements Serializable{
    public String path = "C:\\Users\\ACER\\IdeaProjects\\";

    protected ArrayList<Bureau> data = new ArrayList<>();
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
    public void getNumbers(JTextArea textArea,ArrayList<Bureau> data) {
        String m="", m1;
        int counter = 1;
        for(Bureau x : data) {
            m1 = counter +") "+x.getNumber()+"\n";
            counter++;
            m+=m1;
        }
        textArea.setText(m);
    }

    public void sort(ArrayList<Bureau> data){
        data.sort(Comparator.comparing(Bureau::getNumber));
    }

    public void remove(int index,ArrayList<Bureau> data) {
        data.remove(index);
    }

    public int search(String number){
        int n = -1;
        for (int i = 0; i < data.size(); i++) {
            if(bureau.getNumber().equals(number)){
                n = i;
            }
        }
        return n;
    }

    public void show(JTextArea textArea,ArrayList<Bureau> data){
        if (data.size()>=1){
            StringBuilder show = new StringBuilder();
            int counter = 1;
            for (Bureau b : data) {
                Info info = b.getInfo();
                show.append(counter + ")\nSex: " + b.getSex() + "\nNumber: " + b.getNumber() + "\nDate of registration: " + b.getDate() + "\nAdditional info: " + info.toString() +"\nRequirements: "+b.getRequirement() + "\n");
                counter++;
            }
            textArea.setText(show.toString());
        }
        else textArea.setText("Your data is empty");
    }

    public void WriteXML(String filename,int index,JTextArea textArea,ArrayList<Bureau> data){
        try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename))))
        {
            encoder.writeObject(data.get(index));
            //data.remove(data.get(index));
        }
        catch (FileNotFoundException e){
            textArea.setText("Your file does not exist");
        }
    }

    public void ReadXML(String filename,JTextArea textArea){
        try(XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))){
            bureau = (Bureau) decoder.readObject();
            //data.add(bureau);
            bureau.i = bureau.getInfo();
            String show = "Sex: " + bureau.getSex() + "\nNumber: " + bureau.getNumber() + "\nDate of registration: " + bureau.getDate() + "\nAdditional info: " + bureau.i.toString() +"\nRequirements: "+bureau.getRequirement();
            textArea.setText(show);
        }catch (IOException e){
            textArea.setText("Your file does not exist");
        }
    }

    public void Write(String filename,int index,JTextArea textArea,ArrayList<Bureau> data)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data.get(index));
            oos.flush();
        }catch (IOException e){
            textArea.setText("Your file does not exist");
        }
    }

    public void Read(String filename, JTextArea textArea)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            bureau = (Bureau) ois.readObject();
            bureau.i = bureau.getInfo();
            String show = "Sex: " + bureau.getSex() + "\nNumber: " + bureau.getNumber() + "\nDate of registration: " + bureau.getDate() + "\nAdditional info: " + bureau.i.toString() +"\nRequirements: "+bureau.getRequirement();
            textArea.setText(show);
        }catch (IOException | ClassNotFoundException e){
            textArea.setText("Your file does not exist");
        }
    }
    /*Pattern sex = Pattern.compile("(Male)|(Female)");
    Pattern number = Pattern.compile("[0-9]{1,}");
    Pattern date = Pattern.compile("([0][1-9]|[1-2][0-9]|[3][0-1])+\\.+((01)|(02)|(03)|(04)|(05)|(06)|(07)|(08)|(09)|(10)|(11)|(12))+\\.+[1-2][0-9]{3}");
    Pattern name = Pattern.compile("[A-Z]{1}[a-z]{1,}");
    Pattern height = Pattern.compile("[0-2]{1}[0-9]{2}");
    Pattern eyecolor = Pattern.compile("(blue)|(green)|(grey)|(brown)|(red)|(mixed)|(tired)");*/
}
