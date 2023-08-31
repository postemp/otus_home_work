package hw13.transport;

public interface Transport {
    boolean move(int rideDistance, Terrain terrain);
    int getRangeOf();
}
