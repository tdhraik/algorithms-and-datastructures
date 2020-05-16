package main.java.threads;


import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;

/**
 * TODO : a.k.a. consumer producer problem, bounded buffer problem or blocking queue problem
 * A blocking queue is defined as a queue which blocks the caller of the enqueue method if there's no more capacity to
 * add the new item being enqueued. Similarly, the queue blocks the dequeue caller if there are no items in the queue.
 * Also, the queue notifies a blocked enqueuing thread when space becomes available and a blocked dequeuing thread
 * when an item becomes available in the queue.
 *
 */
class BlockingQueue {

    class Q {

        private Queue<Integer> q = new LinkedList<>();

        Queue<Integer> getQ() {
            return q;
        }

        void add(Integer n) throws InterruptedException {
            synchronized (this) {
                if (q.size() >= 3) {
                    System.out.println("Sorry! Q is full, please wait...");
                    this.wait();
                    q.offer(n);
                } else {
                    q.offer(n);
                }
                this.notifyAll();
            }
        }

        Optional<Integer> remove() throws InterruptedException {
            Optional<Integer> valueRemoved;
            synchronized (this) {
                if (q.size() == 0) {
                    System.out.println("Queue is empty!");
                    valueRemoved = Optional.empty();
                    this.wait();
                } else {
                    valueRemoved = Optional.of(q.poll());
                    System.out.println(Thread.currentThread().getName());
                    this.notifyAll();
                    Thread.sleep(5000);
                }
            }
            return valueRemoved;
        }
    }

    @Test
    void shouldAddAndRemoveFromQ() throws InterruptedException {
        Q q = new Q();
        Thread enqueueQ = new Thread(() -> {
            try {
                q.add(1);
                q.add(2);
                q.add(3);
                q.add(4);
                q.add(5);
            } catch(InterruptedException e){
                System.out.println("YOYO, exception!!!");
            }
        });

        Thread dequeueQ = new Thread(() -> {
            try {
                int i = q.getQ().size();
                while (i >= 0) {
                    q.remove().ifPresent(System.out::println);
                    i--;
                }
            } catch( InterruptedException e) {
                System.out.println("YOYO, second exception!!!");
            }
        });

        enqueueQ.start();
        dequeueQ.start();

        enqueueQ.join();
        dequeueQ.join();
    }
}
