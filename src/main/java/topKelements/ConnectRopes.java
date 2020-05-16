package main.java.topKelements;


import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given ‘N’ ropes with different lengths, we need to connect these ropes into one big rope with minimum cost.
 * The cost of connecting two ropes is equal to the sum of their lengths.
 * Input: [1, 3, 11, 5, 2]
 * Output: 42
 * Explanation: First connect 1+2(=3), then 3+3(=6), 6+5(=11), 11+11(=22). Total cost is 42 (3+6+11+22)
 *
 * Input: [3, 4, 5, 6]
 * Output: 36
 * Explanation: First connect 3+4(=7), then 5+6(=11), 7+11(=18). Total cost is 36 (7+11+18)
 */
class ConnectRopes {

    private int getMinimumCostOfConnectingRopes(int[] numbers) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < numbers.length; i++) {
            minHeap.offer(numbers[i]);
        }
        int sum = 0;
        while(minHeap.size()>1){
            sum = minHeap.poll() + minHeap.poll();
            minHeap.offer(sum);
        }
        return sum + minHeap.poll();
    }

    @Test
    void shouldReturnMinimumCost() {
        // given
        int[] numbers = {3,4,5,6};

        //assert
        assertEquals(36, getMinimumCostOfConnectingRopes(numbers));
    }

}
