package hw21;

public class MainApp {
    public static void main(String[] args) {
        long t = System.currentTimeMillis();
        sequentialFilling();
        System.out.println("Время, затраченное на заполнение массива последовательно:" + (System.currentTimeMillis() - t));
        t = System.currentTimeMillis();
        parallelFilling();
        System.out.println("Время, затраченное на заполнение массива параллельно:" + (System.currentTimeMillis() - t));

    }

    public static void sequentialFilling() {
        double[] dArray = new double[10_000_000];
        for (int i = 0; i < dArray.length; i++) {
            dArray[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
        }
    }

    public static void parallelFilling() {
        double[] dArray = new double[10_000_000];

        for (int j = 0; j < 4; j++) {
            int counter = j;
            new Thread(
                    () -> {
                        int inc;
                        for (int i = 0; i < dArray.length ; i = i + 4 ) {
                            inc = i + counter;
                            dArray[inc] = 1.14 * Math.cos(inc) * Math.sin(inc * 0.2) * Math.cos(inc / 1.2);;
                        }
                    }
            ).start();
        }
    }
}

