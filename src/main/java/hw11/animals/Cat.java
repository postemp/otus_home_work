package hw11.animals;

public class Cat extends Animal {
    public Cat(String name, int runSpeed, int endurance) {
        super(name, runSpeed, endurance);
    }

    @Override
    public void info() {
        System.out.println("Животное: " + String.valueOf(this.getClass()).replaceAll("^.*\\.", "") + " имя: " + this.name + ",  скорость бега: " + this.runSpeed + ", выносливость: " + this.endurance);
    }
}
