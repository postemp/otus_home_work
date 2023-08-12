package hw12;

public class Plate {
    private int maxFood;
    private int currentFood;

    public Plate(int maxFood, int currentFood) {
        this.maxFood = maxFood;
        this.currentFood = maxFood;
    }

    public addFood(){
        this.currentFood = this.maxFood;
    }

    public int getFood(){
        return this.currentFood;
    }

    public boolean eating(int quantityFood) {
        this.currentFood = this.currentFood - quantityFood;
        if (this.currentFood >=0) {
            return true;
        }
        return false;

    }


}
