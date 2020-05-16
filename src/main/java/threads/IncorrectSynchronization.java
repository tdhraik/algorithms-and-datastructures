package main.java.threads;

import org.junit.jupiter.api.Test;

/**
 * A classic newbie mistake is to synchronize on an object and then somewhere in the code reassign the object.
 * As an example, look at the code below. We synchronize on a Boolean object in the first thread but sleep before
 * we call wait() on the object. While the first thread is asleep, the second thread goes on to change the flag's value.
 * When the first thread wakes up and attempts to invoke wait(), it is met with a IllegalMonitorState exception!
 * The object the first thread synchronized on before going to sleep has been changed,
 * and now it is attempting to call wait() on an entirely different object without having synchronized on it.
 *
 */
class IncorrectSynchronization {

    class Operations {

        Boolean flag = false;

        void startExample() throws InterruptedException {
            Thread t1 = new Thread(() -> {
                while(flag == false){
                    synchronized (flag) {
                        try {
                            System.out.println("Flag is false");
                            Thread.sleep(10000);
                            System.out.println("thread woke up");
                            // object invoking wait should be same that made it enter synchronized block.
                            // wait(), notify() etc. must be called only inside synchronized blocks
                            flag.wait(); // throws exception since flag is changed while this was asleep by thread 2 (t2)
                        } catch(InterruptedException e){
                        }
                    }
                }
            });

            Thread t2 = new Thread(() -> {
                flag = true;
                System.out.println("Flag set to true");
            });

            t1.start();
            t2.start();

            t1.join();
            t2.join();
        }
    }

    @Test
    void triggerExample() throws InterruptedException {
        Operations operations = new Operations();
        operations.startExample();
    }

}
