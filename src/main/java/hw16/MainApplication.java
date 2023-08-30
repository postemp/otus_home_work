package hw16;

import hw16.phoneBook.PhoneBook;


public class MainApplication {
    public static void main(String[] args) {
        PhoneBook phoneBook1 = new PhoneBook();
        phoneBook1.add("Саша", "+234234");
        phoneBook1.add("Маша", "+7909990909");
        phoneBook1.add("Маша", "+012341234234");
        phoneBook1.add("Маша", "+7909990909");
        phoneBook1.add("Vova", "+012341234234");

        System.out.println("У Маши найдены номера: " + phoneBook1.find("Маша"));
        System.out.println("У Саши найдены номера: " + phoneBook1.find("Саша"));

//        try {
        System.out.println("У Димы найдены номера: " + phoneBook1.find("Дима"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        };
        System.out.println("Номер +012341234234 найден:  " + phoneBook1.containsPhoneNumber("+012341234234"));
        System.out.println("Номер +000 найден: " + phoneBook1.containsPhoneNumber("+000"));

    }
}