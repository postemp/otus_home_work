package hw13;

import hw13.transport.*;

public class MainApp {
    public static void main(String[] args) {

        Man vasya = new Man( 40);
        vasya.transportInfo();
        vasya.move(60,Terrain.SWAMP);
        vasya.move(10,Terrain.SWAMP);
        vasya.transportInfo();

        Bicycle bike = new Bicycle();
        vasya.getOn(bike);
        vasya.move(10,Terrain.PLAIN);
        System.out.println(vasya.move(100,Terrain.SWAMP));
        vasya.transportInfo();

        Horse sivka = new Horse(200);
        vasya.getOn(sivka);
        vasya.transportInfo();
        System.out.println(vasya.move(100,Terrain.SWAMP));
        System.out.println(vasya.move(20, Terrain.FOREST));
        vasya.transportInfo();

        AllTerrainVehicle ATV =new AllTerrainVehicle(60);
        vasya.getOn(ATV);
        vasya.transportInfo();
        vasya.move(20, Terrain.SWAMP);
        vasya.transportInfo();
        vasya.move(280, Terrain.SWAMP);
        vasya.transportInfo();
        vasya.move(20, Terrain.SWAMP);
        vasya.transportInfo();
        vasya.getOff();

        Car car = new Car(50);
        vasya.getOn(car);
        vasya.transportInfo();
        System.out.println(vasya.move(40, Terrain.PLAIN));
        vasya.transportInfo();
    }
}
