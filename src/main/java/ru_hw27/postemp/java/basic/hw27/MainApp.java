package ru_hw27.postemp.java.basic.hw27;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainApp {

    public static void main(String[] args) {


//        Box<Orange> orangeBox = new Box(Arrays.asList(new Orange(), new Orange()));
//        Box<Orange> orangeBox = new Box(Arrays.asArrayList(new Orange(), new Orange()));
//        Box<Fruit> fruitBox = new Box();

        Apple apple1 = new Apple();
        Box<Apple> appleBox1 = new Box();
        Box<Apple> appleBox2 = new Box( new ArrayList<Apple>(Arrays.asList(apple1, apple1, apple1)) );
        appleBox1.fruitAdd(apple1);

//        System.out.println("Вес ящика с апельсинами = " + orangeBox.weight());
//        orangeBox.take_from_here(0);
//        System.out.println("Вес ящика с апельсинами = " + orangeBox.weight());

        System.out.println("Вес ящика с яблоками = " + appleBox2.weight());
        appleBox2.move(appleBox1);
        System.out.println("Вес ящика с яблоками = " + appleBox2.weight());
//        System.out.println("вес ящика с апельсинами равен весу ящика с яблоками: "+ appleBox.compare(orangeBox));

    }

}
