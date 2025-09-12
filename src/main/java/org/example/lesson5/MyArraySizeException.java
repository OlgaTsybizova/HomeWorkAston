package org.example.lesson5;
public class MyArraySizeException extends Exception {
    private String info;
    MyArraySizeException (String info){
        this.info = info;
    }
    public void getInfo(){
        System.out.println(info);
    }
}