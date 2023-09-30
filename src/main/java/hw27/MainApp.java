package hw27;

import hw27.utils.Apple;
import hw27.utils.Box;
import hw27.utils.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {

    public static void main(String[] args) {

        Box<Orange> orangeBox = new Box(new ArrayList<Orange>(Arrays.asList(new Orange(), new Orange())));
        System.out.println(orangeBox.showName());

        orangeBox.fruitAdd(new Orange());
        System.out.println("Вес ящика с апельсинами = " + orangeBox.weight());

        Box<Apple> appleBox1 = new Box();
        Box<Apple> appleBox2 = new Box( new ArrayList<Apple>(Arrays.asList(new Apple(), new Apple(), new Apple())) );
        appleBox1.fruitAdd(new Apple());

//                Box<Fruit> fruitBox = new Box();



        System.out.println("Вес ящика с яблоками = " + appleBox2.weight());
        appleBox2.move(appleBox1, 5);
        System.out.println("Вес ящика с яблоками = " + appleBox2.weight());
//        System.out.println("вес ящика с апельсинами равен весу ящика с яблоками: "+ appleBox.compare(orangeBox));
        appleBox2.move(orangeBox, 5);

    }




}
