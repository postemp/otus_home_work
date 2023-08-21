package hw13.transport;

public class Car extends Vehicle  implements Transport{

    public Car(int fuel) {
        super( fuel * 10, new Terrain[]{Terrain.FOREST, Terrain.SWAMP});
    }

}
