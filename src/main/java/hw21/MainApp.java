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
        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = 0; i < dArray.length / 2 / 2; i++) {
                            dArray[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                        }
                    }
                }
        );
        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = dArray.length / 2 / 2 + 1; i < dArray.length / 2; i++) {
                            dArray[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                        }
                    }
                }
        );
        Thread thread3 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = dArray.length / 2 + 1; i < dArray.length / 2  + dArray.length / 2 / 2; i++) {
                            dArray[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                        }
                    }
                }
        );
        Thread thread4 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        for (int i = dArray.length / 2 + dArray.length / 2 / 2 + 1; i < dArray.length; i++) {
                            dArray[i] = 1.14 * Math.cos(i) * Math.sin(i * 0.2) * Math.cos(i / 1.2);
                        }
                    }
                }
        );
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

