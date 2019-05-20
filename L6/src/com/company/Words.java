package com.company;

import java.util.Random;

public class Words implements Runnable
{
    int SIZE;
    MyContainer container;
    int timeEnd;
    double time;
    int NumberOfWords = 0;
    Random rand = new Random();
    char letter = (char)(rand.nextInt(26) + 'a');
    Thread thread;
    public Words(int SIZE,MyContainer container,int timeEnd)
    {
        this.SIZE = SIZE;
        this.container = container;
        this.timeEnd = timeEnd;
        thread = new Thread(this,"Words");
        thread.start();
    }

    @Override
    public void run()
    {
        time = System.currentTimeMillis();
        for(int i = 0;i < SIZE;i++)
        {
            if(System.currentTimeMillis() - time > timeEnd){
                thread.interrupt();
                System.out.println("Time limit was passed");
            }
            try
            {
                thread.sleep(500);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            if(container.at(i).startsWith(Character.toString(letter)))
            {
                NumberOfWords++;
            }
        }
        System.out.println(NumberOfWords +" words start with '" + letter + "' ");
        time = System.currentTimeMillis() - time;
    }
}