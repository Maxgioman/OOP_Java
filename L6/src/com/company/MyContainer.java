package com.company;

import java.util.Iterator;

public class MyContainer implements Iterable<String>
{
    private int SIZE = 16;
    private String[] array = new String[SIZE];
    private int pointer = 0;
    public void add(String data)
    {
        if(pointer == array.length)
        {
            SIZE *= 2;
            resize();
        }

        array[pointer++] = data;
    }

    private void resize()
    {
        String[] newArray = new String[SIZE];
        for(int i = 0;i < pointer;i++)
        {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    public boolean remove(String data)
    {
        for(int i = 0;i < pointer;i++)
        {
            if(array[i] == data)
            {

                for(int j = i;j < pointer;j++)
                {
                    array[j] = array[j+1];
                }
                pointer--;
                if(pointer == SIZE/2)
                {
                    SIZE /= 2;
                    resize();
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString()
    {
        if(pointer == 0)
            return null;
        StringBuilder tmpResult = new StringBuilder();
        for(int i = 0;i < pointer;i++)
        {
            tmpResult.append(array[i]);
            tmpResult.append(' ');
        }
        return tmpResult.toString();
    }

    public String at(int index)
    {
        if(index >= pointer)
            return null;
        return array[index];
    }

    public Iterator<String> iterator()
    {
        return new MyIterator(this,pointer);
    }
}
