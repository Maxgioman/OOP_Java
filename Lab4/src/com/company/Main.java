package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Functional functional = new Functional();
        String start = "";

        LinkLis<Bureau> data = new LinkLis<>();
        Bureau bureau = new Bureau();

        if (args.length == 1 && args[0].equals("-auto")){
            System.out.println("AUTOMODE : ON");

            System.out.println("Enter command, my lord:   add");
            System.out.println("Sex: Male");
            bureau.setSex("Male" + "\n");

            System.out.println("Date: 17.04.2019");
            bureau.setDate("17.04.2019" + "\n");

            System.out.println("Number: 142456");
            bureau.setNumber("142456" + "\n");

            System.out.println("Info: ");
            Info info = new Info();
            System.out.println("Name: Max");
            info.setName("Max" + "\n");
            System.out.println("Height: 175");
            info.setHeight("175" + "\n");
            System.out.println("Eye color: blue");
            info.setEyecolor("blue" + "\n");
            System.out.println("Date of birth: 01.09.2001");
            info.setDateofbirth("01.09.2001" + "\n");
            System.out.println("Hobbys: Computer Games, Football, Sport");
            String[] hobbys = new String[3];
            hobbys[0] = "Computer Games";
            hobbys[1] = "Football";
            hobbys[2] = "Sport";
            info.setHobby(hobbys);
            bureau.setInfo(info);

            System.out.print("Requirements: Female, 160+ height, Ukraine");
            String[] req = new String[3];
            req[0] = "Female";
            req[1] = "160+ height";
            req[2] = "Ukraine";
            bureau.setRequirement(req);
            System.out.println("Added");
            data.add(bureau);
            System.out.println("Enter command, my lord:   writexml");
            data.WriteXML("newfile.xml", data, 0);
            System.out.println("Enter command, my lord:   clear");
            data.clear();
            System.out.println("your command:   readxml");
            data.ReadXML("newfile.xml");
            System.out.println("\nyour command:   tostring");
            System.out.println(data.toString());

            System.out.println("AUTOMODE : OFF");
            return;
        }


            while(start!="exit"){
            System.out.println("Enter command, my lord:");
            start = scanner.nextLine();
            switch (start) {
                case "goto":
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Enter file name:");
                    String destination = scan.nextLine();
                    functional.MoveForward(destination);
                    break;
                case "exit":
                    return;
                case "back":
                    functional.MoveBack();
                    break;
                case "show":
                    functional.Show();
                    break;
                case "toarray":
                    data.toArray();
                    break;
                case "tostring":
                    data.toString();
                    break;
                case "contains":
                    System.out.print("Enter index of element:");
                    int ii = scanner.nextInt();
                    try {
                        System.out.println("Founded: " + data.getElement(ii));
                    }
                    catch (NullPointerException e) {
                        System.out.println("Element not found");
                    }
                    break;
                case "add":
                    Bureau bureau1 = new Bureau();
                    functional.Add(bureau1);
                    data.add(bureau1);
                    break;
                case "clear":
                    data.clear();
                    break;
                case "remove":
                    System.out.print("Enter index of element:");
                    int i = scanner.nextInt();
                    data.remove(i);
                    break;
                case "writexml":
                    scanner = new Scanner(System.in);
                    System.out.println("Enter name of file:");
                    String writename = scanner.nextLine();
                    System.out.println("Enter index of object:");
                    int i1 = scanner.nextInt();
                    data.WriteXML(writename, data, i1);
                    break;
                case "readxml":
                    scanner = new Scanner(System.in);
                    System.out.println("Enter name of file:");
                    String readname = scanner.nextLine();
                    data.ReadXML(readname);
                    break;
                case "read":
                    System.out.print("filename: ");
                    scanner = new Scanner(System.in);
                    String readname1 = scanner.nextLine();
                    data.Read(readname1);
                    break;
                case "write":
                    System.out.print("filename: ");
                    scanner = new Scanner(System.in);
                    String writename1 = scanner.nextLine();
                    System.out.print("index of object: ");
                    int i2 = scanner.nextInt();
                    data.Write(writename1, data, i2);
                    break;

                }
            }

    }
}
