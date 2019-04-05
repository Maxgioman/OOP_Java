package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = null;
        String output = null;
        String command;
        int potentialDelete = 0;
        boolean debug = false;

        System.out.println("Вас вітає програма 7 варіанту\nВиконав Пулик Максим, студент групи КН-108 \n" +
                "Призначення: видалення з рядка слів заданої довжини, що починаються на приголосну \n");

        if (args != null && args.length == 1)
        {
            if (args[0].equals("-h"))
            {
                System.out.println("Команди для використання:\n" +
                        " a: введення даних\n" +
                        " b: перегляд даних\n" +
                        " c: виконанння обчислень\n" +
                        " d: відображення результату\n" +
                        " e: завершення програми\n");
            }
        }

        do{
            System.out.println("Введіть команду: \t");

            command = in.nextLine();

            if(command.equals("-d"))
            {
                debug = true;
                Vivien.debug(debug);
            }

            if(command.equals("a"))
            {
                System.out.print("Введіть вхідні дані [текст <Enter>, довжина слів для видалення<Enter>]: \n");
                input = in.nextLine();
                potentialDelete = in.nextInt();
            }

            if(command.equals("b")){
                if(input != null){
                    System.out.println(input + "\n" + potentialDelete);
                }
                else{
                    System.out.println("Відсутні вхідні дані");
                }
            }

            if(command.equals("c"))
            {
                if(input != null){
                    Vivien Splin = new Vivien();
                    String[] sp = Splin.Splinter(input);
                    output = Splin.Task(sp,potentialDelete);
                    System.out.println("Дії над вхідними даними виконано. Введіть 'd' щоб побачити результат");
                }
                else{
                    System.out.println("Відсутні вхідні дані");
                }
            }

            if(command.equals("d"))
            {
                if(output != null)
                {
                    System.out.println("Результат: ");
                    System.out.println(input);
                    System.out.println(output);
                    input = null;
                    output = null;
                }
                else
                {
                    System.out.println("Відсутні вихідні дані");
                }
            }
        }while (!command.equals("e"));

        System.exit(0);
    }
}