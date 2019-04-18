package com.company;

import java.io.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;

public class MyContainer implements Iterable<String>, Serializable {
    public String[] data = new String[0];
    private int CurrentLength = 0;

    public void add(String s) {
        data = Arrays.copyOf(data, data.length +1);
        data[data.length-1] = s;
    }

    String get(int index) {
        if (index >= CurrentLength)
            return null;
        else
            return data[index];
    }

    public String toString(){
        if (CurrentLength == 0)
            return null;
        StringBuilder result = new StringBuilder();
        result.append("[ ");
        for (int i = 0; i < CurrentLength -1; i++) {
            result.append(data[i]);
            result.append(", ");
        }
        result.append(data[CurrentLength -1]);
        result.append(" ]");
        return new String(result);
    }

    void clear() {
        for (int i = 0; i < CurrentLength; i++) {
            data[i] = null;
        }
        CurrentLength = 0;
    }

    boolean remove(String str) {
        boolean removed = false;
        int j = 0;
        if (str != null) {
            String[] buffer = new String[data.length - 1];
            for (int i = 0; i < data.length; i++) {
                if (data[i].equals(str)) {
                    removed = true;
                    continue;
                } else {
                    buffer[j] = data[i];
                    if (j != data.length - 1)
                        j++;
                    continue;
                }
            }
            data = new String[0];
            data = buffer;
        } else
            System.out.println("no such string");
        return removed;
    }

    int size() {
        return CurrentLength;
    }

    String[] toArray() {
        String[] result = new String[CurrentLength];
        System.arraycopy(data, 0, result, 0, CurrentLength);
        return result;
    }

    boolean contains(String string) {
        for (int i = 0; i < CurrentLength; i++)
            if (string.equals(data[i]))
                return true;
        return false;
    }

    boolean containsAll(MyContainer container) {
        boolean found = false;
        for (String i : container) {
            for (int j = 0; j < CurrentLength; j++) {
                if (i.equals(data[j])) {
                    found = true;
                    break;
                }
            }
            if (!found)
                return false;
            found = false;
        }
        return true;
    }

    boolean serialize(String filename) {
        FileOutputStream FOS;
        try {
            FOS = new FileOutputStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return false;
        }
        try {
            ObjectOutputStream OOS = new ObjectOutputStream(FOS);
            OOS.writeObject(this);
            OOS.flush();
            OOS.close();
            FOS.close();
            return true;
        } catch (IOException e) {
            System.out.println("Something goes wrong( IO problem )");
            return false;
        }
    }

    boolean deserialize(String filename) {
        FileInputStream FIS;
        try {
            FIS = new FileInputStream(filename);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return false;
        }
        try {
            ObjectInputStream OIS = new ObjectInputStream(FIS);
            MyContainer temp = (MyContainer) OIS.readObject();
            if (temp.CurrentLength > this.data.length) {
                System.out.println("Your container is too large");
                return false;
            }
            this.data = temp.data;
            this.CurrentLength = temp.CurrentLength;
            return true;
        } catch (IOException e) {
            System.out.println("Something goes wrong( IO problem )");
            return false;
        } catch (ClassNotFoundException e) {
            System.out.println("Your file format is wrong");
            return false;
        }
    }

    int indexOf(String s) {
        for (int i = 0; i < CurrentLength; i++) {
            if (s.equals(data[i]))
                return i;
        }
        return -1;
    }

    private int ElementCompare(int index1, int index2) {
        String str1 = data[index1];
        String str2 = data[index2];
        int length1 = str1.length();
        int length2 = str2.length();

        for (int i = 0; i < length1 && i < length2; i++) {
            int str1_ch = (int)str1.charAt(i);
            int str2_ch = (int)str2.charAt(i);
            if (str1_ch != str2_ch)
                return str1_ch - str2_ch;
        }

        if (length1 != length2) {
            return length1 - length2;
        }
        else {
            return 0;
        }
    }

    private void quicksort(String arr[], int first, int last) {
        int i = first, j = last;
        int m = (first + last) / 2;
        String swap;
        do {
            while (ElementCompare(i, m) > 0) i++;
            while (ElementCompare(j, m) < 0) j--;
            if(i <= j) {
                if (i < j) {
                    swap=arr[i];
                    arr[i]=arr[j];
                    arr[j]=swap;
                }
                i++;
                j--;
            }
        } while (i <= j);
        if (i < last)
            quicksort(arr, i, last);
        if (first < j)
            quicksort(arr, first,j);
    }

    void sort() {
        quicksort(data, 0, CurrentLength -1);
    }

    int maxSize() {
        return data.length;
    }

    @Override
    public Iterator<String> iterator() {
        return new MyIterator(data, CurrentLength);
    }
}
