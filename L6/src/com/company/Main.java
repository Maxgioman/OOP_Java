package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner in = new Scanner(System.in);
        String command;
        MyContainer test = null;
        Functional f = new Functional();
        int SIZE = 0;
        int timeEnd = 0;
        double threadTime = 0;
        double noThreadTime = 0;
        while(true)
        {
            System.out.print("Enter command, my lord:\n");
            command = in.nextLine();
            switch(command)
            {
                case "create":
                {
                    test = new MyContainer();
                    System.out.println("Enter size of input data: ");
                    SIZE = Integer.parseInt(in.nextLine());
                    System.out.println("Enter Time limit(seconds): ");
                    timeEnd = 1000 * Integer.parseInt(in.nextLine());
                    break;
                }
                case "fill":
                {
                    if(test == null)
                    {
                        System.out.println("Create container first");
                        break;
                    }
                    f.fill(test,SIZE);
                    break;
                }
                case "thread":
                {
                    Min min;
                    Max max;
                    Words words;
                    double time = System.currentTimeMillis();
                    max = new Max(SIZE,test,timeEnd);
                    min = new Min(SIZE,test,timeEnd);
                    words = new Words(SIZE,test,timeEnd);
                    max.thread.join();
                    min.thread.join();
                    words.thread.join();

                    threadTime = (System.currentTimeMillis() - time) / 1000;
                    break;
                }
                case "result":
                {
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("| Thread | | NoThread | | Relation(NoThread/Thread) |");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("| " + threadTime + " | | " + noThreadTime + " | | " + noThreadTime / threadTime + " |");
                    System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
                    break;
                }
                case "nothread":
                {
                    noThreadTime = System.currentTimeMillis();
                    f.max(test,SIZE);
                    f.min(test,SIZE);
                    f.words(test,SIZE);

                    noThreadTime = (System.currentTimeMillis() - noThreadTime) / 1000;
                    break;
                }
                case "exit":
                {
                    return;
                }
            }
        }
    }
}
