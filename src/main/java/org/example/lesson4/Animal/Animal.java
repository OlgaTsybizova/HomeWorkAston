package org.example.lesson4.Animal;

public class Animal {
    private String name;
    private static int countAnimal = 0; //счетчик животных
    public Animal(String name){
        this.name = name;
        countAnimal ++;
    }
    public String getName() {
        return name;
    }
    public void run(int length){
        if(length>=0){
            System.out.println(name + " пробежал " + length + " м");
        }
        else {System.out.println("Неверно задана длина дистанции");}
    }
    public void swim(int length){
        if(length>=0){
            System.out.println(name + " проплыл " + length + " м");
        }
        else {System.out.println("Неверно задана длина дистанции");}
    }
    public static void animalCountInfo(){
        System.out.printf("Итого: всего животных = %d, котов = %d, собак = %d\n",countAnimal, Cat.getCountCat(), Dog.getCountDog());
    }
}