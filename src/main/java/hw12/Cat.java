package hw12;

public class Cat {
    private final String  name;
    private final int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public boolean getFullness(){
        if (this.fullness) {
            System.out.println("Кот " + this.name + " наелся");
            return true;
        }
        System.out.println("Кот " + this.name + " голодный");
        return false;

    }

    public void eat(Plate plate) {
        if (this.fullness ) {
            System.out.println("Кот " + this.name + " не хочет кушать");
            return;
        }
        if (plate.eat(this.appetite)) {
            this.fullness = true;
            System.out.println("Кот " + this.name + " поел");
            return;
        }
        System.out.println("Недостаточно еды для кота " + this.name);
    }
}
