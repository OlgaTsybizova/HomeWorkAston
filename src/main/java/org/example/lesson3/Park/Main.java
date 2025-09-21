
package org.example.lesson3.Park;

public class Main {
    public static void main(String[] args) {
        Park park = new Park("Парк Пушкина");
        park.addAtraction("Паровозик", 500, 3);
        park.addAtraction("Солнышко", 300, 2);
        park.addAtraction("Ромашка", 350, 2);
        park.printAtractionInfo();


        // Park.Atraction karusel1 = atraction.new Atraction("Паровозик", 500, 3);
        //Park.Atraction karusel2 = atraction.new Atraction("Солнышко", 300, 2);
        //Park.Atraction karusel3 = new Park("Атракцион").new Atraction("Ромашка", 350, 2);
        //karusel2.atractionInfo();
    }
}

