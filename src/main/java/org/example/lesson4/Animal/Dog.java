package org.example.lesson4.Animal;

public class Dog extends Animal {
    private static int countDog = 0; //счетчик собак
    public Dog (String name){
        super(name);
        countDog++;
    }

    public static int getCountDog() {
        return countDog;
    }

    @Override
    public void run(int length){
        if (length>500){
            System.out.println("Собака не может пробежать больше 500 метров");
        }
        else{
            super.run(length);
        }
    }
    @Override
    public void swim (int length){
        if (length>10){
            System.out.println("Собака не может проплыть больше 10 метров");
        }
        else {
            super.swim(length);
        }
    }
}