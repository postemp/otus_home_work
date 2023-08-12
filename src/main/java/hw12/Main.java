package hw12;

public class Main {

    public static void main(String[] args) {
        Plate plate = new Plate(40);
        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Васька", 10);
        cats[1] = new Cat("Барсик", 10);
        cats[2] = new Cat("Жирдяй", 30);
        cats[3] = new Cat("Ушастик", 10);


        plate.getFood();
//         кормим котов
        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            plate.getFood();
        }

//        смотрим, все ли наелись?
        for (int i = 0; i < cats.length; i++) {
            cats[i].getFullness();
        }

        // всем не хватило, добавляем еды
        plate.addFood();

        for (int i = 0; i < cats.length; i++) {
            cats[i].eat(plate);
            plate.getFood();
        }

        for (int i = 0; i < cats.length; i++) {
            cats[i].getFullness();
        }
    }
}
