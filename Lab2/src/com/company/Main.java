package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("hi!");
        ArrayList<MyContainer> ContainerList = new ArrayList<>();
        byte command;
        while (true) {
            System.out.println("Enter command: ");
            System.out.println("1 - Make container");
            System.out.println("2 - Fill container");
            System.out.println("3 - Clear container");
            System.out.println("4 - Show container");
            System.out.println("5 - Containers' list");
            System.out.println("6 - Container menu");
            System.out.println("7 - Exit");
            command = in.nextByte();
            switch (command) {
                case 1:
                    System.out.print("Enter container's max length: ");
                    ContainerList.add(new MyContainer(in.nextInt()));
                    System.out.println("Success! Your container's size is [" + ContainerList.size() + "]");
                    break;
                case 2:
                    System.out.print("Enter container's index: ");
                    int index = in.nextInt();
                    if (index > ContainerList.size() || index < 0) {
                        System.out.println("Error! Index not found");
                        break;
                    }
                    System.out.println("Enter " + ContainerList.get(index-1).maxSize() + " strings one by one:");
                    in.nextLine();
                    for (int i = 0, n = ContainerList.get(index-1).maxSize(); i < n; i++) {
                        ContainerList.get(index-1).add(in.nextLine());
                    }
                    break;
                case 3:
                    System.out.print("Enter container's index: ");
                    int DeleteIndex = in.nextInt();
                    if (DeleteIndex > ContainerList.size() || DeleteIndex < 1) {
                        System.out.println("Error! Index not found");
                        break;
                    }
                    ContainerList.get(DeleteIndex-1).clear();
                    System.out.println("Well done!");
                    break;
                case 4:
                    System.out.print("Enter container's index: ");
                    int ToShowIndex = in.nextInt();
                    if (ToShowIndex > ContainerList.size() || ToShowIndex < 1) {
                        System.out.println("Error! Index not found");
                        break;
                    }
                    System.out.println(ContainerList.get(ToShowIndex-1).toString());
                    break;
                case 5:
                    for (int i = 0; i < ContainerList.size(); i++) {
                        System.out.println("[" + (i+1) + "] - data: [" + ContainerList.get(i).size() +
                                "/" + ContainerList.get(i).maxSize() + "]");
                    }
                    break;
                case 6:
                    System.out.print("Enter container's index: ");
                    int MenuIndex = in.nextInt();
                    if (MenuIndex > ContainerList.size() || MenuIndex < 1) {
                        System.out.println("Error! not found");
                        break;
                    }
                    System.out.println("Next command, sir! ");
                    System.out.println("1 - Add element");
                    System.out.println("2 - Remove element");
                    System.out.println("3 - Convert to array and iterate through");
                    System.out.println("4 - Current size");
                    System.out.println("5 - Max size");
                    System.out.println("6 - Check string");
                    System.out.println("7 - Check subcontainer");
                    System.out.println("8 - Write to file (serialize)");
                    System.out.println("9 - Read from file (deserialize)");
                    System.out.println("10 - Get element by index");
                    System.out.println("11 - Get element's index");
                    System.out.println("12 - Sort");
                    System.out.println("13 - Iterate through container (foreach)");
                    System.out.println("14 - Iterate through container (while)");
                    System.out.println("15 - Return");
                    command = in.nextByte();
                    switch (command) {
                        case 1:
                            System.out.println("Enter element:");
                            in.nextLine();
                            ContainerList.get(MenuIndex-1).add(in.nextLine());
                            break;
                        case 2:
                            System.out.println("Enter element:");
                            in.nextLine();
                            ContainerList.get(MenuIndex-1).remove(in.nextLine());
                            break;
                        case 3:
                            for (String i : ContainerList.get(MenuIndex-1).toArray())
                            {
                                System.out.println(i);
                            }
                            break;
                        case 4:
                            System.out.println(ContainerList.get(MenuIndex-1).size());
                            break;
                        case 5:
                            System.out.println(ContainerList.get(MenuIndex-1).maxSize());
                            break;
                        case 6:
                            System.out.println("Enter string to check if it exist in container:");
                            in.nextLine();
                            System.out.println(ContainerList.get(MenuIndex-1).contains(in.nextLine()));
                            break;
                        case 7:
                            System.out.print("Enter index: ");
                            int SubContainerIndex = in.nextInt();
                            if (SubContainerIndex > ContainerList.size() || SubContainerIndex < 1) {
                                System.out.println("Error! Index not found");
                                break;
                            }
                            System.out.println("[" + SubContainerIndex + "] is sub container of [" + MenuIndex +
                                    "] - " + ContainerList.get(MenuIndex-1).containsAll(ContainerList
                                    .get(SubContainerIndex-1)));
                            break;
                        case 8:
                            System.out.println("Enter file name(name.format): ");
                            in.nextLine();
                            ContainerList.get(MenuIndex-1).serialize(in.nextLine());
                            break;
                        case 9:
                            System.out.println("Enter file name(name.format): ");
                            in.nextLine();
                            ContainerList.get(MenuIndex-1).deserialize(in.nextLine());
                            break;
                        case 10:
                            System.out.print("Enter index: ");
                            ContainerList.get(MenuIndex-1).get(in.nextInt());
                            break;
                        case 11:
                            System.out.println("Enter element:");
                            in.nextLine();
                            ContainerList.get(MenuIndex-1).indexOf(in.nextLine());
                            break;
                        case 12:
                            ContainerList.get(MenuIndex-1).sort();
                            System.out.println("Well done!");
                            break;
                        case 13:
                            for (String i : ContainerList.get(MenuIndex-1)) {
                                System.out.println(i);
                            }
                            break;
                        case 14:
                            MyIterator i = (MyIterator) ContainerList.get(MenuIndex-1).iterator();
                            while (i.hasNext()) {
                                System.out.println(i.next());
                            }
                            break;
                        case 15:
                            break;
                        default:
                            System.out.println("Command not found!");
                    }
                    break;
                case 7:
                    System.out.println("Go on your own way, stalker");
                    System.exit(0);
                default:
                    System.out.println("Command not found");
            }
        }
    }
}