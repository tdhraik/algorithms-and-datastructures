package main.java.threads;

public class AsyncToSyncProblem {
    public static void main(String args[]) throws Exception {
        Executor executor = new Executor();
        Thread t = new Thread( () -> {
            try {
                executor.asynchronousExecution(() -> {
                    System.out.println("I am done");
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread( () -> { System.out.println("main thread exiting..."); });

        t.start();
        t.join();

        t2.start();
        t2.join();
    }

    interface Callback {
        void done() throws Exception;
    }


    static class Executor {
        void asynchronousExecution(Callback callback) throws Exception {
            Thread t = new Thread(() -> {
                // Do some useful work
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ie) {
                }
                try {
                    callback.done();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            t.start();
        }
    }
}
