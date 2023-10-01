package hw27.utils;

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
    public void fruitAdd(T fruit) {
        this.fruitList.add(fruit);
    }

    public double weight() { // sum of all fruits in the box
        if (this.fruitList.isEmpty() == true) {
            return 0;
        }
        double sum = 0;
        for (Fruit  fruit :  fruitList) {
            sum += fruit.getWeight();
        }
        return sum;
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
        System.out.println("Переносим из "+anotherBox.getTypeOfBox()+ " в " + this.getTypeOfBox());
         if (!Objects.equals(this.typeOfBox,TypeOfBox.MixedBox)) {
            if (!anotherBox.getTypeOfBox().equals(this.typeOfBox)) {
                System.out.println("Тип ящиков разный, пересыпать не можем");
                return;
            }
        }

        for (int i = 0; i < quantity; i++) {
            try {
                fruitAdd((T) anotherBox.takeFromHere());
            } catch (IndexOutOfBoundsException e) {
//                System.out.println("Exception"+e.toString());
                System.out.println("Количество пересыпанных фруктов: " + i);
                break;
            }
        }
    }

}
