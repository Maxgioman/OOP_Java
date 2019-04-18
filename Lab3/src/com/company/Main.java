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
                case "showdata":
                    functional.ShowData();
                    break;
                case "add":
                    Bureau bureau = new Bureau();
                    functional.Add(bureau);
                    data.add(bureau);
                    break;
                case "clear":
                    data.clear();
                    break;
                case "write":
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter name of file:");
                    String n = sc.nextLine();
                    functional.WriteXML(n);
                    break;
                case "read":
                    Scanner sc1 = new Scanner(System.in);
                    System.out.println("Enter name of file:");
                    String n1 = sc1.nextLine();
                    functional.ReadXML(n1);
                    break;
            }
        }
    }
}
