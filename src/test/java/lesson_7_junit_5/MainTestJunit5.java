package lesson_7_junit_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MainTestJunit5 {
    public Calculator calc = new Calculator();
    public Triangle triangle = new Triangle();
    public Factorial f = new Factorial();
    public CompareNumbers num = new CompareNumbers();

    //Калькулятор
    @ParameterizedTest
    @CsvSource({"2.5, 5", "10, 5"})
    public void sumTest(double a, double b){
        double actual = calc.sum(a, b);
        //System.out.println(result);
        Assertions.assertEquals((a+b), actual);
    }

    @ParameterizedTest
    @CsvSource({"2.5, 5", "10, 5"})
    public void subTest(double a, double b){
        double actual = calc.sub(a, b);
        Assertions.assertEquals((a-b), actual);
    }

    @ParameterizedTest
    @CsvSource({"2.5, 5", "15, 3"})
    public void multTest(double a, double b){
        double actual = calc.mult(a, b);
        Assertions.assertEquals((a*b), actual);
    }
    //Деление
    @ParameterizedTest
    @CsvSource({"2.5, 5", "10, 5", "15, 0"})
    public void divTest(double a, double b){
        try{
            double actual = calc.div(a, b);
            Assertions.assertEquals((a/b), actual);
        }
        catch(IllegalArgumentException e){
            System.out.println("divTest1: " + e.getMessage());
        }
    }
    /*Деление Вариант 2 (Деление разбито на два теста: отдельно проверяем деление на ноль)
    @Test
    public void divTestZero() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calc.div(10,0));
        System.out.println("divTestZero: Делить на ноль нельзя!");

    }
    @ParameterizedTest
    @CsvSource({"2.5, 0", "10, 5", "15, 3"})
    public void divTest1(double a, double b){
        Assumptions.assumeTrue(b!=0);
        double actual = calc.div(a, b);
        Assertions.assertEquals((a/b), actual);
    }*/

    //Факториал: Вариант 1 (в параметрах передается актуальное и ожидаемое значение)
    @ParameterizedTest
    @CsvSource({"5, 120","0, 1","1, 1"})
    public void factorialTest1(int n, long expected){
        long actual = f.factorial(n);
        Assertions.assertEquals(expected, actual);
    }
    @ParameterizedTest
    @CsvSource({"-5, Введите целое число >= 0"})
    public void factorialTest2(int n, String expected){
        try{
            long actual = f.factorial(n);
        }
        catch(IllegalArgumentException e){
            String actual = e.getMessage();
            Assertions.assertEquals(expected, actual);
            System.out.println("factorialTest2: " + e.getMessage());
        }
    }
    //Факториал: Вариант 2 (меняем руками n и прописываем ожидаемое значение)
    @ParameterizedTest
    @ValueSource(ints = {5})
    public void factorialTest(int a){
        try{
            int actual = f.factorial(a);
            Assertions.assertEquals(120, actual);
        }
        catch(IllegalArgumentException e){
            //Assertions.assertThrows(IllegalArgumentException.class, () -> f.factorial(a));
            System.out.println("factorialTest: " + e.getMessage());
        }
    }

    //Площадь треугольника
    @ParameterizedTest
    @CsvSource({"3,4,15,0", "-3, 4, 5, 0", "3,4,5,6"})
    public void triangleAreaTest(double a, double b, double c, double expectedArea){
        try{
            double actualArea = triangle.triangleArea(a, b, c);
            //System.out.println(result);
            Assertions.assertEquals(expectedArea, actualArea);
        }
        catch(IllegalArgumentException e){
            //Assertions.assertThrows(IllegalArgumentException.class, () ->triangle.triangleArea(a,b,c));
            System.out.println("triangleAreaTest: " + e.getMessage());
        }
    }
    //Сравнение двух чисел
    @ParameterizedTest
    @CsvSource({"25, 5, Первое число больше второго", "5, 10.5, Второе число больше первого", "18,18, Числа равны "})
    public void compareNumbersTest(double num1, double num2, String expected){
        //System.out.println(num.compareNum(a,b));
        String actual = num.compareNum(num1, num2);
        Assertions.assertEquals(expected, actual);
    }
}
