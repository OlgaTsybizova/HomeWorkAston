
package org.example.lesson4.Figura;

public class Triangle extends Figura implements Operations{
    // a, b, c - стороны треугольника
    private double a;
    private double b;
    private double c;

    public Triangle (String colorBorder, String colorFill, double a, double b, double c){
        super(colorBorder, colorFill);
        if (((a + b) > c) && ((a + c) > b) && ((b + c) > a)) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else {System.out.print("Неверно заданы стороны треугольника: \nCумма длин любых 2х сторон должна быть больше длины 3й стороны \n\n");}
    }
    @Override
    public double getPerimetr () {
        return (a + b + c);
    }

    @Override
    public double getArea (){
        double p = (a + b + c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    @Override
    public void figuraInfo(){
        System.out.printf("Фигура: Треугольник\n");
        System.out.printf("Периметр: %.2f\nПлощадь: %.2f\n", getPerimetr(), getArea());
        super.figuraColorInfo();
    }
}
