package test.java.slidingwindow;

import main.java.slidingwindow.MaxSumSubarraySizeK;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaxSumSubarraySizeKTests {

    private final MaxSumSubarraySizeK maxSumSubarraySizeK = new MaxSumSubarraySizeK();

    @Test
    public void shouldReturnCorrectSum() {
        int[] arr1 = {2, 1, 5, 1, 3, 2};
        int size1 = 3;

        int[] arr2 = {2,3,4,1,5};
        int size2 = 2;

        // assertion
        assertEquals(9, maxSumSubarraySizeK.maxSubArraySumSizeK(arr1, size1));
        assertEquals(7, maxSumSubarraySizeK.maxSubArraySumSizeK(arr2, size2));
    }
}
