package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Hello, stranger!");
        MyContainer Container = new MyContainer();
        byte command;
        while (true) {
            System.out.println("Enter command: ");
            System.out.println("1 - Make&Fill container");
            System.out.println("2 - Clear container");
            System.out.println("3 - Show container");
            System.out.println("4 - Container menu");
            System.out.println("5 - Exit");
            command = in.nextByte();
            switch (command) {
                case 1:
                    System.out.println("Enter string:");
                    in.nextLine();
                    Container.add(in.nextLine());
                    break;
                case 2:
                    Container.clear();
                    System.out.println("Well done!");
                    break;
                case 3:
                    for(String s: Container.data)
                        System.out.println(s);
                    break;
                case 4:
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
                            Container.add(in.nextLine());
                            break;
                        case 2:
                            System.out.println("Enter element:");
                            in.nextLine();
                            Container.remove(in.nextLine());
                            break;
                        case 3:
                            for (String i : Container.toArray())
                            {
                                System.out.println(i);
                            }
                            break;
                        case 4:
                            System.out.println(Container.size());
                            break;
                        case 5:
                            System.out.println(Container.maxSize());
                            break;
                        case 6:
                            System.out.println("Enter string to check if it exist in container:");
                            in.nextLine();
                            System.out.println(Container.contains(in.nextLine()));
                            break;
                        case 7:
                            System.out.print("Enter index: ");
                            int SubContainerIndex = in.nextInt();
                            if (SubContainerIndex > Container.size() || SubContainerIndex < 1) {
                                System.out.println("Error! Index not found");
                                break;
                            }
                            System.out.println("[" + SubContainerIndex + "] is sub container " + Container.containsAll(Container));
                            break;
                        case 8:
                            System.out.println("Enter file name(name.format): ");
                            in.nextLine();
                            Container.serialize(in.nextLine());
                            break;
                        case 9:
                            System.out.println("Enter file name(name.format): ");
                            in.nextLine();
                            Container.deserialize(in.nextLine());
                            break;
                        case 10:
                            System.out.print("Enter index: ");
                            Container.get(in.nextInt());
                            break;
                        case 11:
                            System.out.println("Enter element:");
                            in.nextLine();
                            Container.indexOf(in.nextLine());
                            break;
                        case 12:
                            Container.sort();
                            System.out.println("Well done!");
                            break;
                        case 13:
                            for (String i : Container) {
                                System.out.println(i);
                            }
                            break;
                        case 14:
                            MyIterator i = (MyIterator) Container.iterator();
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
                case 5:
                    System.out.println("Go on your own way, stranger");
                    System.exit(0);
                default:
                    System.out.println("Command not found");
            }

        }
    }
}