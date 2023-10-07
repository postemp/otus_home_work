package hw26;

import hw26.utils.*;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {
        Orange orange1 = new Orange();
        Box<Orange> orangeBox = new Box(TypeOfBox.OrangeBox, new ArrayList<Orange>(Arrays.asList(orange1, orange1)));

        System.out.println("Вес ящика с апельсинами = " + orangeBox.weight());

        Apple apple1 = new Apple();
        Box<Apple> appleBox1 = new Box(TypeOfBox.AppleBox, new ArrayList<>(Arrays.asList(apple1)));
        appleBox1.add(apple1);
        appleBox1.add(apple1);
        System.out.println("Вес ящика с яблоками appleBox1 = " + appleBox1.weight());
        System.out.println("Вес ящика с апельсинами orangeBox равен весу ящика с яблоками appleBox1: "+ appleBox1.compare(orangeBox));

        Box<Fruit> fruitBox = new Box<>(TypeOfBox.MixedBox);
        System.out.println("Вес ящика с фруктами fruitBox = " + fruitBox.weight());
        appleBox1.moveEverythingTo(fruitBox);
        System.out.println("Вес ящика с фруктами fruitBox = " + fruitBox.weight());

        Box<Apple> appleBox2 = new Box(TypeOfBox.AppleBox, new ArrayList<>(Arrays.asList(apple1)));
        System.out.println("Вес ящика с яблоками appleBox1 = " + appleBox1.weight());
        System.out.println("Вес ящика с  appleBox2 = " + appleBox2.weight());
        appleBox2.moveEverythingTo(appleBox1);
        System.out.println("Вес ящика с яблоками appleBox1 = " + appleBox1.weight());
        System.out.println("Вес ящика с  appleBox2 = " + appleBox2.weight());
        appleBox1.showType();
    }


}
