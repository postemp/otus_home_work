package hw29;

public class PrintABApp {
    private final Object mon = new Object();

    private Counter counter = new Counter();


    public static void main(String[] args) throws InterruptedException {
        PrintABApp waitNotifyApp = new PrintABApp();
        new Thread(
                () -> {
                    try {
                        waitNotifyApp.printA();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).start();
        new Thread(
                () -> {
                    try {
                        waitNotifyApp.printB();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
        ).start();
    }

    public void printA() throws InterruptedException {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (counter.value != 0) {
                        mon.wait();
                    }
                    counter.inc();
                    mon.notifyAll();
                    System.out.println("A");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void printB() throws InterruptedException {
        synchronized (mon) {
            try {
                for (int i = 0; i < 10; i++) {
                    while (counter.value != 1) {
                        mon.wait();
                    }
                    counter.dec();
                    mon.notifyAll();

//                    Thread.sleep(1);

                    System.out.println("B");

                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
