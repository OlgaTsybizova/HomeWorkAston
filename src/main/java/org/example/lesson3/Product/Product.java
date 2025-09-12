
package org.example.lesson3.Product;

public class Product {
    public String productName;
    public String releaseDate;
    public String companyName;
    public String country;
    public double prise;
    public boolean reservStatus;
    public Product(String productName, String releaseDate, String companyName, String country, double prise, boolean reservStatus) {
        this.productName = productName;
        this.releaseDate = releaseDate;
        this.companyName = companyName;
        this.country = country;
        this.prise = prise;
        this.reservStatus = reservStatus;
    }
    public void infoProduct() {
        System.out.println("Наименование: " + productName);
        System.out.println("Дата выпуска: " + releaseDate);
        System.out.println("Наименование: " + companyName);
        System.out.println("Страна происхождения: " + country);
        System.out.println("Цена: " + prise);
        System.out.println("Состояние бронирования: " + reservStatus);
    }
}
