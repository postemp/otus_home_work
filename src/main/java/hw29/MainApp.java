package hw29;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {
        private static Counter counter = new Counter();
    private static final Object mon = new Object();

    private static int cntr[] = new int[3];

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        cntr[0] = 0;
        ExecutorService service = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 10; i++) {
            service.execute(() -> {
                        synchronized (mon) {
//                            while (counter.value != 0) {
                            while (cntr[0] == 1) {
                                try {
                                    mon.wait();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            System.out.println("A");
//                            counter.inc();
                            cntr[0] = 1;
                            mon.notifyAll();

                        }

                    }
            );
            service.execute(() -> {
                        synchronized (mon) {
//                            while (counter.value != 1) {
                            while (cntr[0] == 0) {

                                try {
                                    mon.wait();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            System.out.println("B");
//                            counter.dec();
                            cntr[0] = 0;
                            mon.notifyAll();

                        }
                    }
            );
//            service.execute(() -> {
//                        System.out.println("C");
//                    }
//            );

        }
        service.shutdown();
    }


}
