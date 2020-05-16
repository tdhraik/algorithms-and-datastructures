package test.java.twopointers;

import main.java.twopointers.SquaringSortedArr;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SquaringSortedArrTests {

    private final SquaringSortedArr squaringSortedArr =
            new SquaringSortedArr();

    @Test
    void shouldReturnSquaredArr() {
        int[] arr = {-2,-1,0,2,3};

        assertArrayEquals(new int[]{0,1,4,4,9}, squaringSortedArr.squareArr(arr));
    }
}
