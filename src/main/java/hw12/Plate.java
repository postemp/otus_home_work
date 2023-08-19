package hw12;

public class Plate {
    private final int maxFood;
    private int currentFood;

    public Plate(int maxFood) {
        this.maxFood = maxFood;
        this.currentFood = maxFood;
    }

    public void addFood(){
        this.currentFood = this.maxFood;
    }
    public int getFood(){
        return this.currentFood;
    }

    public boolean eat(int quantityFood) {
        if ((this.currentFood - quantityFood) >=0) {
            this.currentFood = this.currentFood - quantityFood;
            return true;
        }
        return false;
    }
}
