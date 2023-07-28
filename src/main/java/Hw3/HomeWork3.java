package Hw3;

import java.util.Scanner;

public class HomeWork3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число от одного до пяти для выбора метода");
        int result = scanner.nextInt();
        System.out.println(result);

        switch (result) {
            case 1:
                greetings();
                break;
            case 2:
                checkSign((int) (Math.random() * 10),  (int) (Math.random() * 5) - 10, (int) (Math.random() * 50)-10);
                break;
            case 3:
                selectColor();
                break;
            case 4:
                compareNumbers();
                break;
            case 5:
                addOrSubtractAndPrint((int) (Math.random() * 5) + 10, (int) (Math.random() * 5) + 10, Math.random() < 0.5);
                break;
            default:
                System.out.println("вы ввели другое число");
        }
    }

    public static void greetings() {
        System.out.println("Hello,\nWorld,\nfrom,\nJava");
    }

    public static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        System.out.println("sum =" + sum);
        if (sum >= 0) {
            System.out.println("Сумма положительная");
        } else {
            System.out.println("Сумма отрицательная");
        }
    }

    public static void selectColor() {
        int data = 200;
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    public static void compareNumbers() {
        int a = 4;
        int b = 4;
        if (a >= b) {
            System.out.println(" a >= b");
        } else {
            System.out.println("a < b");
        }
    }

    public static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        System.out.println("increment = " + increment);
        if (increment) {
            System.out.println("result =" + (initValue + delta));
        } else {
            System.out.println("result =" + (initValue - delta));
        }
    }
}
