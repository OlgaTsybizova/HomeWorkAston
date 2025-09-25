package org.example.lesson5;
import java.util.Arrays;

public class Main {
    public static void main (String [] args){
        System.out.println("Задание 1, 2, 3:");
        String [][] myArray = {{"a","2","3","4"},{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4"}};
        try{
            sumMyArray(myArray);
        }
        catch(MyArraySizeException e){
            e.getInfo();
        }
        catch(MyArrayDataException e){
            e.getInfo();
        }
        System.out.println("Задание 4:");

        String[] newArray = new String [10];
        try{
            for (int i = 0; i<=newArray.length; i++){
                newArray[i] = "a"+i;
            }
        }
        catch(ArrayIndexOutOfBoundsException e){
            System.out.println(Arrays.toString(newArray));
            System.out.println("Выход за границу массива");
        }

    }

    public static void sumMyArray(String [][] myArray) throws MyArraySizeException, MyArrayDataException {
        for (int i = 0; i < myArray.length; i++) {
            if ((myArray.length != 4) || (myArray[i].length != 4)) {
                throw new MyArraySizeException("Количество строк и столбцов в массиве должно быть равно 4");
            }
        }
        int intMyArray[][] = new int[myArray.length][myArray[0].length];
        int result = 0;
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                try {
                    intMyArray[i][j] = Integer.parseInt(myArray[i][j]);
                    result = result + intMyArray[i][j];
                } catch (NumberFormatException e) {
                    {
                        throw new MyArrayDataException("Неверный формат данных в ячейке " + i + j);
                    }
                }
            }
        }
        System.out.println("Сумма всех элементов массива = " + result);

    }

}
