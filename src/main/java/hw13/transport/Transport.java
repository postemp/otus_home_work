package hw13.transport;

public interface Transport {
    boolean go(int rideDistance, Terrain terrain);
    int getRangeOf();
}
