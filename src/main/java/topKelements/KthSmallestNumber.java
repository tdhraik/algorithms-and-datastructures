package main.java.topKelements;

import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an unsorted array of numbers, find Kth smallest number in it.
 * Input: [1, 5, 12, 2, 11, 5], K = 3
 * Output: 5
 * Explanation: The 3rd smallest number is '5', as the first two smaller numbers are [1, 2].
 *
 */
class KthSmallestNumber {

    private int getKthSmallestNumber(int[] numbers, int k) {

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((n1,n2) -> n2-n1);

        for (int i = 0; i < k; i++) {
            maxHeap.offer(numbers[i]);
        }

        for (int i = k; i < numbers.length; i++) {
            if(numbers[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(numbers[k]);
            }
        }
        return maxHeap.peek();
    }

    @Test
    void shouldReturnKthSmallestNumber() {
        // given
        int[] numbers = {1,5,12,2,11,5};
        int k=3;

        // assert
        assertEquals(5, getKthSmallestNumber(numbers, k));
    }

}
