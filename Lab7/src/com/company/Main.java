package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Functional functional = new Functional();
        String start="";

        ArrayList<Bureau> data = new ArrayList<>();

        while(start!="exit"){
            System.out.println("Enter command, my lord:");
            start = scanner.nextLine();
            switch (start){
                case "goto":
                    scanner = new Scanner(System.in);
                    System.out.println("Enter file name:");
                    String destination = scanner.nextLine();
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
                case "showdata":
                    functional.Show();
                    break;
                case "add":
                    Bureau bureau = new Bureau();
                    functional.Add(bureau);
                    data.add(bureau);
                    break;
                case "clear":
                    data.clear();
                    break;
                case "writexml":
                    scanner = new Scanner(System.in);
                    System.out.println("Enter name of file:");
                    String write = scanner.nextLine();
                    functional.WriteXML(write);
                    break;
                case "readxml":
                    scanner = new Scanner(System.in);
                    System.out.println("Enter name of file:");
                    String read = scanner.nextLine();
                    functional.ReadXML(read);
                    break;
                case "read":
                    System.out.print("Enter name of file:");
                    scanner = new Scanner(System.in);
                    String readxml = scanner.nextLine();
                    functional.Read(readxml);
                    break;
                case "write":
                    System.out.print("Enter name of file:");
                    scanner = new Scanner(System.in);
                    String writexml = scanner.nextLine();
                    functional.Write(writexml);
                    break;
                case "sort":
                    functional.sort();
                    break;
                case "remove":
                    scanner = new Scanner(System.in);
                    System.out.print("Enter index:");
                    int i = scanner.nextInt();
                    functional.remove(i);
                    break;
                case "search":
                    scanner = new Scanner(System.in);
                    System.out.print("Enter number:");
                    String s = scanner.nextLine();
                    functional.search(s);
                    break;

            }
        }
    }
}
