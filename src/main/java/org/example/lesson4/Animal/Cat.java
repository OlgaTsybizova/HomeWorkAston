package org.example.lesson4.Animal;

public class Cat extends Animal {
    private boolean fullness; //сытость thrue - сытый, false - голодный
    private static int countCat = 0; //счетчик котов
    private static int bowl = 0; // миска для еды
    public Cat (String name, boolean fullness){
        super(name);
        this.fullness = fullness;
        countCat ++;
    }

    public static int getCountCat() {
        return countCat;
    }

    public static int getBowl() {
        return bowl;
    }

    public void catInfo(){
        if (fullness == false){
            System.out.println("Имя кота: " + super.getName() + ", кот голодный.");
        }
        else {System.out.println("Имя кота: " + super.getName() + ", кот сытый.");}
    }
    @Override
    public void run(int length){
        if (length>200){
            System.out.println("Кот не может пробежать больше 200 метров");
        }
        else {
            super.run(length);
        }
    }
    @Override
    public void swim (int length){
        System.out.println("Коты не умеют плавать");
    }
    //
    public void eatFromBowl (int nymnym){
        if(nymnym<=bowl){
            bowl=bowl-nymnym;
            fullness = true;
            System.out.println("Кот " + super.getName() + "  сытый");
        }
        else{
            System.out.println("Положите в миску еду. Кот "+ super.getName() + " голодный");
        }
    }
    public static void putFoodBowl(int food){
        bowl = bowl + food;
    }
}
