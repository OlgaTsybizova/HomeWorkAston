package lesson_7_testng;

public class Factorial {
    int n;
    public int factorial(int n) {
        if(n<0) {
            throw new IllegalArgumentException("Введите целое число >= 0");
        }
        else if(n==0){
            return 1;
        }
        else {
            return n*factorial(n-1);
        }
    }
}
