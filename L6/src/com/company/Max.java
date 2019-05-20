package com.company;

public class Max implements Runnable
{
    int SIZE;
    MyContainer container;
    int max = 0;
    double time = 0;
    int timeEnd = 0;
    public Thread thread;
    public Max(int SIZE,MyContainer container,int timeEnd)
    {
        this.SIZE = SIZE;
        this.container = container;
        this.timeEnd = timeEnd;
        thread = new Thread(this,"Max");
        thread.start();
    }

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

            if(max < container.at(i).length())
            {
                max = container.at(i).length();
            }
        }
        System.out.println("MAXIMUM value = " + max);
        time = System.currentTimeMillis() - time;
    }
}
