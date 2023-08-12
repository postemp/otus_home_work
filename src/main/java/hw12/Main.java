package hw12;

public class Main {
    public static void main(String[] args) {
        Cat vaska = new Cat("Vaska",10, "street");
        Cat barsik = new Cat("Barsik",10, "street");
//        barsik.breed = null;
        if (barsik.equals(vaska)){
            System.out.println("true");
        }

    }
}
