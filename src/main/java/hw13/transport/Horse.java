package hw13.transport;

public class Horse extends Vehicle implements Transport {
    public Horse(int endurance) {
        super(endurance, new Terrain[]{Terrain.SWAMP});
    }
}
