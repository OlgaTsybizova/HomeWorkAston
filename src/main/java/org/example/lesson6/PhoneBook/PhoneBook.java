package org.example.lesson6.PhoneBook;

import java.util.Objects;

public class PhoneBook {
    private String name;
    private String phoneNumber;
    public PhoneBook(String name, String phoneNumber){
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PhoneBook phoneBook = (PhoneBook) o;
        return Objects.equals(name, phoneBook.name) && Objects.equals(phoneNumber, phoneBook.phoneNumber);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, phoneNumber);
    }
}
