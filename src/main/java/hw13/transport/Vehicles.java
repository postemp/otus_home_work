package hw13.transport;

import hw13.transport.Terrain;
public class Vehicles implements Transport {
    private int rangeOf;
    private int fuel;


    public int getRangeOf(){
        return this.rangeOf;
    }
    public Vehicles(int rangeOf) {
        this.rangeOf = rangeOf;
    }

    public boolean go(int rideDistance, Terrain terrain) {
        System.out.println("Terrain = " + terrain);


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
