package hw12;

public class Main {

    public static void main(String[] args) {
        Plate plate = new Plate(40);
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Васька", 10);
        cats[1] = new Cat("Барсик", 10);
        cats[2] = new Cat("Жирдяй", 30);
        cats[3] = new Cat("Ушастик", 10);


        System.out.println("В тарелке осталось "+plate.getFood() + " еды");
//         кормим котов
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            System.out.println("В тарелке осталось "+plate.getFood() + " еды");
        }

//        смотрим, все ли наелись?
        for (int i = 0; i < cats.length; i++) {
            if (cats[i].getFullness()) {
                System.out.println("Кот " + cats[i].getName() + " наелся");
            } else {
                System.out.println("Кот " + cats[i].getName()  + " голодный");
            }
        }

        // всем не хватило, добавляем еды
        System.out.println("Доложили еды в тарелку");
        plate.addFood();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            System.out.println("В тарелке осталось "+plate.getFood() + " еды");
        }

        for (int i = 0; i < cats.length; i++) {
            if (cats[i].getFullness()) {
                System.out.println("Кот " + cats[i].getName() + " наелся");
            } else {
                System.out.println("Кот " + cats[i].getName()  + " голодный");
            }
        }
    }
}
