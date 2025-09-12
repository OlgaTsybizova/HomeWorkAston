
package org.example.lesson3.Product;

public class Main {
    public static void main(String[] args){
        Product[] productArray = new Product[5];
        productArray[0] = new Product ("Refrigerator", "01.01.2025", "Haier","China", 55000, true);
        productArray[1] = new Product ("TV", "10.05.2024", "Haier","China", 35000, true);
        productArray[2] = new Product ("Oven", "15.07.2025", "Midea", "China", 30000, true);
        productArray[3] = new Product ("Washing machine", "20.08.2025", "Indesit", "Italia", 55000, false);
        productArray[4] = new Product ("Vacuum cleaner", "25.03.2025", "Sumsung", "South Korea", 25000, true);

        productArray[3].infoProduct();
    }
}
