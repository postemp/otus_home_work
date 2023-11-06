package hw16.phoneBook;

import java.util.*;

public class PhoneBook {
    private final Map<String, HashSet<String>> phoneBook = new HashMap<>();

    public PhoneBook() {
    }

    public void add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            System.out.println("записываем номер " + phone +" у " + name + " результат: " +phoneBook.get(name).add(phone));
        } else {
            phoneBook.put(name, new HashSet<>(Set.of(phone)));
        }
    }

    public Set<String> find(String name) {
//        if (!phoneBook.containsKey(name)) {
//            System.out.println("имени \"" +name+ "\" в записной книге нет");
//            throw new RuntimeException("Ошибка, имени \"" +name+ "\" в записной книге нет");
//        }
        return phoneBook.get(name);
    }

    public boolean containsPhoneNumber(String phone) {
        for (Map.Entry<String, HashSet<String>> set1 : phoneBook.entrySet()) {
            for (Object o : set1.getValue()) {
                if (o.toString().equals(phone)) {
                    return true;
                }
            }
        }
        return false;
    }
}
