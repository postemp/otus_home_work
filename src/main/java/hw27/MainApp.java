package hw27;

import hw27.utils.Apple;
import hw27.utils.Box;
import hw27.utils.Fruit;
import hw27.utils.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {


        Orange orange1 = new Orange();
        Box<Orange> orangeBox = new Box(new ArrayList<Orange>(Arrays.asList(orange1, orange1)));

        System.out.println("Вес ящика с апельсинами = " + orangeBox.weight());
//
        Apple apple1 = new Apple();
        Box<Apple> appleBox1 = new Box();
        appleBox1.fruitAdd(apple1);
        Box<Apple> appleBox2 = new Box(new ArrayList<Apple>(Arrays.asList(apple1, apple1, apple1)));

        System.out.println("вес ящика с апельсинами orangeBox равен весу ящика с яблоками appleBox2: "+ appleBox2.compare(orangeBox));

        System.out.println("Вес ящика с яблоками appleBox2 = " + appleBox2.weight());
        appleBox2.move(appleBox1, 5);
        System.out.println("Вес ящика с яблоками appleBox2 = " + appleBox2.weight());

        appleBox2.move(orangeBox, 2);

        Box<Fruit> fruitBox = new Box();
    }


}
