package main.java.threads;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Imagine you have a bucket that gets filled with tokens at the rate of 1 token per second.
 * The bucket can hold a maximum of N tokens. Implement a thread-safe class that lets threads get a token when one is available.
 * If no token is available, then the token-requesting threads should block.
 *
 * The class should expose an API called getToken that various threads can call to get a token
 *
 */
class TokenBucketFilterAlgo {

    private static final int N = 10;
    private static int tokenSource = 0;

    class TokenBucket {
        Queue<Integer> tokens = new LinkedList<>();
        void add(int token) throws InterruptedException {
            synchronized (this) {
                if (tokens.size() < N) {
                    System.out.println("ADDING => " + token);
                    tokens.offer(token);
                    this.notify();
                } else {
                    tokenSource--;
                    this.wait();
                }
            }
        }

        void remove() throws InterruptedException {
            synchronized (this) {
                if (tokens.size() > 0) {
                    System.out.println("REMOVING" + tokens.peek());
                    tokens.poll();
                    this.notify();
                } else {
                    this.wait();
                }
            }
        }
    }

    private void trigger() throws InterruptedException {

        TokenBucket tokenBucket = new TokenBucket();
        Thread t1 = new Thread( () -> {
            try {
                while(tokenSource < 100) {
                    tokenBucket.add(tokenSource++);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2 = new Thread( () -> {
            try {
                while(true) {
                    tokenBucket.remove();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        Thread.sleep(1000);
        t2.start();

        t1.join();
        System.out.println("ADDING ENDED");
        t2.join();
    }

    @Test
    void start() throws InterruptedException {
        trigger();
    }
}
