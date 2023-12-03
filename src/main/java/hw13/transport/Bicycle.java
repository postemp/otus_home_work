package hw13.transport;

public class Bicycle implements Transport {

    private final Terrain terrCanNotUse[] = new Terrain[]{Terrain.SWAMP};

    public int getRangeOf() {
        return 1000;
    }

    public Bicycle() {
    }

    @Override
    public boolean move(int rideDistance, Terrain terrain) {
        System.out.println("Поехали по местности: " + terrain.getDescription());
        for (Terrain t : terrCanNotUse) {
            if (t.equals(terrain)) {
                System.out.println("Велосипед не ездит по местности: " + terrain.getDescription());
                return false;
            }
        }
        System.out.println("Проехали " + rideDistance + " км ");
        return true;
    }
}
