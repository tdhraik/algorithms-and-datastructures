package main.java.topKelements;


import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an unsorted array of numbers, find the ‘K’ largest numbers in it.
 * Input: [5, 12, 11, -1, 12], K = 3
 * Output: [12, 11, 12]
 *
 * Have to create a min-heap because we want the minimum at all times to be present at the
 * root node, so that it can be removed if the next new number to add is greater than our
 * root node. And with min-heap we can do that in constant time
 */
class TopKLargestNumber {

    private Optional<Integer> getKthLargestNumber(int[] numbers, int k) {

        if(numbers==null) {
            return Optional.empty();
        }

        if(numbers.length == 0){
            return Optional.empty();
        }

        if(numbers.length < k) {
            throw new IllegalStateException();
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.add(numbers[i]);
        }
        for (int i = k; i < numbers.length; i++) {
            if(numbers[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.add(numbers[i]);
            }
        }
        return Optional.ofNullable(minHeap.peek());
    }

    @Test
    void shouldReturnLargestNumber() {
        // given
        int[] numbers = {3,1,5,12,2,11};
        int k = 4;

        // assert
        assertEquals(3, getKthLargestNumber(numbers, k).orElse(-1));
    }

}
