package hw13;

import hw13.transport.*;

public class MainApp {
    public static void main(String[] args) {

//        Car car = new Car(40);
//        System.out.println("Запас хода " + car.getRangeOf() + " km");

        Man vasya = new Man("Вася", 40);
        vasya.transportInfo();
        vasya.go(20,Terrain.SWAMP);
        vasya.transportInfo();

        Bicycle bike = new Bicycle(60);
        vasya.getOn(bike);
        vasya.go(10,Terrain.PLAIN);
        vasya.getOff();
        vasya.transportInfo();

//        Horse sivka = new Horse(200);
//        vasya.getOn(sivka);
//        vasya.transportInfo();
//        vasya.go(100,Terrain.SWAMP);


//
//        vasya.go(20, Terrain.FOREST);
//        vasya.transportInfo();
//        hw13.transport.AllTerrainVehicle ATV =new hw13.transport.AllTerrainVehicle(60);
//
//        vasya.getOn(ATV);
//        vasya.transportInfo();
//        vasya.go(20, Terrain.FOREST);
//
//        vasya.transportInfo();
//        vasya.getOn(car);
//
//        System.out.println(vasya.go(40, Terrain.PLAIN));
//        car.showLeftRangeOf();
//
//        vasya.getOff();
//        System.out.println(vasya.go(4, Terrain.PLAIN));

    }
}
