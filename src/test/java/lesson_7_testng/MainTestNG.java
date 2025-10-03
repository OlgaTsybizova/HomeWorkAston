package lesson_7_testng;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.Assertion.*;

public class MainTestNG {
    public Calculator calc = new Calculator();
    public Triangle triangle = new Triangle();
    public Factorial f = new Factorial();
    public CompareNumbers num = new CompareNumbers();

    //Калькулятор
    @DataProvider (name = "dataForCalculatorTest")
    public Object[][] testCalculatorData(){
        return new Object[][]{{10,5},{5,0}};
    }

    @Test (dataProvider = "dataForCalculatorTest")
    public void sumTest(double a, double b){
        double actual = calc.sum(a, b);
        Assert.assertEquals((a+b), actual);
    }
    @Test (dataProvider = "dataForCalculatorTest")
    public void subTest(double a, double b){
        double actual = calc.sub(a, b);
        Assert.assertEquals((a-b), actual);
    }
    @Test (dataProvider = "dataForCalculatorTest")
    public void multTest(double a, double b){
        double actual = calc.mult(a, b);
        Assert.assertEquals((a*b), actual);
    }
    @Test (dataProvider = "dataForCalculatorTest")
    public void divTest(double a, double b){
        try{
            double actual = calc.div(a, b);
            Assert.assertEquals((a/b), actual);
        }
        catch (IllegalArgumentException e){
            System.out.println("divTest: " + e.getMessage());
        }
    }
    //Факториал
    @DataProvider (name = "dataForFactorialTest")
    public Object[][] testFactorialData(){

        return new Object[][]{{0,1},{1,1},{5,120}};
    }

    @DataProvider (name = "dataForNegativeFactorialTest")
    public Object[][] testFactorialNegativeData(){

        return new  Object[][]{{-5, "Введите целое число >= 0"}};
    }

    @Test(dataProvider = "dataForFactorialTest")
    public void factorialTest(int n, long expected){
        int actual = f.factorial(n);
        Assert.assertEquals(expected, actual);
    }
    @Test(dataProvider = "dataForNegativeFactorialTest")
    public void factorialNegativeTest(int n, String expected){
        try{
            int actual = f.factorial(n);
            }
        catch(IllegalArgumentException e){
            String actual = e.getMessage();
            System.out.println("factorialNegativeTest: "+actual);
            Assert.assertEquals (actual, expected);
        }
    }
    //Площадь треугольника
    @DataProvider (name = "dataForTriangleTest")
    public Object[][] testTriangleData(){
        return new Object[][]{{3, 4, 5, 6},{5,5,6, 12}, {1, 2, 10, 0}, {-3, -4, 5, 0}};
    }
    @Test(dataProvider = "dataForTriangleTest")
    public void triangleAreaTest(double a, double b, double c, double expectedArea){
        try{
            double actualArea = triangle.triangleArea(a, b, c);
            Assert.assertEquals(actualArea, expectedArea);
        }
        catch (IllegalArgumentException e){
            System.out.println("triangleAreaTest: " + e.getMessage());
        }
    }
    //Сравнение двух чисел
    @DataProvider (name = "dataForCompareNumbersTest")
    public Object[][] testCompareNumbersData(){
        return new Object[][]{
                {5, 4, "Первое число больше второго"},
                {6.5, 10.5, "Второе число больше первого"},
                {15, 15, "Числа равны"}
        };
    }
    @Test(dataProvider = "dataForCompareNumbersTest")
    public void compareNumbersTest(double a, double b, String expected){
        String actual = num.compareNum(a, b);
        Assert.assertEquals(actual, expected);
    }
}
