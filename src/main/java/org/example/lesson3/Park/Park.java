package org.example.lesson3.Park;

public class Park {
    private String parkName; //Название парка
    Atraction [] atr = new Atraction[10]; //Массив объектов класса Atraction
    Park (String parkName){
        this.parkName = parkName;
        this.atr = atr;
    }
    //Добавить атракцион
    private int i = 0;
    public void addAtraction(String atractionName, int atractionPrice, int atractionTimeMinute){
        atr[i] = new Atraction(atractionName, atractionPrice, atractionTimeMinute);
        i++;
    }
    //Вывести список всех атракционов
    public void printAtractionInfo(){
        int i = 0;
        System.out.println("Список всех атракционов:");
        while(atr[i]!=null){
            System.out.printf("Название: %s Цена: %d руб Продолжительность: %d мин.\n", atr[i].getAtractionName(), atr[i].getAtractionPrice(), atr[i].getAtractionTimeMinute());
            i++;
        }
    }

    private class Atraction {
        private String atractionName;
        private final int atractionPrice;
        private int atractionTimeMinute;

        Atraction (String atractionName, int atractionPrice, int atractionTimeMinute){
            this.atractionName = atractionName;
            this.atractionPrice = atractionPrice;
            this.atractionTimeMinute = atractionTimeMinute;
        }

        public String getAtractionName() {
            return atractionName;
        }

        public int getAtractionPrice() {
            return atractionPrice;
        }

        public int getAtractionTimeMinute() {
            return atractionTimeMinute;
        }
    }
}
