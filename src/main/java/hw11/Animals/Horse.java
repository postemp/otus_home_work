package hw11.Animals;

public class Horse extends Animal{
    float swimSpeed;

    public Horse(String name, int runSpeed, float swimSpeed, int endurance) {
        super(name, runSpeed, endurance);
        this.swimSpeed = swimSpeed;
    }
    public void info() {
        System.out.println("Животное: " + String.valueOf(this.getClass()).replaceAll("^.*\\.", "")
                + " имя: " + this.name + ",  скорость бега: " + this.runSpeed + ", скорость плавания: "
                + this.swimSpeed + ", выносливость: " + this.endurance);
    }

    //  процедура возвращает время, затраченное на плавание, и “понижает выносливость” животного.
    public float swim(int distance) {
        int endurMultiplier = 4;
        if (this.endurance <=0) {
            System.out.println(this.name+" не может плыть, т.к. устал");
            return -1;
        }
        float time = (float) distance /  this.swimSpeed;
        if ((this.endurance - distance * endurMultiplier) < 0 ) {
            System.out.println(this.name+" проплыл " + (distance - (distance - this.endurance / endurMultiplier)) + " метров и устал");
            this.endurance = 0;
            return -1;
        }
        this.endurance = this.endurance - distance * endurMultiplier;
        System.out.println(this.name+" проплыл "+ distance + " метров за " + time + " секунд");
        return time;
    }
}
