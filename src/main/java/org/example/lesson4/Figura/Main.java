
package org.example.lesson4.Figura;

public class Main {
    public static void main (String [] args){
        Operations figura1 = new Circle("Черный", "Белый", 3);
        Operations figura2 = new Triangle("Зеленый", "Желтый",3,4,5);
        Operations figura3 = new Rectangle("Синий", "Красный",5,8);

        figura1.figuraInfo();
        figura2.figuraInfo();
        figura3.figuraInfo();
    }
}

