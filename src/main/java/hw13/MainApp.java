package hw13;

import hw13.transport.Car;
import hw13.transport.Man;
import hw13.transport.Terrain;

public class MainApp {
    public static void main(String[] args) {

        Car car = new Car(40);
        System.out.println("Запас хода " + car.getRangeOf() + " km");
        Man vasya = new Man("Вася", 40);
        vasya.transportInfo();

        vasya.go(20, Terrain.FOREST);


//
//        vasya.getOn(ATV);
        vasya.go(20, Terrain.FOREST);
        vasya.go(10, Terrain.FOREST);
        vasya.getOn(car);
        System.out.println(vasya.go(4000, Terrain.PLAIN));
        car.showLeftRangeOf();
        System.out.println(vasya.go(4, Terrain.PLAIN));


//        System.out.println(ATV.getTerrainDescr());
    }
}
