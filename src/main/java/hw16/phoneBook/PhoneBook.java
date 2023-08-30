package hw16.phoneBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private final Map<String, ArrayList<String>> phoneBook = new HashMap<>();

    public PhoneBook() {
    }

    public void add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            if (phoneBook.get(name).contains(phone)) {
                System.out.println("Такой номер у " + name + " уже записан");
                return;
            }
            phoneBook.get(name).add(phone);
        } else {
            phoneBook.put(name, new ArrayList<>(List.of(phone)));
        }
    }

    public List<String> find(String name) {
//        if (!phoneBook.containsKey(name)) {
//            System.out.println("имени \"" +name+ "\" в записной книге нет");
//            throw new RuntimeException("Ошибка, имени \"" +name+ "\" в записной книге нет");
//        }
        return phoneBook.get(name);
    }

    public boolean containsPhoneNumber(String phone) {
        for (Map.Entry<String, ArrayList<String>> set : phoneBook.entrySet()) {
            for (Object o : set.getValue()) {
                if (o.toString().equals(phone)) {
                    return true;
                }
            }
        }
        return false;
    }
}
