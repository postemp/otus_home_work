package hw11.animals;

public class Animal {
    String name;
    int runSpeed;
    int endurance;
    float swimSpeed;
    int swimEndurMultiplier;

    public Animal(String name, int runSpeed, int endurance) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.endurance = endurance;
    }

    public Animal(String name, int runSpeed, float swimSpeed, int endurance, int swimEndurMultiplier) {
        this.name = name;
        this.runSpeed = runSpeed;
        this.endurance = endurance;
        this.swimSpeed = swimSpeed;
        this.swimEndurMultiplier = swimEndurMultiplier;
    }

    public void info() {
        System.out.println("Животное: " + String.valueOf(this.getClass()).replaceAll("^.*\\.", "") + " имя: " + this.name + ",  скорость бега: " + this.runSpeed + ", скорость плавания: " + this.swimSpeed + ", выносливость: " + this.endurance);
    }

    //  процедура возвращает время, затраченное на бег, и “понижает выносливость” животного.
    public float run(int distance) {
        if (distance <= 0) {
            System.out.println("Нельзя задавать отрицательные или нулевые значения");
            return -1;
        }
        if (this.endurance <= 0) {
            System.out.println(this.name + " не может бежать, т.к. устал");
            return -1;
        }
        float time = (float) distance / (float) this.runSpeed;
        if ((this.endurance - distance) < 0) {
            System.out.println(this.name + " пробежал " + (distance - (distance - this.endurance)) + " метров и устал");
            this.endurance = 0;
            return -1;
        }
        this.endurance = this.endurance - distance;
        System.out.println(this.name + " пробежал " + distance + " метров за " + time + " секунд");
        return time;
    }

    //  процедура возвращает время, затраченное на плавание, и “понижает выносливость” животного.
    public float swim(int distance) {
        System.out.println("endurMultiplier = "+ this.swimEndurMultiplier);
        if (this.swimEndurMultiplier <= 0) {
            System.out.println(this.getClass().getSimpleName()+ " плавать не умеет");
            return -1;
        }

        if (distance <= 0) {
            System.out.println("Нельзя задавать отрицательные или нулевые значения");
            return -1;
        }
        if (this.endurance <= 0) {
            System.out.println(this.name + " не может плыть, т.к. устал");
            return -1;
        }
        float time = (float) distance / this.swimSpeed;
        if ((this.endurance - distance * swimEndurMultiplier) < 0) {
            System.out.println(this.name + " проплыл " + (distance - (distance - this.endurance / swimEndurMultiplier)) + " метров и устал");
            this.endurance = 0;
            return -1;
        }
        this.endurance = this.endurance - distance * swimEndurMultiplier;
        System.out.println(this.name + " проплыл " + distance + " метров за " + time + " секунд");
        return time;
    }
}
