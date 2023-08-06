package hw10;

import hw10.User.User;
import hw10.Box.Box;

public class MainApplication {
    public static void main(String[] args) {
        User[] users = {
                new User("Баровиков","Максим","Геннадьевич",2022,"borovikov@gmail.com"),
                new User("Пупкин","Ивам","Геннадьевич",1940,"ov@gmail.com"),
                new User("Баров","Иван","Геннадьевич",1980,"borovikov@gmail.com"),
                new User("Якушев","Сергей","Геннадьевич",2000,"borovikov@gmail.com"),
                new User("Маховикова","Ольга","Валерьевна",1968,"borovikov@gmail.com"),
        };
        for (int i = 0; i < users.length; i++) {
            if (users[i].getBirthyear() < (2023 - 40)) {
                users[i].showUser();
            }
        }

        Box small = new Box(10,20,30, "White");
        small.info();
        small.removeItem();
        small.addItem("кубик");
        small.open();
        small.addItem("кубик");
        small.setColor("Blue");
        small.info();
        small.close();
        small.removeItem();
        small.info();

    }
}
