package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

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
                    System.out.println("Enter height:");
                    String height = scanner.nextLine() + "\n";
                    info.setHeight(height);
                    break;
                case "eyecolor":
                    System.out.println("Enter eye color:");
                    String eyecolor = scanner.nextLine() + "\n";
                    info.setEyecolor(eyecolor);
                    break;
                case "dateofbirth":
                    System.out.println("Enter date of birth:");
                    String dateofbirth = scanner.nextLine() + "\n";
                    info.setDateofbirth(dateofbirth);
                    break;
                case "hobby":
                    System.out.println("Enter hobbys:");
                    System.out.println("To add hobbys enter '+', if you want to end enter '-'");
                    String j = "";
                    String[] hobby = new String[0];
                    while (!j.equals("-")) {
                        j = scanner.nextLine();
                        switch (j) {
                            case "+":
                                hobby = Arrays.copyOf(hobby, hobby.length+1);
                                hobby[hobby.length-1] = scanner.nextLine()+"\n";
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
                    System.out.println("To add requirement enter '+', if you want to end enter '-'");
                    break;
            }
        }
        bureau.setRequirement(requirement);

        data.add(bureau);
    }

    public void sort(){
        data.sort(Comparator.comparing(Bureau::getNumber));
    }

    public void remove(int index) {
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

    public void Show(){
        if (data.size()>=1){
            for (Bureau b : data) {
                Info info = new Info();
                System.out.print("Sex: " + b.getSex() + "\nNumber: " + b.getNumber() + "\nDate of registration: " + b.getDate() + "\nAdditional info: " + info.toString() +"\nRequirements: ");
                for (String i : b.getRequirement()){
                    System.out.println(i + " ");
                }
            }
        }
        else System.out.println("Your data is empty");
    }

    public void WriteXML(String filename){
        try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename))))
        {
            encoder.writeObject(data);
            System.out.println("Serialize successful");
        }
        catch (FileNotFoundException e){
            System.out.println("Your file does not exist");
        }
    }

    public void ReadXML(String filename){
        try(XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))){
            Bureau object = (Bureau) decoder.readObject();
            bureau = object;
            System.out.print(bureau.getSex() + "\n" + bureau.getDate() + "\n" + bureau.getNumber() + "\n" + bureau.getInfo() + "\n" + bureau.getRequirement() + "\n");
            for (String i : bureau.getRequirement()){
                System.out.println(i + "\n");
            }

        }catch (FileNotFoundException e){
            System.out.println("Your file does not exist");
        }
    }

    public void Write(String filename)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(data);
            oos.flush();
        }catch (IOException e){
            System.out.println("can not write a file");
        }
    }

    public void Read(String filename)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            bureau = (Bureau) ois.readObject();
            System.out.print(bureau.getSex() + "\n" + bureau.getDate() + "\n" + bureau.getDate() + "\n" + bureau.getInfo() + "\n" + bureau.getRequirement() + "\n");
            for (String i : bureau.getRequirement()){
                System.out.println(i + "\n");
            }
        } catch (IOException e){
            System.out.println("Error");
        } catch (ClassNotFoundException e){
            System.out.println("Error");
        }
    }
}
