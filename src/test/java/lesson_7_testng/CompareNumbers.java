package lesson_7_testng;

public class CompareNumbers {
    public String compareNum(double num1, double num2) {
        if (num1 > num2) {
            return "Первое число больше второго";
        } else if (num1 == num2) {
            return "Числа равны";
        } else {
            return "Второе число больше первого";
        }
    }
}
