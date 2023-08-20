package hw13.transport;

public class AllTerrainVehicle  implements Transport {

    private int rangeOf;
    Terrain terrCanNotUse[] = new Terrain[]{};

    public Terrain[] getTerrCanNotUse(){
        return terrCanNotUse;
    }

    public AllTerrainVehicle(int rangeOf) {
        this.rangeOf = rangeOf;
    }


    public int getRangeOf(){
        return this.rangeOf;
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
