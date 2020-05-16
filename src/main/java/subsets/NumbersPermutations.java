package main.java.subsets;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Given a set of distinct numbers, find all of its permutations.
 * Input: [1,3,5]
 * Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
 */
class NumbersPermutations {

    private List<List<Integer>> getAllPermutations(List<Integer> numbers) {
        if(numbers == null) {
            throw new IllegalStateException();
        }
        List<List<Integer>> allPermutations = new ArrayList<>();
        if(numbers.isEmpty()) {
            allPermutations.add(new ArrayList<>());
            return allPermutations;
        }

        Queue<List<Integer>> permutations = new LinkedList<>();
        permutations.offer(Collections.singletonList(numbers.get(0)));
        for (int i = 1; i < numbers.size(); i++) {
            int n = numbers.get(i);
            int size = permutations.size();
            for (int j = 0; j < size; j++) {
                List<Integer> oldPermutation = permutations.poll();
                for (int k = oldPermutation.size(); k >= 0; k--) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(k, n);
                    if(newPermutation.size() == numbers.size()) {
                        allPermutations.add(newPermutation);
                    }else{
                        permutations.offer(newPermutation);
                    }
                }
            }
        }
        return allPermutations;
    }

    @Test
    void shouldReturnIllegalStateException_When_InputIsNull() {
        // given
        List<Integer> input = null;

        // assert
        assertThrows(IllegalStateException.class, () -> getAllPermutations(input));
    }

    @Test
    void shouldReturnEmptyList_When_InputIsEmpty() {
        // given
        List<Integer> input = new ArrayList<>();

        // assert
        assertEquals(1, getAllPermutations(input).size());
    }

    @Test
    void shouldReturnAllPermutations_When_InputIsCorrect() {
        // given
        List<Integer> input = List.of(1,2,3);
        List<List<Integer>> expectedOutput = List.of(
                Arrays.asList(1,2,3),
                Arrays.asList(1,3,2),
                Arrays.asList(2,1,3),
                Arrays.asList(2,3,1),
                Arrays.asList(3,1,2),
                Arrays.asList(3,2,1)
        );

        // assert
        assertEquals(expectedOutput, getAllPermutations(input));
    }

}
