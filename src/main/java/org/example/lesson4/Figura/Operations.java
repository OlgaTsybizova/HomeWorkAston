package org.example.lesson4.Figura;

public interface Operations {
    double perimetr = 0;
    double area = 0;

    default double getPerimetr() {
        return perimetr;
    }
    default double getArea() {
        return area;
    }
    default void figuraInfo(){
        System.out.printf("Периметр: %f\nПлощадь: %f\n", getPerimetr(), getArea());
    }
}