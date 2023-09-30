package hw27.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box<T extends Fruit> {

    private List<T> fruitList = new ArrayList<>();

    public Box(List<T> fruitList) {
        this.fruitList = fruitList;
    }

    public Box() {
    }

    public void fruitAdd(T fruit) {
        this.fruitList.add(fruit);
    }

    public double weight() { // sum of all fruits in the box
        if (this.fruitList.isEmpty() == true) {
            return 0;
        }
        return fruitList.size() * this.fruitList.get(0).getWeight(); //нужно получить доступ к весу конкретного фрукта
    }

    public boolean compare(Box anotherBox) {
        if (anotherBox.weight() - this.weight() < 0.0001) {
            return true;
        }
        return false;
    }

    public <T> T takeFromHere() {
        T fruit = (T) fruitList.remove(0);
        return fruit;
    }

    String showName(){
        return this.fruitList.get(0).getClass().getSimpleName();
    }

    public Fruit whatClass(){
        return this.fruitList.get(0);
    }
    public void move(Box anotherBox, int quantity) {
        System.out.println("Переносим из "+anotherBox.showName()+ " в " + this.showName());
//        System.out.println(anotherBox.showName());
//        System.out.println(this.showName());
        System.out.println("Этот класс фруктов "+ this.showName() + " является потомком "+ anotherBox.showName() +" : "+ anotherBox.whatClass().getClass());
        if (!anotherBox.showName().equals(this.showName()) ) {
            System.out.println("fruits are not equal");
            return;
        }
        for (int i = 0; i < quantity; i++) {
            try {
                fruitAdd((T) anotherBox.takeFromHere());
            } catch (IndexOutOfBoundsException e) {
//                System.out.println("Exception"+e.toString());
                System.out.println("Количество перемещенных фруктов: " + i);
                break;
            }
        }
    }

}
