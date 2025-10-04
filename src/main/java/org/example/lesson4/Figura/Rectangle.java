
package org.example.lesson4.Figura;

public class Rectangle extends Figura implements Operations {
    private double a;
    private double b;
    public Rectangle (String colorBorder, String colorFill, double a, double b){
        super(colorBorder, colorFill);
        if((a>0)&&(b>0)){
            this.a = a;
            this.b = b;
        }
        else{System.out.println("Сторона прямоугольника не может быть отрицательным числом\n");
        }
    }
    @Override
    public double getPerimetr (){
        return 2*(a + b);
    }
    @Override
    public double getArea () {
        return a*b;
    }
    @Override
    public void figuraInfo(){
        System.out.printf("Фигура: Прямоугольник\n");
        System.out.printf("Периметр: %.2f\nПлощадь: %.2f\n", getPerimetr(), getArea());
        super.figuraColorInfo();
    }
}
