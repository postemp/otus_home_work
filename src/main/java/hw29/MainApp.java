package hw29;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainApp {
    private static Counter counter = new Counter();
    private static final Object mon = new Object();


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
             counter.value = 1;
            service.execute(() -> {
                        synchronized (mon) {
                            while (counter.getValue() != 1) {
                                try {
                                    mon.wait();
                                } catch (InterruptedException e) {
                                    System.out.printf("A InterruptedException");
                                    throw new RuntimeException(e);
                                }
                            }
//                            System.out.println("A "+ counter.value);
                            System.out.println("A");

                            counter.setValue(2);
                            mon.notifyAll();
                        }

                    }
            );
            service.execute(() -> {
                        synchronized (mon) {
                            while (counter.getValue() != 2) {
                                try {
                                    mon.wait();
                                } catch (InterruptedException e) {
                                    System.out.printf("B InterruptedException");
                                    throw new RuntimeException(e);
                                }
                            }
//                            System.out.println("B "+ counter.value);
                            System.out.println("B");
                            counter.setValue(3);
                            mon.notifyAll();

                        }
                    }
            );
            service.execute(() -> {
                        synchronized (mon) {
                            while (counter.getValue() != 3) {
                                try {
                                    mon.wait();
                                } catch (InterruptedException e) {
                                    System.out.printf("C InterruptedException");
                                    throw new RuntimeException(e);
                                }
                            }
//                            System.out.println("C " + counter.value);
                            System.out.println("C");
                            counter.setValue(1);
                            mon.notifyAll();
                        }
                    }
            );
        }
        service.shutdown();
    }


}
