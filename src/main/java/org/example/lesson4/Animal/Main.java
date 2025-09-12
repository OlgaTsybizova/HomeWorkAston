package org.example.lesson4.Animal;

public class Main {
    public static void main(String [] args){
        Cat cat1 = new Cat("Барсик", false);
        Cat cat2 = new Cat("Пушок", false);
        Dog dog1 = new Dog("Дружок");
        Animal.animalCountInfo();
        cat1.run(250);
        cat2.run(30);
        cat1.swim(5);
        dog1.run(600);
        dog1.swim(8);
        //cat1.catInfo();
        Cat.putFoodBowl(95); // наполнить миску едой
        cat1.eatFromBowl(15); // покормить кота
        cat2.eatFromBowl(25);
        //cat1.catInfo();

        Cat [] catArray = new Cat[5];
        catArray[0] = new Cat("Мурзик", false);
        catArray[1] = new Cat("Василий", false);
        catArray[2] = new Cat("Матроскин", false);
        catArray[3] = new Cat("Коржик", false);
        catArray[4] = new Cat("Компот", false);
        Animal.animalCountInfo();
        for(int i = 0; i<catArray.length; i++){
            catArray[i].eatFromBowl(15);
        }
        System.out.println("Остаток еды в миске = " + Cat.getBowl() );
    }
}
