package hw13.transport;

import hw13.transport.Terrain;
import hw13.transport.Transport;

public class Man {
    private String name;
    private Transport transport;
    private int endurance; // км, которые способен пройти человек

    public Man(String name, Transport transport, int endurance) {
        this.name = name;
        this.transport = transport;
        this.endurance = endurance;
    }

    public Man(String name, int endurance) {
        this.name = name;
        this.transport = null;
        this.endurance = endurance;
    }

    public boolean getOn(Transport transport){
        this.transport = transport;
        System.out.println("Сели на "  + this.transport.getClass().getSimpleName());
        return true;
    }

    public void getOff(){
        System.out.println("Слезли с "  + this.transport.getClass().getSimpleName());
        this.transport = null;
    }

    public boolean go(int distance, Terrain terrain){
        if (this.transport != null ) {
            if(this.transport.go(distance, terrain)){
                return true;
            };
            return false;
        }
//        идет пешком, если не сели на транспорт
        if (this.endurance <= 0) {
            System.out.println("У человека кончились силы, идти дальше не может");
            return false;
        }
        if ((this.endurance - distance) >= 0) {
            this.endurance = this.endurance - distance;
            System.out.println("Прошли пешком " + distance + " км");
            return true;
        }
        System.out.println( "У человека не хватает выносливости, что бы пройти это расстояние в "+ distance +"км , endurance = " + this.endurance);
        return false;
    }

    public void transportInfo(){
        if (this.transport == null) {
            System.out.println("Man goes on foot, endurance = "+ this.endurance);
            return;
        }
        System.out.println("transport is " + this.transport.getClass().getSimpleName() + " range of " + this.transport.getRangeOf());
    }
}
