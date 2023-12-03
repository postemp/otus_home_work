package hw13.transport;

public class AllTerrainVehicle extends Vehicle implements Transport {
    public AllTerrainVehicle(int fuel) {
        super(fuel * 5, new Terrain[]{});
    }
}
