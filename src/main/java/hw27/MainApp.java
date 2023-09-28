package hw27;

import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
//        Box<Orange> orangeBox = new Box(Arrays.asList(new Orange(), new Orange(), new Orange()));
//        Box<Fruit> fruitBox = new Box();

        Apple apple1 = new Apple();
        Apple apple2 = new Apple();
        Apple apple3 = new Apple();

        Box<Apple> appleBox = new Box<>(Arrays.asList(apple3, apple2));
//        Box<Apple> appleBox = new Box();

        appleBox.fruitAdd(apple1);


        System.out.println("Вес ящика с яблоками = " + appleBox.weight(apple1));

//        System.out.println("Cравниваем вес ящика с яблоками и апельсинами -"+appleBox.compare(orangeBox));

    }

}
