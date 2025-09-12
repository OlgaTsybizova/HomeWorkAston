package org.example.lesson5;
public class MyArrayDataException extends Exception  {
    private String info;
    MyArrayDataException (String info){
        this.info = info;
    }
    public void getInfo(){
        System.out.println(info);
    }
}
