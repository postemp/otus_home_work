package hw13.transport;

public class Man {
    private Transport transport;
    int endurance; // км, которые способен пройти человек

    public Man(int endurance) {
        this.transport = null;
        this.endurance = endurance;
    }

    public boolean getOn(Transport transport){
        this.transport = transport;
        System.out.println("Сели на "  + this.transport.getClass().getSimpleName());
        return true;
    }

    public void getOff(){
        System.out.println("Вышли из "  + this.transport.getClass().getSimpleName());
        this.transport = null;
    }

    public boolean move(int distance, Terrain terrain){
        if (this.transport != null ) {
            return this.transport.move(distance, terrain);
        }
//        идет пешком, если не сели на транспорт
        if (this.endurance <= 0) {
            System.out.println("У человека кончились силы, идти дальше не может");
            return false;
        }


        if ((this.endurance - distance) < 0) {
            System.out.println("Прошел " + (distance - (distance - this.endurance)) + " км и запас хода кончился");
            this.endurance = 0;
            return false;
        }

        this.endurance = this.endurance - distance;
        System.out.println("Прошел " + distance + " км");
        return true;
    }

    public void transportInfo(){
        if (this.transport == null) {
            System.out.println("Человек не сел на транспорт, осталось сил на "+ this.endurance + " км");
            return;
        }
        System.out.println("Транспорт: " + this.transport.getClass().getSimpleName() + " запас хода на  " + this.transport.getRangeOf() + " км");
    }
}
