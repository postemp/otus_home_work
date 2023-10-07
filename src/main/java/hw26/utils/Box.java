package hw26.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Box<T extends Fruit> {

    private List<T> fruitList = new ArrayList<>();

    private TypeOfBox typeOfBox;

    public TypeOfBox getTypeOfBox() {
        return typeOfBox;
    }

    public Box(TypeOfBox typeOfBox) {
        this.typeOfBox = typeOfBox;
    }


    public Box(TypeOfBox typeOfBox, List<T> fruitList) {
        this.typeOfBox = typeOfBox;
        this.fruitList = fruitList;

    }

    public void add(T fruit) {
        this.fruitList.add(fruit);
    }

    public double weight() { // sum of all fruits in the box
        if (this.fruitList.isEmpty() == true) {
            return 0;
        }
        double sum = 0;
        for (Fruit fruit : fruitList) {
            sum += fruit.getWeight();
        }
        return sum;
    }

    public boolean compare(Box anotherBox) {
        return anotherBox.weight() - this.weight() < 0.0001;
    }

    public <T> T takeFromHere() {
        T fruit = (T) fruitList.remove(0);
        return fruit;
    }

    public void moveEverythingTo(Box anotherBox) {
        System.out.println("Переносим из " + this.getTypeOfBox() + " в " + anotherBox.getTypeOfBox());
        if (!Objects.equals(anotherBox.typeOfBox, TypeOfBox.MixedBox)) {
            if (!anotherBox.getTypeOfBox().equals(this.typeOfBox)) {
                System.out.println("Тип ящиков разный, пересыпать не можем");
                return;
            }
        }
        anotherBox.fruitList.addAll(this.fruitList);
        this.fruitList.clear();
    }

//    public void addToThisBox( ){
//        this.fruitList.add(<T> fruit);
//    }

    public void showType() {
        System.out.println("Тип T: " + this.fruitList.getClass().getName());
    }
}
