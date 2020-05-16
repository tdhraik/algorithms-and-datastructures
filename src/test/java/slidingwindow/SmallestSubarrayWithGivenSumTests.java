package test.java.slidingwindow;

import main.java.slidingwindow.SmallestSubarrayWithGivenSum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SmallestSubarrayWithGivenSumTests {

    private final SmallestSubarrayWithGivenSum clazz = new SmallestSubarrayWithGivenSum();

    @Test
    void shouldReturnSizeOfSmallestSubarrayWithGivenSum() {
        // given
        int[] arr = {2,1,5,2,3,2};
        int sum = 7;

        // assertion
        assertEquals(2, clazz.smallestSubarrayWithGivenSum(arr, sum));
    }
}
