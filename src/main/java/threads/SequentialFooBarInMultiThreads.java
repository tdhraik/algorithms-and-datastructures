package main.java.threads;

/**
 * Suppose there are two threads t1 and t2. t1 prints Foo and t2 prints Bar. You are required
 * to write a program which takes a user input n. Then the two threads print Foo and Bar alternately n number of times.
 */
public class SequentialFooBarInMultiThreads {

    public static void main(String[] args) throws InterruptedException {
        Integer n = Integer.valueOf(args[0]);
        PrintFooBar pfb = new PrintFooBar(n);

        Thread t1 = new Thread(() -> {
            try {
                pfb.PrintFoo();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                pfb.PrintBar();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    static class PrintFooBar {

        private Integer n;
        private boolean isFooDone = false;
        private boolean isBarDone = true;

        PrintFooBar(Integer n) {
            this.n = n;
        }

        void PrintFoo() throws InterruptedException {
            for (int i = 1; i <= n;  i++){
                synchronized (this) {
                    if(!isBarDone) {
                        this.wait();
                    }
                    System.out.print("Foo");
                    isFooDone = true;
                    isBarDone = false;
                    this.notifyAll();
                }
            }
        }

        void PrintBar() throws InterruptedException {
            for (int i = 1; i <= n; i++) {
                synchronized (this) {
                    if(!isFooDone) {
                        this.wait();
                    }
                    System.out.print("Bar");
                    isBarDone = true;
                    isFooDone = false;
                    this.notifyAll();
                }
            }
        }
    }
}
