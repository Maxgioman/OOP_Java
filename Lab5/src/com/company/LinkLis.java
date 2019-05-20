package com.company;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkLis<T> implements Iterable<T>,Serializable
{
    private static final long serialVersionUID = 1L;

    private Node<T> head;
    public int size;
    Bureau bureau = new Bureau();

    public LinkLis()
    {

    }

    public LinkLis(T data)
    {
        head = new Node<T>(data);
        size = 0;
    }

    public Node<T> gethead()
    {
        return head;
    }
    public int getsize()
    {
        return size;
    }
    public void setnode(Node<T> head)
    {
        this.head = head;
    }
    public void setsize(int size)
    {
        this.size = size;
    }

    public void addFirst(T data)
    {
        size++;
        if(head == null)
        {
            head = new Node<T>(data);
            return;
        }
        Node<T> tmp = new Node<T>(data);
        tmp.setNext(head);
        head = tmp;
    }

    public void add(T data)
    {
        size++;
        Node<T> tmp = new Node<T>(data);
        if(head == null)
        {
            head = tmp;
            return;
        }
        Node<T> current = head;
        while(current.getNext()!= null)
        {
            current = current.getNext();
        }
        current.setNext(tmp);
    }

    public void clear()
    {
        head = null;
        size = 0;
    }

    public T[] toArray()
    {
        T[] arr = (T[]) new Object[size];
        int count = 0;
        Node<T> current = head;
        while(current != null)
        {
            arr[count++] = current.getData();
            current = current.getNext();
        }
        return arr;
    }

    public String toString()
    {
        StringBuilder res = new StringBuilder();
        Node<T> current = head;
        while(current != null)
        {
            res.append(current.getData().toString());
            res.append(" ");
            current = current.getNext();
        }
        return res.toString();
    }

    public boolean isClear()
    {
        return head == null;
    }

    public T getElement(int index)
    {
        if(head == null || index >= size || index < 0)
            return null;
        Node<T> current = head;
        int count = 0;
        while(current != null && count++ < index)
        {
            current = current.getNext();
        }
        if(current == null)
            return null;
        return current.getData();
    }

    public boolean remove(int index)
    {
        if(index >= size || index < 0)
            return false;
        Node<T> current = head;
        int count = 0;
        while(count < index-1)
        {
            current = current.getNext();
            count++;
        }
        if(current == null)
            return false;
        if(index == 0)
        {
            head = current.getNext();
            size--;
            return true;
        }
        current.setNext(current.getNext().getNext());
        size--;
        return true;
    }

    public void WriteXML(String filename, LinkLis list, int i){
        try(XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename))))
        {
            encoder.writeObject(list.getElement(i));
            System.out.println("Serialize successful");
        }
        catch (FileNotFoundException e){
            System.out.println("Your file does not exist");
        }
    }

    public void ReadXML(String filename){
        try(XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))){
            Bureau object = (Bureau) decoder.readObject();
            bureau = object;
            System.out.print(bureau.getSex() + "\n" + bureau.getDate() + "\n" + bureau.getNumber() + "\n"
                    + bureau.information.getName() + "\n" + bureau.information.getHeight() + "\n"
                    + bureau.information.getEyecolor() + "\n" + bureau.information.getDateofbirth() + "\n");
            for (String a : bureau.information.getHobby())
                System.out.println(a + "\n");
            for (String i : bureau.getRequirement()){
                System.out.println(i + "\n");
            }

        }catch (FileNotFoundException e){
            System.out.println("Your file does not exist");
        }
    }

    public void Write(String filename, LinkLis list, int i)
    {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(list.getElement(i));
            oos.flush();
        }catch (IOException e){
            System.out.println("can not write a file");
        }
    }

    public void Read(String filename)
    {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))){
            bureau = (Bureau) ois.readObject();
            System.out.print(bureau.getSex() + "\n" + bureau.getDate() + "\n" + bureau.getDate() + "\n" + bureau.getInfo() + "\n" + bureau.getRequirement() + "\n");
            for (String i : bureau.getRequirement()){
                System.out.println(i + "\n");
            }
        } catch (IOException e){
            System.out.println("Error");
        } catch (ClassNotFoundException e){
            System.out.println("Error");
        }
    }

    @Override
    public Iterator iterator() {
        return new Iterator()
        {
            int count = 0;
            @Override
            public boolean hasNext() {
                return count < size;
            }

            @Override
            public Object next() {
                if(!hasNext())
                {
                    throw new NoSuchElementException();
                }
                return getElement(count++);
            }

        };
    }
}

