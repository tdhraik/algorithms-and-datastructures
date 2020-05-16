package test.java.arrays;

import main.java.arrays.Merge2SortedArrays;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Merge2SortedArraysTests {

    private final Merge2SortedArrays merge2SortedArrays
            = new Merge2SortedArrays();

    @Test
    void shouldReturnMergedSortedArray() {
        int[] arr_1 = {1,5,7,9};
        int[] arr_2 = {2,6,8,10};

        assertArrayEquals(new int[]{1,2,5,6,7,8,9,10}, merge2SortedArrays.mergeAndSortArrays(arr_1, arr_2));
    }
}
