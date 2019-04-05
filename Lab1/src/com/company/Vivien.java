package com.company;

import java.lang.String;

public class Vivien
{
    private static int j;
    private static boolean debug;
    public static void debug(boolean deb)
    {
        debug = deb;
    }

    public boolean isVovel(String word)
    {
        if (debug == true) System.out.println("Перевіряємо наявність голосних літер на початку слова\n");
        word = word.toLowerCase();
        char c = word.charAt(0);
        char [] chars = {'a','e','o','i','y','u'};
        if (debug == true) System.out.println("Перевіряємо кожну першу букву слова\n");
        if (debug == true) System.out.println("Якщо перша буква голосна - повертаємо 'true'\n");
        for (char a: chars)
        {
            if (a == c)
            {
                return true;
            }
        }
        return false;
    }

    public String[] Splinter(String input){
        if (debug == true) System.out.println("Розділяємо рядок на слова\n");
        int m = input.length();
        char[] num = input.toCharArray();

        j=0;
        int counter = 0;
        for(int k = 0;k<input.length();k++)
        {
            if(input.charAt(k) == ' ')
            {
                counter++;
            }
        }
        String[] now = new String[counter+1];
        for(int i = 0;i<now.length;i++)
        {
            now[i] = "";
        }
        if (debug == true) System.out.println("Якщо знаходимо пробіл - переходимо на нове слово, в іншому разі - дописуємо букву в поточне слово\n");
        for(int i = 0; i < m; i++)
        {

            if(num[i] == ' ')
            {
                j++;
            }
            else
            {
                now[j] += num[i];
            }
        }
        return now;
    }

    public String Task(String[] now,int size)
    {
        if (debug == true) System.out.println("Видаляємо слова заданої довжини, що починаються на приголосну\n");
        String[] result = new String[j+1];
        if (debug == true) System.out.println("Перевіряємо кожне слово. Якщо воно задовільняє умови - заміняємо на пробіл і переходимо в новий рядок\n");
        for (int i = 0; i < j+1; i++)
        {
            if (isVovel(now[i]) || (now[i].length() != size))
            {
                result[i] = now[i];
            }
            else
            {
                result[i] = " ";
            }
        }
        String res = new String();
        for (int i = 0; i < j+1; i++) {res += result[i]; res += ' ';}
        return res;
    }
}