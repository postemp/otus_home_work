package hw29;

public class Counter {
    protected int value;

    public void setValue(int value) {
        this.value = value;
        System.out.println("Counter value after setting:" + value);
    }

    public int getValue() {
        return value;
    }

    public void inc() {
        value++;
//        System.out.println("Увеличили счетчик" + value);
    }
    public void dec() {
        value--;
//        System.out.println("Уменьшили счетчик" + value);
    }
}
