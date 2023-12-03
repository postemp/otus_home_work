package hw13.transport;

public class Vehicle  {

    private int rangeOf;

    private Terrain terrCanNotUse[];


    public int getRangeOf() {
        return this.rangeOf;
    }

    public Vehicle(int rangeOf, Terrain[] terrCanNotUse) {
        this.rangeOf = rangeOf;
        this.terrCanNotUse = terrCanNotUse;
    }



    public boolean move(int rideDistance, Terrain terrain) {
        System.out.println("Поехали по местности: " + terrain.getDescription());
        for (Terrain t : terrCanNotUse) {
            if (t.equals(terrain)) {
                System.out.println("Транспорт не ездит по местности: " + terrain.getDescription());
                return false;
            }
        }

        if (this.rangeOf <= 0) {
            System.out.println("У транспорта кончился запас хода");
            return false;
        }

        if ((this.rangeOf - rideDistance) < 0) {
            System.out.println("Проехал " + (rideDistance - (rideDistance - this.rangeOf)) + " км и запас хода кончился");
            this.rangeOf = 0;
            return false;
        }

        this.rangeOf = this.rangeOf - rideDistance;
        System.out.println("Проехал " + rideDistance + " км");
        return true;
    }
}
