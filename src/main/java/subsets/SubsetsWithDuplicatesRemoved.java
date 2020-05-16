package main.java.subsets;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Given a set of numbers that might contain duplicates, find all of its distinct subsets.
 * Input: [1, 3, 3]
 * Output: [], [1], [3], [1,3], [3,3], [1,3,3]
 *
 * Input: [1, 5, 3, 3]
 * Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3], [3,3], [1,3,3], [3,3,5], [1,5,3,3]
 */
class SubsetsWithDuplicatesRemoved {

    private List<List<Integer>> getUniqueSubsets(List<Integer> numbers) {
        if(numbers == null) {
            return new ArrayList<>();
        }
        if(numbers.isEmpty()){
            return Collections.singletonList(new ArrayList<>());
        }
        Collections.sort(numbers);
        List<List<Integer>> uniqueSubsets = new ArrayList<>();
        List<Integer> firstElement = new ArrayList<>();
        uniqueSubsets.add(firstElement);

        for(Integer n : numbers) {
            int size = uniqueSubsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> copyAndAddNewList = new ArrayList<>(uniqueSubsets.get(i));
                copyAndAddNewList.add(n);
                if(!uniqueSubsets.contains(copyAndAddNewList)) {
                    uniqueSubsets.add(copyAndAddNewList);
                }
            }
        }
        return uniqueSubsets;
    }

    @Test
    void should_ReturnEmpty_When_InputIsNull() {
        List<Integer> numbers = null;
        assertEquals( 0, getUniqueSubsets(numbers).size());
    }

    @Test
    void should_ReturnEmpty_When_InputIsEmpty() {
        List<Integer> numbers = new ArrayList<>();
        assertEquals( 1, getUniqueSubsets(numbers).size());
        assertEquals( 0, getUniqueSubsets(numbers).get(0).size());
    }

    @Test
    void should_ReturnUniquePairs_When_InputIsCorrectWithOnly1UniqueValue() {
        // given
        List<Integer> numbers = Arrays.asList(1,1);
        List<List<Integer>> expectedOutput = Arrays.asList(
                new ArrayList<>(),
                Collections.singletonList(1),
                Arrays.asList(1,1)
        );

        // assertions
        assertEquals(expectedOutput, getUniqueSubsets(numbers));
    }

    @Test
    void should_ReturnUniquePairs_When_InputIsCorrectAndDuplicatesAreTogether() {
        // given
        List<Integer> numbers = Arrays.asList(1,3,3);
        List<List<Integer>> expectedOutput = Arrays.asList(
                new ArrayList<>(),
                Collections.singletonList(1),
                Collections.singletonList(3),
                Arrays.asList(1,3),
                Arrays.asList(3,3),
                Arrays.asList(1,3,3)
        );

        // assertions
        assertEquals(expectedOutput, getUniqueSubsets(numbers));
    }

    @Test
    void should_ReturnUniquePairs_When_InputIsCorrectAndDuplicatesAreNotTogether() {
        // given
        List<Integer> numbers = Arrays.asList(3,1,3);
        List<List<Integer>> expectedOutput = Arrays.asList(
                new ArrayList<>(),
                Collections.singletonList(1),
                Collections.singletonList(3),
                Arrays.asList(1,3),
                Arrays.asList(3,3),
                Arrays.asList(1,3,3)
        );

        // assertions
        assertEquals(expectedOutput, getUniqueSubsets(numbers));
    }
}
