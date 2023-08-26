package hw13.transport;

public class Bicycle extends Vehicle implements Transport {

    public Bicycle(int endurance) {
        super(endurance, new Terrain[]{Terrain.SWAMP});
    }

    public boolean go(int rideDistance, Terrain terrain) {
        Man.endurance = Man.endurance - rideDistance;
        return true;
    }
}
