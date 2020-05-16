package test.java.twopointers;

import main.java.twopointers.PairWithTargetSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class PairWithTargetSumTests {

    private final PairWithTargetSum pairWithTargetSum =
            new PairWithTargetSum();

    @Test
    void shouldReturnThePair() {
        int[] arr = {1,2,3,4,6};
        int targetSum = 6;

        int[] arr_1 = {2,5,9,11};
        int targetSum_1 = 11;

        assertArrayEquals(new int[]{1,3}, pairWithTargetSum.getIndicesWithTargetSum(arr, targetSum));
        assertArrayEquals(new int[]{0,2}, pairWithTargetSum.getIndicesWithTargetSum(arr_1, targetSum_1));
    }
}
