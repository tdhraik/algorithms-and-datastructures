package main.java.subsets;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set with distinct elements, find all of its distinct subsets.
 * Input: [1, 5, 3]
 * Output: [], [1], [5], [3], [1,5], [1,3], [5,3], [1,5,3]
 */
class Subsets {

    private List<List<Integer>> getSubsets(List<Integer> set) {
        List<List<Integer>> subsets = new ArrayList<>();
        subsets.add(new ArrayList<>());
        for(Integer s : set) {
            int size = subsets.size();
            for (int i = 0; i < size; i++) {
                List<Integer> nextSet = new ArrayList<>(subsets.get(i));
                nextSet.add(s);
                subsets.add(nextSet);
            }
        }
        return subsets;
    }

    @Test
    void shouldReturnSubsets() {
        List<Integer> set = Arrays.asList(1,5,3);
        System.out.println(getSubsets(set));
    }
}
