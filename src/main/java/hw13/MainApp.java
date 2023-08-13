package hw13;

import hw13.transport.AllTerrainVehicle;
import hw13.transport.Man;
import hw13.transport.Terrain;

public class MainApp {
    public static void main(String[] args) {
        AllTerrainVehicle ATV = new AllTerrainVehicle(30);
        Man vasya = new Man("Вася", 40);
//        ATV.go(5, Terrain.PLAIN);
        vasya.transportInfo();

        vasya.go(20, Terrain.FOREST);

        vasya.getOn(ATV);
        vasya.go(20, Terrain.FOREST);

//        System.out.println(ATV.getTerrainDescr());
    }
}
