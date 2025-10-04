package lesson_7_junit_5;
import java.lang.Exception.*;

public class Calculator {
    public double sum(double a, double b) {
        return a + b;
    }

    public double sub(double a, double b) {
        return a - b;
    }

    public double mult(double a, double b) {
        return a * b;
    }

    public double div(double a, double b){
        if (b == 0) {
            throw new IllegalArgumentException("Делить на ноль нельзя!");
        }
        return a / b;
    }
}
