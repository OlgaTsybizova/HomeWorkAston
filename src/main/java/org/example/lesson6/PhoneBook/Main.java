package org.example.lesson6.PhoneBook;

import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args){
        Set<PhoneBook> phoneBook = new HashSet<PhoneBook>();
        //phoneBook.add(new PhoneBook("Ivanov", "+79107777777"));
        addNewPeople(phoneBook, "Ivanov", "+79107777777");
        addNewPeople(phoneBook, "Ivanov", "+79107777777");
        addNewPeople(phoneBook,"Petrov", "+79108888888");
        addNewPeople(phoneBook, "Sidorov", "+79109999999");
        addNewPeople(phoneBook, "Sidorov", "+79501231233");
        System.out.println("Печатаем весь список");
        printPhoneBook(phoneBook);
        System.out.println("Поиск по фамилии");
        get(phoneBook, "Ivanov");
    }

    public static void addNewPeople(Set<PhoneBook> phoneBook, String name, String phoneNumber){
        PhoneBook st = new PhoneBook(name, phoneNumber);
        phoneBook.add(st);
    }
    public static void printPhoneBook(Set<PhoneBook> phoneBook){
        for(PhoneBook s: phoneBook){
            System.out.println("Фамилия: " + s.getName() + " Номер телефона: " + s.getPhoneNumber());
        }
    }
    public static void get(Set <PhoneBook> phoneBook, String name){
        for(PhoneBook st: phoneBook){
            if(st.getName() == name){
                System.out.println("Фамилия: " + st.getName() + " Номер телефона: " + st.getPhoneNumber());
            }
        }
    }
}
