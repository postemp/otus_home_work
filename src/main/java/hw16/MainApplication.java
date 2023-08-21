package hw16;

import hw16.phoneBook.PhoneBook;

public class MainApplication {
    public static void main(String[] args) {
        PhoneBook.add("Саша", "+234234");
        PhoneBook.add("Маша", "+7909990909");
        PhoneBook.add("Маша", "+012341234234");
        PhoneBook.add("Vova", "+012341234234");
        System.out.println("У Маши найдены номера: " + PhoneBook.find("Маша"));
        System.out.println("У Саши найдены номера: "+ PhoneBook.find("Саша"));
        System.out.println("У Димы найдены номера: "+ PhoneBook.find("Дима"));
        System.out.println("Номер +012341234234 найден у: " + PhoneBook.containsPhoneNumber("+012341234234"));
        System.out.println("Номер +000 найден у: " + PhoneBook.containsPhoneNumber("+000"));
    }
}