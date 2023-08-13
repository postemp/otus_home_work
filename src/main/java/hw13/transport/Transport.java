package hw13.transport;

public interface Transport {
    public abstract  boolean go(int rideDistance, Terrain terrain);
    int getRangeOf();
}
