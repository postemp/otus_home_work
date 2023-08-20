package hw13.transport;

public class Car implements Transport {

    private int rangeOf;

    Terrain terrCanNotUse[] = new Terrain[]{Terrain.FOREST, Terrain.SWAMP};

    public Terrain[] getTerrCanNotUse() {
        return terrCanNotUse;
    }

    public Car(int fuel) {
        this.rangeOf = fuel * 100;

    }

    public int getRangeOf() {
        return this.rangeOf;
    }

    public void showLeftRangeOf(){
        System.out.println("Оставшийся запас хода y "+this.getClass().getSimpleName() + ": " + this.rangeOf + " km");
    }


    public boolean go(int rideDistance, Terrain terrain) {
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
            System.out.println("Проехал " + (rideDistance - (rideDistance - this.rangeOf)) + " км и бензин кончился");
            this.rangeOf = 0;
            return false;
        }

        this.rangeOf = this.rangeOf - rideDistance;
        System.out.println("Проехал " + rideDistance + " км");
        return true;
    }

}
