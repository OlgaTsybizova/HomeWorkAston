package org.example.lesson6.PhoneBook;

import java.util.HashMap;
import java.util.Map;


public class PhoneBook {
    private Map <String, String> phoneBook = new HashMap<String, String>();

    //Добавляем новый контакт
    public void add(String phoneNumber , String name){
        phoneBook.put(phoneNumber,name);
    }

    //Печатаем весь справочник
    public void printPhoneBook(){
        for(Map.Entry<String, String> s : phoneBook.entrySet()){
            System.out.println("Номер телефона: " + s.getKey()+ " Фамиллия: "+ s.getValue());
        }
    }
    //Поиск по фамиилии
    public void get(String name){
        for(Map.Entry<String, String> s : phoneBook.entrySet()){
            if(s.getValue().equals(name)) {
                System.out.println("Номер телефона: " + s.getKey() + " Фамиллия: " + s.getValue());
            }
        }
    }

    public Map<String, String> getPhoneBook() {
        return phoneBook;
    }
}
