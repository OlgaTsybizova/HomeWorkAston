package org.example.lesson6.Student;

public class MarksException extends Exception  {
    public String info;
    MarksException (String info){
        this.info = info;
    }
    public void getInfo(){
        System.out.println(info);
    }
}