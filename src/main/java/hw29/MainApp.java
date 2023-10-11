package hw29;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {
    private static final Counter counter = new Counter();
    private static final Object mon = new Object();

    public static void main(String[] args)  {
        ExecutorService service = Executors.newFixedThreadPool(3);
        counter.setValue(1);
        service.execute(() -> {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (counter.getValue() != 1) {
                            mon.wait();
                        }
                        counter.setValue(2);
                        System.out.print("A");
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        service.execute(() -> {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (counter.getValue() != 2) {
                            mon.wait();
                        }
                        counter.setValue(3);
                        System.out.print("B");
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        service.execute(() -> {
            synchronized (mon) {
                try {
                    for (int i = 0; i < 5; i++) {
                        while (counter.getValue() != 3) {
                            mon.wait();
                        }
                        counter.setValue(1);
                        System.out.print("C");
                        mon.notifyAll();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        service.shutdown();
    }
}
