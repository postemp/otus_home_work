package Hw10.Box;

import java.util.Arrays;

public class Box {
    private String color;
    private int[] size;
    private boolean opened;
    private String item;

    public void setColor(String color) {
        this.color = color;
    }

    public Box(int[] size, String color) {
        this.size = size;
        this.color = color;
    }

    public void open() {
        System.out.println("Открываем коробку");
        this.opened = true;
    }

    public void close() {
        System.out.println("Закрываем коробку");
        this.opened = false;
    }

    public void info() {
        System.out.print("size = " + Arrays.toString(this.size) + " color = " + this.color + " ");
        if (this.item != null) {
            System.out.println("В коробке лежит " + this.item);
            return;
        }
        System.out.println("В коробке пусто");
    }

    public void addItem(String item) {
        if (this.item != null) {
            System.out.println("В коробке уже лежит " + this.item);
            return;
        }
        if (this.opened == false) {
            System.out.println("Коробка закрыта, положить не можем");
            return;
        }
        System.out.println("Положили в коробку " + item);
        this.item = item;
    }

    public void removeItem() {
        if (this.opened == false) {
            System.out.println("Коробка закрыта, вытащить ничего не можем");
            return;
        }
        if (this.item != null) {
            System.out.println("Убрали из коробки " + this.item);
            this.item = null;
            return;
        }
        System.out.println("Коробка и так пустая, что вы собрались вытащить?");
    }


}
