package main.java.topKelements;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given an unsorted array of numbers, find the top ‘K’ frequently occurring numbers in it.
 *
 * Input: [1, 3, 5, 12, 11, 12, 11], K = 2
 * Output: [12, 11]
 * Explanation: Both '11' and '12' appeared twice.
 *
 * Input: [5, 12, 11, 3, 11], K = 2
 * Output: [11, 5] or [11, 12] or [11, 3]
 * Explanation: Only '11' appeared twice, all other numbers appeared once.
 *
 */
class TopKFrequentNumbers {

    private int[] getTopKFrequentNumbers(int[] numbers, int k) {
        Map<Integer, Integer> numFreq = new HashMap<>();
        for(int n : numbers) {
            numFreq.put(n, numFreq.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
                Comparator.comparingInt(Map.Entry::getValue)
        );
        for(Map.Entry<Integer, Integer> numFreqMap : numFreq.entrySet()) {
            minHeap.offer(numFreqMap);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return new int[]{minHeap.poll().getKey(), minHeap.poll().getKey()};
    }

    @Test
    void shouldReturnTopKFrequentNumbers() {
        // given
        int[] numbers = {1,3,5,12,11,12,11};
        int k =2;

        // assert
        assertArrayEquals(new int[]{12,11}, getTopKFrequentNumbers(numbers, k));
    }

}
