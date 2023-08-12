package hw11;
import hw11.animals.Cat;
import hw11.animals.Dog;
import hw11.animals.Horse;

public class Hw11 {
    public static void main(String[] args) {
        Horse horse = new Horse("Сивка", 5, 0.5f, 4000);
        horse.info();
        horse.run(2000);
        horse.info();
        System.out.println(horse.swim(1000));
        horse.info();
        horse.run(0);

        Cat cat = new Cat("Персик",3, 200);
        cat.run(250);
        cat.info();
        cat.swim(10);
        Dog dog = new Dog("Бобик", 3, 0.1f, 300);
        dog.info();
        System.out.println(dog.run(300));
        System.out.println(dog.swim(100));
        dog.info();
    }
}
