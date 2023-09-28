package hw27;

import java.util.ArrayList;
import java.util.List;

public class Box <T extends Fruit>{

    private List<T> fruitList= new ArrayList<>();

    public Box(List<T> fruitList) {
        this.fruitList = fruitList;
    }

    public Box() {
    }

    public void fruitAdd(T fruit) {
        this.fruitList.add(fruit);
    }

    public int weight(Fruit fruit){ // sum of all fruits in the box
       return fruitList.size() * fruit.getWeight(); //нужно получить доступ к весу конкретного фрукта
    }

//    public boolean compare(Box anotherBox){
//        if (anotherBox.weight() == this.weight()) {
//            return true;
//        }
//        return false;
//    }


}
