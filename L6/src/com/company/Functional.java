package com.company;

import java.util.Random;

public class Functional {
    public static void max(MyContainer test,int SIZE)
    {
        int max = 0;
        Thread thread = Thread.currentThread();
        for(int i = 0;i < SIZE;i++)
        {
            try
            {
                thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if(max  < test.at(i).length())
                max = test.at(i).length();
        }
        System.out.println("MAXIMUM value = " + max);
    }

    public static void min(MyContainer test,int SIZE)
    {
        int min = 9999;
        Thread thread = Thread.currentThread();
        for(int i = 0;i < SIZE;i++)
        {
            try
            {
                thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if(min  > test.at(i).length())
                min = test.at(i).length();
        }
        System.out.println("MINIMUM value = " + min);
    }

    public static void words(MyContainer test,int SIZE)
    {
        int NumberOfWords = 0;
        Random rand = new Random();
        char letter = (char)(rand.nextInt(26) + 'a');
        Thread thread = Thread.currentThread();

        for(int i = 0;i < SIZE;i++)
        {
            try
            {
                thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if(test.at(i).startsWith(Character.toString(letter).toLowerCase()) || test.at(i).startsWith(Character.toString(letter).toUpperCase()))
            {
                NumberOfWords++;
            }
        }
        System.out.println(NumberOfWords +" words start with '" + letter + "' ");
    }

    public static void fill(MyContainer test, int SIZE)
    {
        for(int i = 0;i < SIZE;i++)
        {
            StringBuilder word = new StringBuilder();
            for(int j = 0;j < 1 + Math.random() * 100;j++)
            {
                word.append((char)(65+Math.random()*25));
            }
            test.add(word.toString());
        }
    }
}
