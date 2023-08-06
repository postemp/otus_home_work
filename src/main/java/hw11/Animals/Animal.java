package hw11.Animals;

public class Animal {
    String name;
    int runSpeed;
    int endurance;
    public Animal(String name,int runSpeed, int endurance){
        this.name = name;
        this.runSpeed = runSpeed;
        this.endurance = endurance;
    }

    public void info(){
        System.out.println("Животное: "+ String.valueOf( this.getClass()).replaceAll("^.*\\.","") +" имя: "+this.name+ ",  скорость бега: "+ this.runSpeed + ", выносливость: " + this.endurance);
    }

//  процедура возвращает время, затраченное на бег, и “понижает выносливость” животного.
    public float run(int distance) {
        if (distance <= 0) {
            System.out.println("Нельзя задавать отрицательные или нулевые значения");
            return -1;
        }
        if (this.endurance <=0) {
            System.out.println(this.name+" не может бежать, т.к. устал");
            return -1;
        }
        float time = (float) distance / (float) this.runSpeed;
        if ((this.endurance - distance) < 0 ) {
            System.out.println(this.name+" пробежал " + (distance - (distance - this.endurance))+ " метров и устал");
            this.endurance = 0;
            return -1;
        }
        this.endurance = this.endurance - distance;
        System.out.println(this.name+" пробежал "+ distance + " метров за " + time + " секунд");
        return time;
    }
}
