package org.example.lesson6.PhoneBook;

import java.util.Map;
import java.util.HashMap;


public class Main {
    public static void main(String[] args){
        PhoneBook contacts = new PhoneBook();
        contacts.add("123123", "Ivanov");
        contacts.add("123321", "Sidorov");
        contacts.add("123123", "Ivanov");
        contacts.add("123456", "Petrov");
        contacts.add("789123", "Ivanov");
        System.out.println("Телефонный справочник");
        contacts.printPhoneBook();
        System.out.println("Поиск по фамилии:");
        contacts.get("Ivanov");



    }
}
