package hw16.phoneBook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private static HashMap<String, ArrayList> phoneBook = new HashMap<String, ArrayList>();

    public static void add(String name, String phone) {
        if (phoneBook.containsKey(name)) {
            ArrayList<String> strTemp = new ArrayList<>();
            strTemp.addAll(phoneBook.get(name));
            strTemp.add(phone);
            phoneBook.put(name, strTemp);
            return;
        }
        phoneBook.put(name, new ArrayList<String>(Arrays.asList(phone)));
    }

    public static String find(String name) {
        if (!phoneBook.containsKey(name)) {
            return "имени \"" +name+ "\" в записной книге нет";
        }
        String strTemp = "";
        for (Object o : phoneBook.get(name)) {
            strTemp += o.toString() + "; ";
        }
        return strTemp;
    }

    public static String containsPhoneNumber(String phone) {
        String retString = "";
        for (Map.Entry<String, ArrayList> set : phoneBook.entrySet()) {
            for (Object o : set.getValue()) {
                if (o.toString().equals(phone)) {
                    retString += set.getKey() + "; ";
                }
            }
        }
        return retString;
    }
}
