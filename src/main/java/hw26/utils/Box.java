package hw26.utils;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {


    public List<T> fruitList = new ArrayList<>();


    public Box() {
    }


    public Box(List<T> fruitList) {
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
        if (anotherBox == null) {
            System.out.println("Ошибка, вы вставили null");
            return false;
        }
         return Math.abs(anotherBox.weight() - this.weight()) < 0.0001;
    }

    public void moveAllTo(Box<? super T> anotherBox) {
        if (anotherBox == this || anotherBox == null) {
            System.out.println("Ошибка, проверьте введенные аргументы");
            return;
        }
        System.out.println("Переносим из ящика в ящик");
        anotherBox.fruitList.addAll(this.fruitList);
        this.fruitList.clear();
    }

}
