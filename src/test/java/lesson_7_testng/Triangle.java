package lesson_7_testng;

public class Triangle {
    public double triangleArea(double a, double b, double c){
        if((a<=0)||(b<=0)||(c<=0)){
            throw new IllegalArgumentException("Сторона треугольника должна быть положительным числом");
        }
        if((a+b)<=c || (a+c)<=b || (b+c)<=a) {
            throw new IllegalArgumentException("Сумма длин двух сторон треугольника не может быть меньше или равна длине третьей стороны");
        }
        else{
            double p = (a + b + c)/2;
            return (Math.sqrt(p * (p - a)*(p - b)*(p - c)));
        }
    }
}
