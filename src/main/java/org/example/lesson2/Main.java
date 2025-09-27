package org.example.lesson2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
    printThreeWords();
    checkSumSign();
    printColor();
    compareNumber();
    System.out.println(isIntervalSum(8,3));
    checkNumSignCons(35);
    System.out.println(isNumNegative(35));
    printString("Скоро в школу!",5);
    System.out.println(isLeapYear(1500));
    createArray();
    createArray100();
    arrayMultiply();
    tableArrary();
    createArrayLen(8,15);
}
    //Задание №1
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    //Задание №2
    public static void checkSumSign() {
        int a = 5;
        int b = 10;
        if ((a+b)>0) {
            System.out.println("Сумма положительная = " + (a+b));
        }
        else {
            System.out.println("Сумма отрицательная = " + (a+b));
        }
    }
    //Задание №3
    public static void printColor() {
        int value = 100;
        if (value<=0) {
            System.out.println("Красный");
        }
        else if (value>0 & value<=100) {
            System.out.println("Желтый");
        }
        else {System.out.println("Зеленый");}
    }
    //Задание №4
    public static void compareNumber() {
        int a = 10;
        int b = 4;
        if (a>b) {System.out.println(a + " > " + b);}
        else if (a<b){System.out.println(a + " < " + b);}
        else {System.out.println(a + " = " + b);}
    }
    //Задание №5
    public static boolean isIntervalSum(int a, int b) {
        int sum = a+b;
        if (sum >= 10 & sum <=20) {
            return true;
        }
        else {return false;}
    }
    //Задание №6
    public static void checkNumSignCons(int a) {
        if (a>=0){
            System.out.println(a + " - положительное число");
        }
        else {
            System.out.println(a + " - отрицательное число число");
        }
    }
    //Задание №7
    public static boolean isNumNegative(int a) {
        if (a<0) {return true;}
        else {return false;}
    }
    //Задание №8
    public static void printString(String str, int n) {
        for (int i = 1; i<=n; i++){
            System.out.println(str);
        }
    }
    //Задание №9
    public static boolean isLeapYear(int year){
        if ((year%4==0)&(year%400==0)){

            return true;
        }
        else {return false;}
    }
    //Задание %10
    public static void createArray(){
        int [] arr = {1,1,0,0,1,0,1,0,0};
        for(int i=0; i < arr.length; i++){
            if (arr[i] == 1){
                arr[i] = 0;
            }
            else{arr[i]=1;}
        }
        System.out.println(Arrays.toString(arr));
    }
    //Задание №11
    public static void createArray100() {
        int [] arr = new int[100];
        for (int i=0; i< arr.length; i++){
            arr[i] = i+1;
        }
        System.out.println(Arrays.toString(arr));
    }
    //Задание №12
    public static void arrayMultiply(){
        int [] arr = {1,5,3,2,11,4,5,2,4,8,9,1};
        for (int i=0; i<arr.length; i++){
            if(arr[i]<6){
                arr[i] = arr[i]*2;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    //Задание №13
    public static void tableArrary() {
        int [][] tab = new int[5][5];
        int i=0;
        int j=0;
        for (i=0; i < tab.length; i++){
            for (j=0; j < tab.length; j++){
                if((i==j)|((i+j)==(tab.length-1))) {
                    tab[i][j] = 1;
                    System.out.print(tab[i][j] + " ");
                }
                else {
                    tab[i][j]=0;
                    System.out.print(tab[i][j] + " ");
                }
            }
            System.out.println();
        }
        //System.out.println(Arrays.deepToString(tab));
    }
    //Задание №14
    public static int[] createArrayLen(int len, int initialValue) {
        int [] arr = new int [len];
        for (int i=0; i<len; i++){
            arr[i] = initialValue;
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
